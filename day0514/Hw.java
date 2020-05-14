package BJ2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] field;
	static int result;
	static boolean[][] rained;
	static boolean[][] visited;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		result = 0;
		rained=new boolean[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				field[i][j]=num;
				if(num>max) {
					max=num;
				}else if(num<min) {
					min=num;
				}
			}
		}
		
		
		for(int i=min-1;i<=max;i++) {
			rain(i);
//			show(rained);
			int ct  = count();
//			System.out.println("cnt="+ct);
			if(ct>result)result=ct;
		}
		
		System.out.println(result);

	}
	
	
	
	
	private static int count() {
		int cnt=0;
		for(int i=0;i<N;i++) {
			visited[i]=rained[i].clone();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					BFS(i,j); // i,j 주변인접한곳 visited처리 해주기
					cnt++;
				}
			}
		}
		return cnt;
	}
	

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i,j});
		visited[i][j]=true;
		
		while(!queue.isEmpty()) {
			int[] now =queue.poll();
			
			for(int q=0;q<4;q++) {
				int nr=now[0]+dr[q];
				int nc=now[1]+dc[q];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&visited[nr][nc]==false) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
			}
		}
	}

	public static void rain(int n) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				if(field[i][j]==n) {
				if(field[i][j]<=n) {
					rained[i][j]=true;
				}
			}
		}
	}

}
