//정올 1175: 주사위 던지기
package ws;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Jungol_1175 {

	public static void main(String[] args) throws IOException {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] result = new int[N];
		fun4(0,M,0,arr,result);
	}

	static void fun4(int idx,int M,int now,int[] arr,int[] result) {
		if(idx==result.length) {
			if(now==M) {
				for (int i = 0; i < result.length; i++) {
					System.out.print(result[i] + " ");
				}System.out.println();
				return;
			}else {
				return;
			}
		}
		for(int i=0;i<6;i++) {
			result[idx]=arr[i];
			fun4(idx+1,M,now+arr[i],arr,result);
		}
		
	}
	
}