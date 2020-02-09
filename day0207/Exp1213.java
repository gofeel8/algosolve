package gps0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exp1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
		br.readLine();
		String tg = br.readLine();
		String str = br.readLine();
		int cnt = 0;
		int st=0;
		int size = tg.length();
		while(true) {
			int idx = str.indexOf(tg,st);
			if(idx != -1) {
				cnt++;
				st=idx+size;
			}else {
				break;
			}
		}
		System.out.println("#"+tc+" "+cnt);
		}
	}


}
