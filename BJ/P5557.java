import java.util.*;
import java.io.*;
public class P5557 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N+1][21];
		int first = arr[1];
		dp[1][first] = 1;
		
		for(int i=2;i<N;i++) {
			for(int j=0;j<21;j++) {
				if(dp[i-1][j]!=0) {
					if(j+arr[i]<=20) {
						dp[i][j+arr[i]]+=dp[i-1][j];
					}
					if(j-arr[i]>=0) {
						dp[i][j-arr[i]]+=dp[i-1][j];						
					}
				}
			}
		}
		
		System.out.println(dp[N-1][arr[N]]);

	}

}
