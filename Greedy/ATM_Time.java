package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_Time {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int peopleNum = input.nextInt();
		int[] psTimes = new int[peopleNum];
		for(int p = 0; p < peopleNum; p++) {
			psTimes[p] = input.nextInt();
		}
		Arrays.sort(psTimes);
		int sum = 0;
		for(int k = 0; k <= psTimes.length; k++) {
			int middleSum = 0;
			for(int i = 0; i < k; i++) {
				middleSum += psTimes[i];
			}
			sum += middleSum;
			middleSum = 0;
		}
		System.out.println(sum);
	}
}
