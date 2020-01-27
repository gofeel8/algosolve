//swexpert:1244 최대 상금 문제
package day0127;

import java.util.Scanner;

public class Prize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			String num = sc.next();
			int size = num.length();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = num.charAt(i) - 48;
			}
			int th = sc.nextInt();
			int gps = -1;
			for (int i = 0; i < size - 1; i++) {
				int[] over = new int[size];
				int idx = -1;
				int max = arr[i];
				for (int k = i + 1; k < size; k++) {
					if (arr[k] > max) {
						idx = -1;
						max = arr[k];
						over[++idx] = k;
					} else if (arr[k] == max) {
						over[++idx] = k;
						if (idx == 1) {
							gps = arr[k];
						}
					}
				}

				int temp = arr[i];

				if (idx >= th) {
					arr[i] = arr[over[idx - th + 1]];
					arr[over[idx - th + 1]] = temp;
					th--;
					if (th == 0) {
						break;
					}
				} else if (idx > -1) {
					arr[i] = arr[over[idx]];
					arr[over[idx]] = temp;
					th--;
					if (th == 0) {
						break;
					}
				}

			}

			if (gps == -1) {

				for (int i = 0; i < th; i++) {
					int temp = arr[size - 1];
					arr[size - 1] = arr[size - 2];
					arr[size - 2] = temp;
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < size; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();

		}
	}

}
