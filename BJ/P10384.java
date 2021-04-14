import java.io.*;
import java.util.*;

public class P10384 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		String str;
		for(int i=1;i<=N;i++) {
			str = br.readLine();
			int[] used = new int[26];
			for(int j=0;j<str.length();j++) {
				char now = str.charAt(j);
				int num;
				if(now-'a'<0) {
					num = now-'A';
				}else {
					num = now-'a';
				}
				if(num>=0 && num<26) {
					used[num]++;
				}
			}
			int min=Integer.MAX_VALUE;
			for(int j=0;j<26;j++) {
				min = Math.min(min, used[j]);
			}
			System.out.print("Case "+i+": ");
			switch (min) {
			case 0:
				System.out.println("Not a pangram");
				break;
			case 1:
				System.out.println("Pangram!");
				break;
			case 2:
				System.out.println("Double pangram!!");
				break;
			case 3:
				System.out.println("Triple pangram!!!");
				break;
			}
		}
		
	}
}
