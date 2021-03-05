import java.util.*;
import java.io.*;

public class P1600 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static int[] hr = {-2,-1,1,2,2,1,-1,-2};
	public static int[] hc = {1,2,2,1,-1,-2,-2,-1};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		
		
		boolean[][][] visited = new boolean[R][C][K+1];
		Queue<int []>queue = new LinkedList<int[]>();

		queue.add(new int[] {0,0,K});
		visited[0][0][K]=true;
		
		
		int cnt=0;
		int r,c,nr,nc,chance;
		int[] now;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s=0;s<size;s++) {
				now = queue.poll();
				r=now[0];
				c=now[1];
				
				if(r+1==R && c+1==C) {
					System.out.println(cnt);
					return;
				}
				
				chance = now[2];
				
				//사방탐색
				for(int d =0;d<4;d++) {
					nr = r+dr[d];
					nc = c+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]==false && visited[nr][nc][chance]==false) {
						queue.add(new int[] {nr,nc,chance});
						for(int i=0;i<=chance;i++) {
							visited[nr][nc][i]=true;
						}
						
					}
				}
				
				//말 처럼이동
				if(chance>0) {
					for(int d=0;d<8;d++) {
						nr = r+hr[d];
						nc = c+hc[d];
						if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
						if(map[nr][nc]==false && visited[nr][nc][chance-1]==false) {
							queue.add(new int[] {nr,nc,chance-1});
							for(int i=0;i<=chance-1;i++) {
								visited[nr][nc][i]=true;
							}
							
						}
					}
				}
			}
		
		
		
			cnt++;
		}
		
		System.out.println(-1);

	}

}
