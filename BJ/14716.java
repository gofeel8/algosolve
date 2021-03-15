import java.io.*;
import java.util.*;

public class P14716 {
	public static int[] dr = {-1,-1,0,1,1,1,0,-1};
	public static int[] dc = {0,1,1,1,0,-1,-1,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					result++;
					
					
					Queue<int []>queue = new LinkedList<int[]>();
					queue.add( new int [] {i,j});
					map[i][j]=0;
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						for(int d=0;d<8;d++) {
							int nr = now[0]+dr[d];
							int nc = now[1]+dc[d];
							if(nr<0 || nr>=M || nc<0 || nc>=N)continue;
							if(map[nr][nc]==0)continue;
							queue.add(new int[] {nr,nc});
							map[nr][nc]=0;
						}
					}
					
				}
			}
		}
		System.out.println(result);
		
		

	}

}
