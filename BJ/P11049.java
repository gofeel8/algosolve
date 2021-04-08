import java.io.*;
import java.util.*;

public class P11049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
	
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		int[][] arr = new int[N+1][2];
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			dp[i][i]=0;
		}
		
		for(int i=1;i<=N-1;i++) {
			dp[i][i+1]=arr[i][0]*arr[i][1]*arr[i+1][1];
		}
		
		for(int len =2;len<N;len++) {
			for(int i=1;i<=N-len;i++) {
				
				int end = i+len;
				for(int j=i;j<end;j++) {
					dp[i][end] = Math.min(dp[i][end], dp[i][j]+dp[j+1][end]+(arr[i][0]*arr[j+1][0]*arr[end][1]));
				}
				
			}
		}
		
		System.out.println(dp[1][N]);

	}
	
	

}
