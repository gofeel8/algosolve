import java.util.*;
import java.io.*;

public class P2638 {
	public static boolean[][] map;
	public static int N,M,cnt;
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		
		map =new boolean[N][M];
		
		cnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				if(st.nextToken().equals("1")) {
					map[i][j]=true;
					cnt++;
				}
			}
		}
		
		if(cnt==0) {
			
		}

		if(cnt==0) {
			System.out.println(0);
			return;
		}
		
		int time = 1;
		
		while(true) {
			if(bfs(time)) {
				break;
			}
			time++;
		}
		
		System.out.println(time);
	}


	private static boolean bfs(int time) {
		Queue<int[]>queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0});
		boolean[][] visited = new boolean[N][M];
		visited[0][0]=true;
		boolean[][] hit = new boolean[N][M];
		while(!queue.isEmpty()) {
			
			int[] now = queue.poll();
			for(int d=0;d<4;d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr<0 ||nr>=N || nc<0 || nc>=M)continue;
				if(visited[nr][nc])continue;
				if(map[nr][nc]==false) {
					queue.add(new int [] {nr,nc});
					visited[nr][nc]=true;
				}else {
					if(hit[nr][nc]==false) {
						hit[nr][nc]=true;
					}else { //녹아
						cnt--;
						map[nr][nc]=false;
						hit[nr][nc]=false;
						visited[nr][nc]=true;
					}
				}
			}
			
		}
		
		if(cnt==0) {
			return true;
		}
		return false;
	}


}
