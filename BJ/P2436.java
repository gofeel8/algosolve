import java.io.*;
import java.util.*;

public class P2436 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int GCD = Integer.parseInt(st.nextToken());
		int LCM = Integer.parseInt(st.nextToken());
		
		
		long gap = Integer.MAX_VALUE;
		
		//
		
		int ab =LCM/GCD;
//		int A = 0,B = 0;
		int i=1;
		for(int t=2;t*t<=ab;t++) {
			if(ab%t==0) {
				if(gcd(t, ab/t)==1) {
//					int tmp = Math.abs((GCD*(ab/i))-(GCD*i));
//					if(tmp<gap) {
//						gap = tmp;
//						A = GCD*(ab/i);
//						B = GCD*i;
//					}
					i=t;
				}
			}
		}
		
		System.out.println(GCD*i+" "+GCD*(ab/i));
		
		
	}
	
	public static int gcd(int big,int small) {
		if(big%small==0) {
			return small;
		}
		return gcd(small,big%small);
	}

}
