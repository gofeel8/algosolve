import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1726 {
	public static int[] dr = {0,0,1,-1};
	public static int[] dc = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int R= Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int startx =Integer.parseInt(st.nextToken())-1;
		int starty =Integer.parseInt(st.nextToken())-1;
		int startd =Integer.parseInt(st.nextToken())-1;

		st = new StringTokenizer(br.readLine());
		int endx =Integer.parseInt(st.nextToken())-1;
		int endy =Integer.parseInt(st.nextToken())-1;
		int endd =Integer.parseInt(st.nextToken())-1;
				
		boolean[][][] visited = new boolean[R][C][4];
				
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startx,starty,startd));
		visited[startx][starty][startd]=true;

		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				
				Node now = queue.poll();
				int row = now.row;
				int col = now.col;
				int dir = now.dir;
				if(row==endx && col==endy && dir==endd) {
					System.out.println(cnt);
					return;
				}
				
				//왼쪽 오른쪽 회전
				if(dir==0 || dir==1) {
					if(visited[row][col][2]==false) {
						queue.add(new Node(row, col, 2));
						visited[row][col][2]=true;
					}
					if(visited[row][col][3]==false) {
						queue.add(new Node(row, col, 3));
						visited[row][col][3]=true;
					}
				}else {
					if(visited[row][col][0]==false) {
						queue.add(new Node(row, col, 0));
						visited[row][col][0]=true;
					}
					if(visited[row][col][1]==false) {
						queue.add(new Node(row, col, 1));
						visited[row][col][1]=true;
					}
				}
				
				
				
				//이동
				for(int d=1;d<4;d++) { //현재 보고있는 방향으로 이동 1칸 2칸 3칸
					int nr = row+dr[dir]*d;
					int nc = col+dc[dir]*d;
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]==1)break;
					if(visited[nr][nc][dir]==false) {
						queue.add(new Node(nr, nc, dir));
						visited[nr][nc][dir]=true;
					}
				}
				
				
			
			}
			
			
			cnt++;
		}
		
		
	}
	
	public static class Node implements Comparable<Node>{
		int row;
		int col;
		int dir;
		
		Node(int r,int c,int d) {
			row = r;
			col = c;
			dir = d;
		}

		@Override
		public int compareTo(Node n) {
			
			return Integer.compare(dir, n.dir);
		}
		
		@Override
		public String toString() {
			return "row = "+row+"col ="+col+"dir = "+dir;
		}
	}

}
