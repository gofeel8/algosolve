//swexpert 8931 제로 문제
package day0127;

import java.util.Scanner;

public class Zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
		int size =sc.nextInt();
		int[] arr = new int[size];
		int idx =0;
		int sum =0;
		for(int i=0;i<size;i++) {
			int num = sc.nextInt();
			if(num != 0) {
				arr[idx++]=num;
			}else {
				arr[--idx]=0;
			}
		}
		for(int i=0;i<idx;i++) {
			sum+=arr[i];
		}
		System.out.println("#"+tc+" "+sum);
	}

	}
}
