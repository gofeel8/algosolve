package gps0204;

import java.util.Arrays;
import java.util.Scanner;

public class Exp1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC=sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[r][c];
		int f_r = -1, f_c = -1;
		for (int i = 0; i < r; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j)-'0';
				if (arr[i][j] == 1) {
					if(f_r==-1) {
						f_r = i;
					}
				}
			}
		}
		for (int j = c - 1; j >= 0; j--) {
			if (arr[f_r][j] == 1) {
				if(f_c==-1) {
					f_c = j;
					break;
				}
			}
		}

		int[] result = new int[8];
		for (int i = 7; i >= 0; i--) {
			int j = 1;
			if (arr[f_r][f_c - j++] == 0) {
				if (arr[f_r][f_c - j++] == 0) {
					if (arr[f_r][f_c - j++] == 0) {
						// 5
						result[i] = 5;
					} else {
						// 1
						result[i] = 1;
					}
				} else {
					if (arr[f_r][f_c - j++] == 0) {

					} else {
						if (arr[f_r][f_c - j++] == 0) {
							// 0
							result[i] = 0;
						} else {
							// 3
							result[i] = 3;
						}

					}

				}
			} else {
				if (arr[f_r][f_c - j++] == 0) {
					if (arr[f_r][f_c - j++] == 0) {
						if (arr[f_r][f_c - j++] == 0) {
							// 4
							result[i] = 4;
						} else {
							// 2
							result[i] = 2;
						}
					} else {
						if (arr[f_r][f_c - j++] == 0) {
							// 9
							result[i] = 9;
						} else {
							// 7
							result[i] = 7;
						}
					}
				} else {
					if (arr[f_r][f_c - j++] == 0) {
						// 8
						result[i] = 8;
					} else {
						// 6
						result[i] = 6;
					}

				}

			}
			f_c -= 7;
		}
		if(((result[0]+result[2]+result[4]+result[6])*3+result[1]+result[3]+result[5]+result[7])%10==0) {
			int sum =0;
			for(int i=0;i<8;i++) {
				sum += result[i];
			}
			System.out.println("#"+tc+" "+sum);
		}else {
			System.out.println("#"+tc+" "+0);
		}

	}
}

}