import java.io.*;
import java.util.*;

public class P10830 {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = matrix(B,arr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				bw.write(String.valueOf(ans[i][j])+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static int[][] matrix(long b, int[][] arr) {
		int[][] rt = new int[arr.length][arr.length];
		if(b==1) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					rt[i][j]=arr[i][j]%1000;
				}
			}
			return rt;
		}
		
		int[][] tmp  = matrix(b/2, arr);
		
		
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp.length;j++) {
				for(int k=0;k<tmp.length;k++) {
					rt[i][j] += (tmp[i][k]*tmp[k][j])%1000;
					rt[i][j] %= 1000;
				}
			}
		}
		
		
		if(b%2==1) {
			int[][] cp = new int[rt.length][rt.length];
			for(int i=0;i<tmp.length;i++) {
				for(int j=0;j<tmp.length;j++) {
					for(int k=0;k<tmp.length;k++) {
						cp[i][j] += (rt[i][k]*arr[k][j])%1000;
						cp[i][j] %= 1000;
					}
				}
			}	
			return cp;
		}
		
		return rt;
		
		
	}

}
