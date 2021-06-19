import java.io.*;
import java.util.*;

public class P9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i=0;i<=len1;i++) {
			for(int j=0;j<=len2;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1]+1;
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
//		System.out.println(dp[len1][len2]);
		Stack<Character> stack = new Stack<>();
		
		int idx1 = len1;
		int idx2 = len2;
		while(dp[idx1][idx2]!=0) {
			if(dp[idx1][idx2]==dp[idx1-1][idx2]) {
				idx1--;
			}else if(dp[idx1][idx2]==dp[idx1][idx2-1]) {
				idx2--;
			}else {
				stack.push(str1.charAt(idx1-1));
				idx1--;
				idx2--;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(stack.size()));
		bw.newLine();
		while(!stack.empty()) {
			bw.write(stack.pop());
		}
		bw.flush();
		bw.close();
		
	}

}
