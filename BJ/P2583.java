import java.util.*;
import java.io.*;

public class P2583 {
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int M;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			draw(lx,ly,rx,ry);
			
		}
		PriorityQueue<Integer> result = new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) {
					result.add(bfs(i,j));
				}
			}
		}

		System.out.println(result.size());
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}

	}

	private static int bfs(int row, int col) {
		int rt=0;
		Queue<int []>queue =new LinkedList<int[]>();
		queue.add(new int[] {row,col});
		map[row][col]=1;
		rt++;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d=0;d<4;d++) {
				int nr =r+dr[d];
				int nc =c+dc[d];
				if(nr>=0 && nr<M && nc>=0 && nc<N) {
					if(map[nr][nc]==0) {
						map[nr][nc]=1;
						rt++;
						queue.add(new int[] {nr,nc});
					}
				}
			}
		}
		return rt;
		
	}

	private static void draw(int lx, int ly, int rx, int ry) {
		int startRow = ly;
		int startCol = lx;
		
		int colSpace = rx-lx;
		int rowSpace = ry-ly;
		
		for(int i=0;i<rowSpace;i++){
			for(int j=0;j<colSpace;j++) {
				map[startRow+i][startCol+j]=1;
			}
		}
	}

}
