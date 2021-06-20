import java.io.*;
import java.util.*;

public class P1103 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	
	public static boolean[][] visited;
	public static int M,N,ans;
	public static int[][] arr;
	public static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		memo = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)!='H') {
					arr[i][j]=str.charAt(j)-'0';
				}
			}
		}
		ans = 0;
		visited = new boolean[N][M];
		visited[0][0]=true;
		dfs(0,0,1);
		System.out.println(ans);
	}
	private static void dfs(int r, int c, int step) {
		if(step>ans)ans=step;
		
		memo[r][c]=step;
		for(int d=0;d<4;d++) {
			int nr = r +dr[d]*arr[r][c];
			int nc = c +dc[d]*arr[r][c];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M)continue;
			if(arr[nr][nc]==0)continue;
			if(visited[nr][nc]) {
				ans=-1;
				return;
			}
			if(memo[nr][nc]>step)continue;
			visited[nr][nc]=true;
			dfs(nr,nc,step+1);
			if(ans==-1)return;
			visited[nr][nc]=false;
		}
		
		
	}

}
