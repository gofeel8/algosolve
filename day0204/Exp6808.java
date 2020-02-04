package gps0204;

import java.util.Arrays;
import java.util.Scanner;


public class Exp6808 {
	static int WC = 0;
	static int LC = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			WC = 0;
			LC = 0;
			int[] you = new int[9];
			for (int i = 0; i < 9; i++) {
				you[i] = sc.nextInt();
			}
			int[] my = new int[9];
			int[] mix = new int[9];
			int cnt = 0;
			for (int i = 1; i <= 18; i++) {
				boolean tf = false;
				for (int j = 0; j < 9; j++) {
					if (you[j] == i) {
						tf = true;
						break;
					}
				}
				if (tf == false) {
					my[cnt++] = i;
				}
			}

			boolean[] used = new boolean[9];
			win(you, my, mix, used, 0);
			System.out.println("#"+tc+" "+LC+" "+WC);
		}
	}

	public static void win(int[] you, int[] my, int[] mix, boolean[] used, int idx) {
		if (idx == mix.length) {
			int mysum = 0;
			int yousum = 0;
			for (int i = 0; i < 9; i++) {
				if (mix[i] > you[i]) {
					mysum += mix[i] + you[i];
				} else {
					yousum += mix[i] + you[i];
				}
			}
			if (mysum > yousum) {
				WC++;
			} else if (yousum > mysum) {
				LC++;
			}
		} else {
			for (int i = 0; i < my.length; i++) {
				if (used[i] == false) {
					mix[idx] = my[i];
					used[i] = true;
					win(you, my, mix, used, idx + 1);
					used[i] = false;
				}
			}
		}
	}

}
