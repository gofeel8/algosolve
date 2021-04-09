import java.io.*;
import java.util.*;

public class P16197 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  =Integer.parseInt(st.nextToken());
		int M  =Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		String str;
		List<int []>ball = new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<M;j++) {
				char tmp = str.charAt(j);
				map[i][j]= tmp;
				if(tmp =='o') {
					ball.add(new int[] {i,j});
				}
			}
		}
		
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {ball.get(0)[0],ball.get(0)[1],ball.get(1)[0],ball.get(1)[1]});
		
		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[ball.get(0)[0]][ball.get(0)[1]][ball.get(1)[0]][ball.get(1)[1]]=true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			if(cnt>=10) {
				break;
			}
			for(int i=0;i<qsize;i++) {
				int[] now = queue.poll();
				
				for(int d =0;d<4;d++) {
					//첫번째 볼 확인
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					boolean drop = false;
					if(nr<0 || nr>=N || nc<0 || nc>=M) {
						drop = true;
					}else {
						if(map[nr][nc]=='#') {
							nr = now[0];
							nc = now[1];
						}
					}
					//두번째 볼 확인
					int nr2 = now[2]+dr[d];
					int nc2 = now[3]+dc[d];
					boolean drop2 = false;
					if(nr2<0 || nr2>=N || nc2<0 || nc2>=M) {
						drop2 = true;
					}else {
						if(map[nr2][nc2]=='#') {
							nr2 = now[0];
							nc2 = now[1];
						}
					}
					
					if(drop && drop2){
						continue;
					}else if(drop) {
						System.out.println(cnt+1);
						return;
					}else if(drop2) {
						System.out.println(cnt+1);
						return;
					}
					
					if(visited[nr][nc][nr2][nc2]==false) {
						queue.add(new int[] {nr,nc,nr2,nc2});
						visited[nr][nc][nr2][nc2]=true;
					}
					
					
				}
				
				
			}
			cnt++;
			
		}
		
		
		System.out.println(-1);
		
	}
		
		
		

}

