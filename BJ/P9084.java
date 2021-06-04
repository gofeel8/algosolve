import java.util.*;
import java.io.*;

public class P9084 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			for(int i=1;i<=M;i++) {
				if(i%arr[0]==0) {
					dp[i]=1;
				}
			}
			for(int i=1;i<N;i++) {
				int now = arr[i];
				for(int j=1;j<=M;j++) {
					if(j-now>=0) {
						dp[j]+=dp[j-now];
					}
				}	
			}
			
			bw.write(String.valueOf(dp[M]));
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
 
