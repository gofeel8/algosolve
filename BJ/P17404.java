import java.io.*;
import java.util.*;

public class P17404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		
		//첫번째 red
		int[][] dp = new int[N][3];
		dp[0][0]=arr[0][0];
		dp[0][1]=2000000;
		dp[0][2]=2000000;
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		ans = Math.min(dp[N-1][1], dp[N-1][2]);
		//첫번째 green
		dp[0][0]=2000000;
		dp[0][1]=arr[0][1];
		dp[0][2]=2000000;
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		int min = Math.min(dp[N-1][0], dp[N-1][2]);
		ans = Math.min(ans,min);
		//첫번째 blue
		dp[0][0]=2000000;
		dp[0][1]=2000000;
		dp[0][2]=arr[0][2];
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		min = Math.min(dp[N-1][0], dp[N-1][1]);
		ans = Math.min(ans,min);
		
		System.out.println(ans);

	}

}
