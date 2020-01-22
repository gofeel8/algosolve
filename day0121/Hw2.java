package test;

import java.util.Scanner;

public class Ladder {
	 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1;tc<=10;tc++) {
        int tmp = sc.nextInt();
        int x = 0;
        int[][] arr = new int[100][102];
        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 101; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    x = j;
                }
            }
        }
        for (int i = 99; i > 0; i--) {
            if (arr[i][x - 1] == 1) {
                do {
                    x -= 1;
                } while (arr[i][x - 1] == 1);
            } else if (arr[i][x + 1] == 1) {
                do {
                    x += 1;
                } while (arr[i][x + 1] == 1);
            }
        }
        int ans = x-1;
        System.out.println("#"+tc+" "+ans);
    }
    }
}