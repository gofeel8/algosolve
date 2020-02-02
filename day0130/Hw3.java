//expert 1984 중간 평균값 구하기
package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hw3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC =Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=TC;tc++) {
		int num;
		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0;i<10;i++) {
			num=Integer.parseInt(st.nextToken());
			min = Math.min(min, num);
			max = Math.max(max, num);
			sum += num;
		}
		System.out.println("#"+tc+" "+(int) Math.round((sum-min-max)/8.0));
		}
	}

}
