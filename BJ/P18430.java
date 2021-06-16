import java.io.*;
import java.util.*;

public class P18430 {
	public static int[] dr = {-1,0,1,0,-1};
	public static int[] dc = {0,1,0,-1,0};
	
	public static boolean[][] checked;
	public static boolean[] used;
	public static int[][] map;
	public static int N;
	public static int M;
	public static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max =0;
		used = new boolean[1<<26];
		checked = new boolean[N][M];
		dfs(0,0,0);
		
		System.out.println(max);
		
	}
	private static void dfs(int r, int c, int sum) {
		if(sum>max)max = sum;
		if(c==M) {
			c=0;
			r++;
		}
		if(r==N)return;
		
		if(!checked[r][c]) {
			for(int d=0;d<4;d++) {
				int nr1 = r+dr[d];
				int nc1 = c+dc[d];
				int nr2 = r+dr[d+1];
				int nc2 = c+dc[d+1];
				if(nr1<0 || nr1>=N || nc1<0 || nc1>=M||nr2<0 || nr2>=N || nc2<0 || nc2>=M)continue;
				if(checked[nr1][nc1]==true || checked[nr2][nc2]==true)continue;
//				int tmp = (1<<((nr1)*N+nc1))|(1<<((r)*N+c))|(1<<((nr2)*N+nc2));
//				if(used[tmp])continue;
				
				checked[nr1][nc1]=true;
				checked[r][c]=true;
				checked[nr2][nc2]=true;
//				used[tmp]=true;
				dfs(r,c+1,sum+map[nr1][nc1]+(map[r][c]*2)+map[nr2][nc2]);
				checked[nr1][nc1]=false;
				checked[r][c]=false;
				checked[nr2][nc2]=false;
			}
		}
		
		dfs(r,c+1,sum);
		
				
				
				
				
		
	}
}
