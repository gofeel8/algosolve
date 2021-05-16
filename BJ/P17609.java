import java.io.*;
import java.util.*;

public class P17609 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			String str = br.readLine();
			if(palindrome(str, 0, str.length()-1, false)==0) {
				System.out.println(0);
			}else if(palindrome(str, 0, str.length()-1, false)==1) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
		 
		}
	}
	
	public static int palindrome(String str, int left, int right,boolean chance) {
		int ans = 0;
		while(left<=right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
			}else {
				boolean find = false;
				if(str.charAt(left)==str.charAt(right-1)) {
					if(chance) {
						return 2;
					}else {
						if(palindrome(str, left+1, right-2, true)==0) {
							find = true;
						}
					}
				}
				if(str.charAt(left+1)==str.charAt(right)) {
					if(chance) {
						return 2;
					}else {
						if(palindrome(str, left+2, right-1, true)==0) {
							find = true;
						}
					}
				}
				if(find) {
					return 1;
				}else {
					return 2;
				}
			}
		}
		
		return 0;
	}
}
