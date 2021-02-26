import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {

	private static int[][] Map;
	private static int N;
	private static int result;
	private static boolean[][] visited;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];
		int MAX = 0;
		result = 1;
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				Map[i][j]=num;
				if(num>MAX)MAX=num;
			}
		}
		
		
		for(int i=1;i<MAX;i++) {
			search(i);
		}
		
		System.out.println(result);
		
		

	}

	private static void search(int level) {
		int cnt = 0;
		visited = new boolean[N][N];
		Queue<int []> queue;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false  && Map[i][j]>level) {
					cnt++;
					queue = new LinkedList<int[]>();
					queue.add(new int[] {i,j});
					
					while(!queue.isEmpty()) {
						int[] tmp = queue.poll();
						
						int r=tmp[0];
						int c=tmp[1];
						
						for(int d=0;d<4;d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
							if(visited[nr][nc]==true)continue;
							visited[nr][nc]=true;
							
							if(Map[nr][nc]>level) {
								queue.add(new int[] {nr,nc});
							}
						}
						
					}
				}
			}
		}
		if(cnt>result)result=cnt;
	}

}
