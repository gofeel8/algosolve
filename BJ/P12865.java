import java.util.*;
import java.io.*;

public class P12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][K+1];
 		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=K;j++) {
				arr[i][j] = Math.max(arr[i-1][j], (j-w)>=0?v+arr[i-1][j-w]: 0);
			}
			
		}
 		
 		System.out.println(arr[N][K]);
		

	}

}
