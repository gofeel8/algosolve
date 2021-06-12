import java.io.*;
import java.util.*;

public class P9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int t=0;t<TC;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			dp[0]=1;
			for(int i=1;i<=N;i++) {
				if(i-1>=0) {
					dp[i] += dp[i-1];
				}
				if(i-2>=0) {
					dp[i] += dp[i-2];
				}
				if(i-3>=0) {
					dp[i] += dp[i-3];
				}
			}
			bw.write(String.valueOf(dp[N]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		

	}

}
