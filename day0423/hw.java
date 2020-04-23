import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L; // L이상
	static int R; // R이하
	static int[][] P; // 인구수
	static boolean[][] V;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		P= new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				P[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		boolean changed = false;
		boolean gps = true;
		int result = -1;;
		while(gps) {
			result++;
			gps=false;
			V= new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!V[i][j]) {
						changed  = dfs(i,j);
						if(changed)gps=true;
					}
				}
			}

		}
		System.out.println(result);
		

	}

	
	private static boolean dfs(int x, int y) {
		boolean rt =false;
		V[x][y]=true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y,P[x][y]));
		int cnt=0;
		int sum=0;
		List<Node> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			list.add(temp);
			cnt++;
			sum+=temp.score;
			for (int i = 0; i < dx.length; i++) {
					if(temp.x+dx[i]<0||temp.x+dx[i]>=N||temp.y+dy[i]<0||temp.y+dy[i]>=N||V[temp.x+dx[i]][temp.y+dy[i]] ) {
						continue;
					}else {
						int gap = Math.abs(P[temp.x][temp.y] - P[temp.x+dx[i]][temp.y+dy[i]]);
						if(gap>=L && gap<=R) {
						queue.add(new Node(temp.x+dx[i], temp.y+dy[i], P[temp.x+dx[i]][temp.y+dy[i]]));
						V[temp.x+dx[i]][temp.y+dy[i]]=true;
						}
					}
			}
		}
		int avg = sum/cnt;
		for (Node node : list) {
			P[node.x][node.y]=avg;
		}
		if(cnt > 1) {
			rt = true;
		}
		return rt;
	}


	public static class Node{
		int x;
		int y;
		int score;
		public Node(int x,int y,int score) {
			this.x=x;
			this.y=y;
			this.score=score;
			
		}
	}

}
