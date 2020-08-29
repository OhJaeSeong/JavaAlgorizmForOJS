package Dijkstra_DistanceAlgo;

import java.util.Scanner;

public class WhoIsZelda {
	static boolean Clear(int[][] c, int sizeOfMiro) {
		for(int p = 0; p < sizeOfMiro; p++) {
			for(int k = 0; k < sizeOfMiro; k++) {
				if(p == sizeOfMiro-1 && k == sizeOfMiro-1) {
					return true;
				}
				if(c[p][k] == 0) {
					return false;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int ProbNum = 1;
		Scanner input = new Scanner(System.in);
		int sizeOfMiro = input.nextInt();
		while(sizeOfMiro != 0) {
			int[][] Miro = new int[sizeOfMiro][sizeOfMiro];
			int[][] least = new int[sizeOfMiro][sizeOfMiro];
			int[][] clear = new int[sizeOfMiro][sizeOfMiro];
			for(int g = 0; g < sizeOfMiro; g++) {
				for(int s = 0; s < sizeOfMiro; s++) {
					Miro[g][s] = input.nextInt();
					least[g][s] = Integer.MAX_VALUE;
				}
			}
			least[0][0] = Miro[0][0];
			int currentX = 0; int currentY = 0;
			clear[currentY][currentX] = 1;
			while(!Clear(clear,sizeOfMiro)) {
				if(currentX+1 < sizeOfMiro && least[currentY][currentX+1] > 
				least[currentY][currentX]+Miro[currentY][currentX+1]) {
					least[currentY][currentX+1] = least[currentY][currentX]+Miro[currentY][currentX+1];
				}
				if(currentY+1 < sizeOfMiro && least[currentY+1][currentX] > 
				least[currentY][currentX]+Miro[currentY+1][currentX]){
					least[currentY+1][currentX] = least[currentY][currentX]+Miro[currentY+1][currentX];
				}
				if(currentY-1 >= 0 && least[currentY-1][currentX] >
				least[currentY][currentX]+Miro[currentY-1][currentX]) {
					least[currentY-1][currentX] = least[currentY][currentX]+Miro[currentY-1][currentX];
				}
				if(currentX-1 >= 0 && least[currentY][currentX-1] >
				least[currentY][currentX]+Miro[currentY][currentX-1]) {
					least[currentY][currentX-1] = least[currentY][currentX]+Miro[currentY][currentX-1];
				}
				
				int minX = sizeOfMiro-1; int minY = sizeOfMiro-1; int distance = Integer.MAX_VALUE;
				for(int s = 0; s < sizeOfMiro; s++) {
					for(int g = 0; g < sizeOfMiro; g++) {
						if(!(s == sizeOfMiro-1 && g == sizeOfMiro-1) && least[s][g] < distance
								&& clear[s][g] == 0) {// 
							minY = s; minX = g;
							distance = least[s][g];
						}
					}
				}
				currentX = minX; currentY = minY;
				clear[currentY][currentX] = 1;
			}
			System.out.println("Problem "+ProbNum+": "+least[sizeOfMiro-1][sizeOfMiro-1]);
			sizeOfMiro = input.nextInt();
			ProbNum += 1;
		}
	}
}