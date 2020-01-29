//미로 도착지점
package day0129;

import java.util.Scanner;

public class Hw3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			int size = sc.nextInt();
			boolean[][] arr = new boolean[size + 1][size + 1];
			int my_x = sc.nextInt();
			int my_y = sc.nextInt();
			int jumper = sc.nextInt();
			boolean is_goal = false, is_out = false;
			for (int i = 0; i < jumper; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = true;
			}
			int lead = sc.nextInt();
			for (int i = 0; i < lead; i++) {
				int dir = sc.nextInt();
				int step = sc.nextInt();
				for (int j = 0; j < step; j++) {
					if (is_goal == true || is_out == true) {
						my_x=0;
						my_y=0;
						break;
					}
					if (dir == 1) {
						my_x -= 1;
						if (arr[my_x][my_y] == true) {
							is_goal = true;
						} else if (my_x == 0 || my_x == size) {
							is_out = true;
						}
					} else if (dir == 2) {
						my_y += 1;
						if (arr[my_x][my_y] == true) {
							is_goal = true;
						} else if (my_y == 0 || my_y == size) {
							is_out = true;
						}
					} else if (dir == 3) {
						my_x += 1;
						if (arr[my_x][my_y] == true) {
							is_goal = true;
						} else if (my_x == 0 || my_x == size) {
							is_out = true;
						}
					} else if (dir == 4) {
						my_y -= 1;
						if (arr[my_x][my_y] == true) {
							is_goal = true;
						} else if (my_y == 0 || my_y == size) {
							is_out = true;
						}
					}
				}
			}
			if (is_goal) {
				System.out.println("#" + tc + " " + my_x + " " + my_y);
			} else if (is_out) {
				System.out.println("#" + tc + " " + my_x + " " + my_y);
			} else
				System.out.println("#" + tc + " " + my_x + " " + my_y);
		}
	}

}
