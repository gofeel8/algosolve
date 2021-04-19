import java.util.*;
import java.io.*;
public class P2665 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		boolean[][] map = new boolean[N][N];
		int[][] visited =new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
			str = br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j)=='1') {
					map[i][j]=true;
				}
			}
		}
		
		
		Queue<int []>queue = new LinkedList();
		queue.add(new int[] {0,0,0});
		visited[0][0]=0;
		
		int answer = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			if(now[0]==N-1 && now[1]==N-1) {
				answer = Math.min(answer, now[2]);
				continue;
			}
			
			for(int d=0;d<4;d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr<0 || nr>=N || nc<0 ||nc>=N)continue;
				if(visited[nr][nc]<=now[2])continue;
				
				if(map[nr][nc]) {   //흰방
					queue.add(new int[] {nr,nc,now[2]});
					visited[nr][nc]=now[2];
				}else {     //검은방
					queue.add(new int[] {nr,nc,now[2]+1});
					visited[nr][nc]=now[2]+1;
				}
			}
			
		}
		System.out.println(answer);

	}

}
