import java.io.*;
import java.util.*;

public class P4354 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(true) {
			str = br.readLine();
			if(str.equals("."))break;
//			System.out.println(str);
			int[] pi = makePi(str);
			
			int a = str.length()-pi[str.length()-1];
			if(str.length()%a==0) {
				System.out.println(str.length()/a);
			}else {
				System.out.println(1);
			}
			
			
		}

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
