import java.io.*;
import java.util.*;
public class P7579 {
	public static int N,M;
	public static int[] mem,time;
	public static int result;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N =  Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		st = new  StringTokenizer(br.readLine());
		mem = new int[N+1];
		for(int i=1;i<=N;i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		
		time = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=1;i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			time[i] = temp;
			sum += temp;
		}
		
		dp=new int[N+1][sum+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=sum;j++) {
				if(j-time[i]<0) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+mem[i]);
				}
			}
		}
		
		for(int i=0;i<=sum;i++) {
			if(dp[N][i]>=M) {
				System.out.println(i);
				return;
			}
		}
		
		
	}



}
