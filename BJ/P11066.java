import java.io.*;
import java.util.*;
public class P11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<TC;t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int [] arr = new int[N+1];
			int [] sum = new int[N+1];
			for(int i=1;i<=N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1]+arr[i];
			}
			
			int[][] dp = new int[N+1][N+1];
			
			for(int end = 1; end <N;end ++) {
				for(int start = 1; start<=N;start++) {
					if(start+end>N)break;
					dp[start][start+end]=Integer.MAX_VALUE;
					for(int sep = start;sep<start+end;sep++) {
						dp[start][start+end]=Math.min(dp[start][start+end], dp[start][sep]+dp[sep+1][start+end]+sum[start+end]-sum[start-1]);
					}
				}
			}
			
			
			
			bw.write(String.valueOf(dp[1][N]));
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
	}

}
