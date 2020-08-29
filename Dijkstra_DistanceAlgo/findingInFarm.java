package Dijkstra_DistanceAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class findingInFarm {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] farm = new int[N+1];
		int[] visited = new int[N+1];
		Arrays.fill(farm,Integer.MAX_VALUE);  farm[1] = 0;
		visited[0] = 1; visited[1] = 1;
		HashMap<Integer,ArrayList> map = new HashMap<Integer,ArrayList>();
		for(int i = 1; i < N+1; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		int M = input.nextInt();
		int a = 0; int b = 0;
		ArrayList p = new ArrayList();
		for(int k = 0; k < M; k++) {
			a = input.nextInt(); b = input.nextInt();
			if(a != b) {
				p = map.get(a); p.add(b);
				map.put(a,p);
				p = map.get(b); p.add(a);
				map.put(b,p);
				if(a == 1) {
					farm[b] = 1;
				}else if(b == 1){
					farm[a] = 1;
				}
			}
		}
		int loopCount = 0;
		int schLocation = 2; int leastDst = Integer.MAX_VALUE;
		ArrayList<Integer> schList = new ArrayList<Integer>();
		while(loopCount < N-1) {
			for(int k = 2; k < N+1; k++) {
				if(farm[k] < leastDst && visited[k] == 0) {
					schLocation = k;
					leastDst = farm[k];
				}
			}
			visited[schLocation] = 1;
			schList = map.get(schLocation);
			for(int load : schList) {
				if(farm[schLocation]+1<farm[load]) {
					farm[load] = farm[schLocation]+1;
				}
			}
			leastDst = Integer.MAX_VALUE;
			loopCount++;
		}
		int answer = 0; int Loc = 1; int same = 0;
		for(int u = 1; u < N+1; u++) {
			if(farm[u] > answer) {
				answer = farm[u];
				Loc = u;
			}
		}
		for(int y = 1; y < N+1; y++) {
			if(farm[y] == answer) {
				same++;
			}
		}
		System.out.println(Loc+" "+answer+" "+same);
	}
}
