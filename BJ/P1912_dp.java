import java.io.*;
import java.util.*;

public class P1912_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr  =  new int[N];
		StringTokenizer  st  = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans =Integer.MIN_VALUE;
		int[] dp = new int[N];
		dp[0] = arr[0];
		ans = arr[0];
		for(int i=1;i<N;i++) {
			dp[i]= Math.max(dp[i-1]+arr[i], arr[i]);
			if(dp[i]>ans)ans=dp[i];
		}
		System.out.println(ans);
	}

}
