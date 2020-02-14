package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[G + 1];
		int cnt = 0;
		boolean crush = false;
		for (int i = 1; i <= P; i++) {
			int q = Integer.parseInt(br.readLine());
			for (int j = q; j > 0; j--) {
				if (arr[j] == false) {
					arr[j] = true;
					cnt++;
					break;
				}
				if(j==1) {
					crush = true;
				}
			}
			if(crush) {
				break;
			}
			
		}
		System.out.println(cnt);
	}
}
