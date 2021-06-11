import java.io.*;
import java.util.*;

public class P13398 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr  =  new int[N];
		StringTokenizer  st  = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans =Integer.MIN_VALUE;
		int[][] dp = new int[N][2];
		dp[0][0] = arr[0];
		ans = arr[0];
		for(int i=1;i<N;i++) {
			dp[i][0]= Math.max(dp[i-1][0]+arr[i], arr[i]);
			dp[i][1]= Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
			if(dp[i][0]>ans)ans=dp[i][0];
			if(dp[i][1]>ans)ans=dp[i][1];
			
		}
		System.out.println(ans);

	}

}
