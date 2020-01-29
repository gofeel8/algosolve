//소금쟁이 문제
package day0129;

import java.util.Scanner;

public class Hw2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			System.out.println("#"+tc+" "+func());
		}
	}
	static int func() {
		int size = sc.nextInt();
		boolean[][] field = new boolean[size][size];
		int m = sc.nextInt();
		int[][] bug = new int[m][3];
		for(int i=0;i<m;i++) {
			for(int j=0;j<3;j++) {
				bug[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < m; i++) {
			int x = bug[i][0];
			int y = bug[i][1];
			int dir = bug[i][2];
			if (field[x][y] == true) {
				return (i + 1);
			} else {
				field[x][y] = true;
				for (int j = 3; j > 0; j--) {
					if (dir == 1) {
						x = x + j;
						if (x < size) {

							if (field[x][y] == true) {
								return (i + 1);
							}else
							field[x][y] = true;
						}
					} else if (dir == 2) {
						y = y + j;
						if (y < size) {
							if (field[x][y] == true) {
								return (i + 1);
							}else
							field[x][y] = true;
						}
					}
				}
			}
		}
		return 0;
	}
}
