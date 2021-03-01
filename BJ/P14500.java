import java.io.*;
import java.util.*;


public class P14500 {
	public static int N;
	public static int M;
	public static int[][] map;
	
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	
	public static int MAX;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		MAX = 0;
		
		visited = new boolean[N][M];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//플러스 탐색
				plus(i,j);
				//dfs탐색 
				dfs(i,j,1,map[i][j]);
			}
		}
		
		
		System.out.println(MAX);
		
	}

	private static void dfs(int row, int col, int idx, int sum) {
		if(idx == 4) {
			if(sum>MAX) {
				MAX  =sum;
			}
			return;
		}
		
		visited[row][col]=true;
		
		for(int d=0;d<4;d++) {
			
			int nr = row+dr[d];
			int nc = col+dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=M)continue;
			if(visited[nr][nc]==true)continue;
			
			dfs(nr,nc,idx+1,sum+map[nr][nc]);
		}
		
		visited[row][col]=false;
		
	}

	private static void plus(int row, int col) {
		
		PriorityQueue<Integer> queue= new PriorityQueue<>(Collections.reverseOrder());
		if(row-1>=0) {
			queue.add(map[row-1][col]);
		}
		if(col+1<M) {
			queue.add(map[row][col+1]);

		}
		if(row+1<N) {
			queue.add(map[row+1][col]);

		}
		if(col-1>=0) {
			queue.add(map[row][col-1]);

		}
		
		if(queue.size()>=3) {
//			System.out.println("size = "+queue.size());
			int sum = map[row][col]+queue.poll()+queue.poll()+queue.poll();
			if(sum>MAX) {
				MAX =sum;
			}
		}
		
	}

}
