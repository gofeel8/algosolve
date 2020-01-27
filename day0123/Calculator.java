//swexpert : 8338 : 계산기 문제
package day0127;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1;tc<=TC;tc++) {
			
			
		int size = sc.nextInt();
		int[] arr = new int[size];
		arr[0] = sc.nextInt();
		int ans =arr[0];
		for(int i =1;i<size;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]+arr[i-1]>arr[i]*arr[i-1]) {
				arr[i]=arr[i]+arr[i-1];
			}else {
				arr[i]=arr[i]*arr[i-1];
			}
		}
		System.out.println("#"+tc+" "+arr[size-1]);

		
		
		}
	}

}
