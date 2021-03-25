import java.io.*;
import java.util.*;

public class P16929 {
	public static char[][] map;
	public static int[][] visited;
	public static int N,M;
	public static int[] dr = {0,1,0,-1};
	public static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M-1;j++) {
				if(map[i][j]==map[i][j+1] && map[i][j]==map[i+1][j]) {
					visited= new int[N][M];
					visited[i][j+1]=1;
					visited[i+1][j]=2;
					visited[i][j]=3;
					Queue<int []> queue = new LinkedList<int []>();
					queue.add(new int[] {i,j+1,1});
					queue.add(new int[] {i+1,j,2});
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						int mode =now[2];
						for(int d=0;d<4;d++){
							int nr = now[0]+dr[d];
							int nc = now[1]+dc[d];
							if(nr<0 || nr>=N || nc<0 || nc>=M)continue;
							if(map[now[0]][now[1]]!=map[nr][nc])continue;
							if(visited[nr][nc]==0) {
								visited[nr][nc]=mode;
								queue.add(new int[] {nr,nc,mode});
							}else if(visited[nr][nc]!=3 && visited[nr][nc]!=mode) {
								System.out.println("Yes");
								return;
							}
						}
					}
				}
			}
		}
		
		
		System.out.println("No");
		

	}

	

}
