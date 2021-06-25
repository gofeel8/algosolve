import java.io.*;
import java.util.*;
public class P1509 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		boolean[][] drom = new boolean[len][len];
		for(int i=0;i<len;i++) {
			drom[i][i]=true;
		}
		
		for(int i=1;i<len;i++) {
			for(int start=0;start<len;start++) {
				int end = start+i;
				if(end>=len)break;
				if(str.charAt(start)!=str.charAt(end))continue;
				
				if(start+1>end-1)drom[start][end]=true;
				else if(drom[start+1][end-1]) {
					drom[start][end]=true;
				}
			}
		}
		
		int[] dp = new int[len];
		dp[0]=1;
		for(int i=1;i<len;i++) {
			dp[i]=dp[i-1]+1;
			for(int j=i-1;j>=0;j--) {
				if(drom[j][i]) {
					if(j!=0) {
						dp[i] = Math.min(dp[i], dp[j-1]+1);
					}else {
						dp[i]=1;
					}
				}
			}
		}
		System.out.println(dp[len-1]);
		
	}

}
 
