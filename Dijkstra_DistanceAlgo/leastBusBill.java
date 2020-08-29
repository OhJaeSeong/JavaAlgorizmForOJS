package Dijkstra_DistanceAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class leastBusBill {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cityCount = input.nextInt();
		int busCount = input.nextInt();
		int[][] bill = new int[cityCount][cityCount];
		boolean[] clear = new boolean[cityCount];
		int[] best = new int[cityCount];
		Arrays.fill(clear,false);
		Arrays.fill(best,Integer.MAX_VALUE);
		for(int k = 0; k < cityCount; k++) {
			Arrays.fill(bill[k],Integer.MAX_VALUE);
		}
		int start = 0; int destination = 0; int bills = 0;
		for(int num = 0; num < busCount; num++) {
			start = input.nextInt();
			destination = input.nextInt();
			bills = input.nextInt();
			if(bill[start-1][destination-1] != 0 && bill[start-1][destination-1] > bills) {
				bill[start-1][destination-1] = bills;
			}
		}
		int str = input.nextInt(); int dst = input.nextInt();
		str--; dst--;
		for(int search = 0; search < cityCount; search++) {
			if(bill[str][search] != Integer.MAX_VALUE) {
				best[search] = bill[str][search];
			}
		}
		int currentLocation = str; clear[str] = true; clear[dst] = true;
		int lowest = Integer.MAX_VALUE; int loopCount = 0;
		while(loopCount < cityCount-2) {
			lowest = Integer.MAX_VALUE;
			for(int s = 0; s < cityCount; s++) {
				if(clear[s] != true && best[s] < lowest) {
					lowest = best[s]; currentLocation = s;
				}
			}
			clear[currentLocation] = true;
			for(int search = 0; search < cityCount; search++) {
				if(bill[currentLocation][search] != Integer.MAX_VALUE && best[currentLocation]+bill[currentLocation][search] < best[search]) {
					best[search] = best[currentLocation]+bill[currentLocation][search];
				}
			}
			loopCount++;
		}
		System.out.println(best[dst]);
	}
}
