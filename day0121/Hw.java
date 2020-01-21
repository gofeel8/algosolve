//의석이의 세로로 말해요 
package test;


import java.util.Scanner;

public class HW {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			char[][] arr = new char[5][15];

			for (int i = 0; i < 5; i++) {
				String s = sc.next();
				for (int j = 0; j < s.length(); j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			System.out.print("#"+tc+" ");

			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (arr[i][j] != '\0') {
						System.out.print(arr[i][j]);
					}
				}
			}
			System.out.println();

		}

	}

}