import java.io.*;
import java.util.*;
public class P10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		
		Arrays.fill(dp[1],1);
		dp[1][0]=0;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j-1>=0) {
					dp[i][j] += dp[i-1][j-1];
					dp[i][j] %= 1000000000;
				}
				if(j+1<10) {
					dp[i][j] += dp[i-1][j+1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum+=dp[N][i];
			sum %= 1000000000;			
		}
		System.out.println(sum);

	}

}
