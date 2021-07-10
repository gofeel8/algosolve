import java.io.*;
import java.util.*;
public class P1958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		int[][][] dp = new int[first.length()+1][second.length()+1][third.length()+1];
		
		for(int i=1;i<=first.length();i++) {
			for(int j=1;j<=second.length();j++) {
				for(int k=1;k<=third.length();k++) {
					if(first.charAt(i-1)==second.charAt(j-1)&&second.charAt(j-1)== third.charAt(k-1)) {
						dp[i][j][k]=dp[i-1][j-1][k-1]+1;
					}else {
						dp[i][j][k]=Math.max(dp[i-1][j][k], dp[i][j-1][k]);
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j][k-1]);
						
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i-1][j-1][k]);
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i-1][j][k-1]);
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j-1][k-1]);
					}
				}
			}
		}
		System.out.println(dp[first.length()][second.length()][third.length()]);
		

	}

}
