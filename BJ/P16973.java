import java.io.*;
import java.util.*;

public class P16973 {
	
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static int N,M,H,W;
	public static boolean[][] map,visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				if(st.nextToken().equals("1")) {
					map[i][j]=true;         // 벽일 경우 true
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int Sr = Integer.parseInt(st.nextToken())-1;
		int Sc = Integer.parseInt(st.nextToken())-1;
		int Fr = Integer.parseInt(st.nextToken())-1;
		int Fc = Integer.parseInt(st.nextToken())-1;
		
		
		visited = new boolean[N][M];
		
		Queue<int []> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {Sr,Sc});
		visited[Sr][Sc]=true;
		
		int cnt =0;
		while(!queue.isEmpty()) {
			
			int qsize = queue.size();
			
			for(int s=0;s<qsize;s++) {
				int[] now = queue.poll();
				if(now[0]==Fr && now[1]==Fc) {
					System.out.println(cnt);
					return;
				}
				
				
				//사방탐색하며 갈수있으면 큐에 추가 
				//갈 수있으면 
				if(up(now)) {
					queue.add(new int[] {now[0]-1,now[1]});
					visited[now[0]-1][now[1]]=true;
				}
				if(down(now)) {
					queue.add(new int[] {now[0]+1,now[1]});
					visited[now[0]+1][now[1]]=true;
				}
				if(left(now)) {
					queue.add(new int[] {now[0],now[1]-1});
					visited[now[0]][now[1]-1]=true;
				}
				if(right(now)) {
					queue.add(new int[] {now[0],now[1]+1});
					visited[now[0]][now[1]+1]=true;
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}

	private static boolean up(int[] now) {
		int r =now[0];
		int c =now[1];
		//범위 에 맞는지
		if(r-1<0)return false;
		
		if(visited[r-1][c])return false;
		
		//범위에 들어간다면  장애물은 안마주치는지
		for(int i=0;i<W;i++) {
			if(map[r-1][c+i]==true) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean down(int[] now) {
		int r =now[0];
		int c =now[1];
		//범위 에 맞는지
		if(r+H>=N)return false;
		if(visited[r+1][c])return false;
		//범위에 들어간다면  장애물은 안마주치는지
		for(int i=0;i<W;i++) {
			if(map[r+H][c+i]==true) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean right(int[] now) {
		int r =now[0];
		int c =now[1];
		//범위 에 맞는지
		if(c+W>=M)return false;
		if(visited[r][c+1])return false;
		//범위에 들어간다면  장애물은 안마주치는지
		for(int i=0;i<H;i++) {
			if(map[r+i][c+W]==true) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean left(int[] now) {
		int r =now[0];
		int c =now[1];
		//범위 에 맞는지
		if(c-1<0)return false;
		if(visited[r][c-1])return false;
		//범위에 들어간다면  장애물은 안마주치는지
		for(int i=0;i<H;i++) {
			if(map[r+i][c-1]==true) {
				return false;
			}
		}
		return true;
	}

}
