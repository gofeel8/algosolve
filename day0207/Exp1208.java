package gps0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exp1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[100];
		for(int i=0;i<100;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int maxIdx=99;
		int minIdx=0;
		int maxCnt=1;
		int minCnt=1;
		int maxLine = arr[maxIdx];
		int minLine = arr[minIdx];
		while(cnt>0) {
			maxIdx=99;
			minIdx=0;
			maxCnt=1;
			minCnt=1;
			while(arr[maxIdx]==arr[maxIdx-1]) {
				maxCnt++;
				maxIdx--;
			}
			while(arr[minIdx]==arr[minIdx+1]) {
				minCnt++;
				minIdx++;
			}
			arr[maxIdx] = arr[maxIdx]-1;
			arr[minIdx] = arr[minIdx]+1;
			cnt--;
		}
		if(maxCnt!=1) {
			arr[maxIdx]++;
		}
		if(minCnt!=1) {
			arr[minIdx]--;
		}
		
		System.out.println("#"+tc+" "+(arr[maxIdx]-arr[minIdx]));
	}
	}

}
