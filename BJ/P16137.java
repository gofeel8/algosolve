import java.io.*;
import java.util.*;
public class P16137 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][][] visited = new boolean[2][N][N];
		
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0,1});
		visited[1][0][0]=true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				int[] now =queue.poll();
				int chance = now[2];
				if(now[0]==N-1 && now[1]==N-1) {
					System.out.println(cnt);
					return;
				}
				
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
					
					if(map[nr][nc]==1 && visited[chance][nr][nc]==false) {  //여기 시간초과주의
						queue.add(new int[] {nr,nc,chance});
						visited[chance][nr][nc]=true;
					}
					
					//만들어진 오작교 건너기
					if(map[nr][nc]>1 && map[now[0]][now[1]]==1&& visited[chance][nr][nc]==false) {
						int time = map[nr][nc];
						if((cnt+1)%time ==0 ) {
							queue.add(new int[] {nr,nc,chance});
							visited[chance][nr][nc]=true;
						}else {
							queue.add(now);
						}
					}
					
					
					//오작교 하나 만들어 주는 구간
					if(map[nr][nc]==0 &&map[now[0]][now[1]]==1&&  chance == 1 && visited[chance][nr][nc]==false) {
						boolean horizon=false;
						if((nc>=1 && map[nr][nc-1]==0) || (nc<N-1 && map[nr][nc+1]==0))horizon=true;
						boolean vertical=false;
						if((nr>=1 && map[nr-1][nc]==0) || (nr<N-1 && map[nr+1][nc]==0))vertical=true;
						
						if(horizon && vertical)continue;
						
						int time = M;
						if((cnt+1)%time ==0 ) {
							queue.add(new int[] {nr,nc,chance-1});
							visited[chance][nr][nc]=true;
						}else {
							queue.add(now);
						}
					}
				}
				
				
				
			}
			
			
			cnt++;
			
		}

	}

}
