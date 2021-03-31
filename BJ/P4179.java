import java.util.*;
import java.io.*;

public class P4179 {
	public static int[] dr= {-1,0,1,0};
	public static int[] dc= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		Queue<int []> fire = new LinkedList<int[]>();
		Queue<int []> jihun = new LinkedList<int[]>();
		
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				char tmp = str.charAt(j);
				map[i][j] = tmp;
				if(tmp=='J') {
					jihun.add(new int [] {i,j});
				}
				if(tmp=='F') {
					fire.add(new int [] {i,j});
				}
			}
		}
		
		int cnt = 0;
		while(!jihun.isEmpty()) {
			//불먼저 이동
			int fsize = fire.size();
			for(int i=0;i<fsize;i++) {
				int[] now = fire.poll();
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]=='#')continue;
					if(map[nr][nc]!='F') {
						map[nr][nc]='F';
						fire.add(new int[] {nr,nc});
					}
				}
			}
			
			
			//지훈 이동
			int jsize = jihun.size();
			for(int i=0;i<jsize;i++) {
				int[] now = jihun.poll();
				if(now[0]==0 || now[0]==R-1||now[1]==0||now[1]==C-1) {
					System.out.println(cnt+1);
					return;
				}
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]=='.') {
						map[nr][nc]='J';
						jihun.add(new int[] {nr,nc});
					}
				}
			}
			cnt++;
		}
		System.out.println("IMPOSSIBLE");
		
	}


}
