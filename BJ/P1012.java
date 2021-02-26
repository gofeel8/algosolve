import java.util.*;
import java.io.*;


public class P1012 {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] map;
	static int M;
	static int N;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0;t<tc;t++) {
			st= new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map =new boolean[M][N];
			
			int K = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
			}
			
			int result=0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==true) {
						result++;
						bfs(i,j);
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		map[r][c]=false;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nr =now[0];
			int nc =now[1];
			
			for(int d=0;d<4;d++) {
				if(nr+dr[d]>=0 &&nr+dr[d]<M && nc+dc[d]>=0 && nc+dc[d]<N ) {
					if(map[nr+dr[d]][nc+dc[d]]==true) {
						map[nr+dr[d]][nc+dc[d]]=false;
						queue.add(new int[] {nr+dr[d],nc+dc[d]});
					}
				}
			}
		}
	}

}
