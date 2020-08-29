package Dijkstra_DistanceAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PartyInvite {//5567번
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int Friends = input.nextInt();
		int relation = input.nextInt();
		int[] redst = new int[Friends+1];
		boolean[] visited = new boolean[Friends+1];
		Arrays.fill(redst , Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		redst[1] = 0; visited[1] = true; visited[0] = true;
		HashMap<Integer,ArrayList> relations = new HashMap<Integer,ArrayList>();
		for(int p = 1; p < Friends+1; p++) {
			relations.put(p,new ArrayList<Integer>());
		}
		ArrayList m = new ArrayList<Integer>();
		int src = 0; int dst = 0;
		for(int k = 0; k < relation; k++) {
			src = input.nextInt();
			dst = input.nextInt();
			if(src != dst) {
				m = relations.get(src); m.add(dst);
				relations.put(src,m);
				m = relations.get(dst); m.add(src);
				relations.put(dst,m);
				if(src == 1) {
					redst[dst] = 1;
				}else if(dst == 1) {
					redst[src] = 1;
				}
			}
		}
		int loopCount = 0; 
		int least = Integer.MAX_VALUE; int Location = 0;
		ArrayList<Integer> yourRelation = new ArrayList<Integer>(); 
		while(loopCount < Friends-1) {
			for(int i = 2; i < Friends+1; i++) {
				if(visited[i] == false && redst[i] < least) {
					least = redst[i];
					Location = i;
				}
			}
			visited[Location] = true;
			yourRelation = relations.get(Location);
			if(yourRelation != null) {
				for(int friends : yourRelation) {
					if(redst[Location]+1 < redst[friends]) {
						redst[friends] = redst[Location]+1;
					}
				}
			}
			loopCount++; least = Integer.MAX_VALUE;
		}
		int invitePeople = 0;
		for(int p = 2; p < Friends+1; p++) {
			if(redst[p] < 3) {
				invitePeople++;
			}
		}
		System.out.println(invitePeople);
	}
}
