//swexpert : 9229 : 한빈이 과자 문제
package day0127;

import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			int N = 0, M = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if ((arr[i] + arr[j]) > max && (arr[i] + arr[j]) <= M) {
						max = (arr[i] + arr[j]);
					}
				}
			}

			System.out.println("#"+tc+" "+max);
		}

	}

}