import java.util.*;
import java.io.*;

public class P10942 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		
		
		
		boolean[][] dp = new boolean[N][N];
		for(int i=0;i<N;i++) {
			dp[i][i]= true;
		}
		
		for(int size=1;size<N;size++) {
			for(int a = 0; a<N;a++) {
				int b = a+size;
				if(b>=N)break;
				//dp[a][b];
				if(arr[a]==arr[b]) {
					if(size==1) {
						dp[a][b]=true;
					}else {
						if(dp[a+1][b-1])dp[a][b]=true;
					}
				}
			}
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int M  = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(dp[a][b]) {
				bw.write("1");
				bw.newLine();
			}else {
				bw.write("0");
				bw.newLine();
			}
			
		}
		bw.flush();
		bw.close();
	}

}
