import java.io.*;
import java.util.*;

public class P17836 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		int gram = Integer.MAX_VALUE;
		
		boolean[][] visited = new boolean[N][M];
		
		Queue<int [] > queue = new LinkedList<>();
		queue.add(new int [] {0,0});
		visited[0][0] = true;
		
		int cnt=0;
		boolean find = false;
		while(!queue.isEmpty()) {
			cnt++;
			int qsize = queue.size();
			
			
			for(int s=0;s<qsize;s++) {
				int[] now = queue.poll();
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>= M) continue;
					if(map[nr][nc]==1)continue;
					if(visited[nr][nc]==true)continue;
					if(map[nr][nc]==2) {   //검 찾았을때
						int gap = ((N-1)-nr)+ ((M-1)-nc);
						gram = cnt+gap;
						visited[nr][nc]=true;
						continue;
					}
					if(nr==N-1 && nc==M-1) { //공주 찾았을때 종로시키기
						find= true;
						break;
					}
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
				if(find)break;
			}
			if(find)break;
		}
		
		if(gram != Integer.MAX_VALUE) { //검은 찾았고
			if(find) { //공주를 찾았을때
				if(gram<cnt) {
					cnt =gram;
				}
			}else {  //공주를 못찾았을 때
				cnt =gram;
			}
			find = true;
		}
		
		
		if(find && T>=cnt) {
			System.out.println(cnt);
		}else {
			System.out.println("Fail");
		}
		
	}

}
