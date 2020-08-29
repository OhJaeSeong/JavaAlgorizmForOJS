package Greedy;

import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int coinNumber = input.nextInt();
		int money = input.nextInt();
		int[] bills = new int[coinNumber];
		for(int p = 0; p < coinNumber; p++) {
			bills[p] = input.nextInt();
		}
		int coinCount = 0;
		for(int k = bills.length-1; k > -1; k--) {
			if(money/bills[k] >= 1) {
				coinCount = coinCount + (money/bills[k]);
				money = money - (money/bills[k])*bills[k];
			}
		}
		System.out.println(coinCount);
	}
}
