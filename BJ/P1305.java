import java.io.*;
import java.util.*;

public class P1305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String origin = br.readLine();
		int[] pi = makePi(origin);

		System.out.println(N-pi[N-1]);
	}
	
	public static int[] makePi(String pattern) {
		int j=0;
		int size = pattern.length();
		int[] pi = new int[size];
		
		for(int i=1;i<size;i++) {
			while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if( pattern.charAt(i) == pattern.charAt(j)) {
				pi[i]=++j;
			}
		}
		
		
		return pi;
	}
	

}
