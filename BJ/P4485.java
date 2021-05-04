import java.util.*;
import java.io.*;

public class P4485 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int game =1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0)break;
			int[][] map = new int[N][N];
			int[][] min = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(min[i], Integer.MAX_VALUE);
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min[0][0] =map[0][0];
			Queue<int []> queue = new LinkedList<int[]>();
			queue.add(new int[] {0,0,min[0][0]});
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=N || nc<0 ||nc>=N)continue;
					int nscore = map[nr][nc]+now[2];
					if(nscore<min[nr][nc]) {
						queue.add(new int[] {nr,nc,nscore});
						min[nr][nc]=nscore;
					}
				}
			}
			bw.write("Problem "+game+": "+String.valueOf(min[N-1][N-1]));
			bw.newLine();
			game++;
		}
		bw.flush();
		bw.close();

	}

}
