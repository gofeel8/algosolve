package algo;
import java.io.*;
import java.util.*;

public class P14923 {
	public static int[] dr= {-1,0,1,0};
	public static int[] dc= {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int hr = Integer.parseInt(st.nextToken())-1;
		int hc = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		int er = Integer.parseInt(st.nextToken())-1;
		int ec = Integer.parseInt(st.nextToken())-1;
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
	
		boolean[][][] visited = new boolean[2][N][M];
		Queue<int []> queue = new LinkedList<>();
		
		queue.add(new int[] {hr,hc,1});
		visited[1][hr][hc] = true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s=0;s<size;s++) {
				int[] now = queue.poll();
				
				if(now[0]==er && now[1]==ec) {
					System.out.println(cnt);
					return;
				}
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					int chance =now[2];
					if(nr<0 || nr>= N || nc<0 || nc>=M)continue;
					
					if(chance==1) {
						if(visited[1][nr][nc]==true)continue;
						if(map[nr][nc]==0) {
							queue.add(new int[] {nr,nc,1});
							visited[1][nr][nc]=true;
						}
						else {
							queue.add(new int[] {nr,nc,0});
							visited[0][nr][nc]=true;
						}
						
					}else {
						if(visited[1][nr][nc]==true)continue;
						if(visited[0][nr][nc]==true)continue;
						
						if(map[nr][nc]==0) {
							queue.add(new int[] {nr,nc,0});
							visited[0][nr][nc]=true;
						}
						
					}
					
				}
				
				
			}
			
			cnt++;
		}
		System.out.println(-1);

	}

}
