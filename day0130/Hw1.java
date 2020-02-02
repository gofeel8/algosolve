//swexpert 7964 부먹왕국
package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hw1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int num = sc.nextInt();
			int lim = sc.nextInt();
			boolean[] arr = new boolean[num + 2];
			for (int i = 1; i <= num; i++) {
				if (sc.nextInt() == 1) {
					arr[i] = true;
				}
			}
			arr[0]=true;
			arr[num+1]=true;
			int sum = 0;
			int now = 0;
			int move;
			while(now<num+2) {
				boolean tmp = false;
				for(int i=lim;i>0;i--) {
					move=now+i;
					if(move<num+2&&arr[move]) {
						now=move;
						tmp =true;
						break;
					}
				}
				if(tmp==false) {
					now=now+lim;
					sum++;
				}
			}
			if(now>num)sum--;
			System.out.println("#"+tc+" "+(sum));

		}
	}

}
