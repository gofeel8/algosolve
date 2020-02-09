package gps0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exp1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<size;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for(int i=2;i<size-2;i++) {
			while(arr[i]>arr[i-1]&&arr[i]>arr[i-2]&&arr[i]>arr[i+1]&&arr[i]>arr[i+2]) {
				cnt++;
				arr[i]--;
			}
		}
		System.out.println("#"+tc+" "+cnt);
		}
	

	}

}
