import java.io.*;
import java.util.*;

public class P1507 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][] input = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] adj = new int[N][N];
		for(int i=0;i<N;i++) {
			adj[i] = Arrays.copyOf(input[i], N);
		}
		
		
		boolean[][] disable = new boolean[N][N];
		for(int i=0;i<N;i++) {  //거치는점
			for(int start=0;start<N;start++) {
				if(i==start)continue;
				for(int end=0;end<N;end++) {
					if(end==start || end==i)continue;
					if(adj[start][i]+adj[i][end]==input[start][end]) {
						disable[start][end]=true;
					}
					if(adj[start][i]+adj[i][end]<adj[start][end]) {
						adj[start][end]=adj[start][i]+adj[i][end];
					}
				}
			}
		}
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(input[i][j]>adj[i][j]) {
					System.out.println(-1);
					return;
				}
				if(disable[i][j]==false) {
					ans+=input[i][j];
				}
			}
		}
		System.out.println(ans/2);
	}

}
