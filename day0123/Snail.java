//swexpert : 1954 : ¥ﬁ∆ÿ¿Ã πÆ¡¶
package day0127;

import java.util.Scanner;

public class Snail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			int size = sc.nextInt();
			int cnt = 1;
			int x = 0, y = 0;
			int[][] arr = new int[size][size];
			for (int i = 0; i < size; i++) {
				arr[0][i] = cnt++;
				y = i;
			}

			for (int i = size - 1; i > 0; i--) {
				if (i % 2 != (size % 2)) {
					for (int k = 0; k < i; k++) {
						x += 1;
						arr[x][y] = cnt++;
					}
					for (int k = 0; k < i; k++) {
						y -= 1;
						arr[x][y] = cnt++;
					}
				} else {
					for (int k = 0; k < i; k++) {
						x -= 1;
						arr[x][y] = cnt++;
					}
					for (int k = 0; k < i; k++) {
						y += 1;
						arr[x][y] = cnt++;
					}
				}
			}
			System.out.println("#"+tc);

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
