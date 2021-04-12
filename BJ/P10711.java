import java.io.*;
import java.util.*;

public class P10711 {
	public static int[] dr = {-1,-1,0,1,1,1,0,-1};
	public static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static int[][] sand;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R =  Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		sand = new int[R][C];          //주변 모래 수

		String str;
		Queue<int []> queue = new LinkedList<int[]>();
		for(int i=0;i<R;i++) {
			str = br.readLine();
			for(int j=0;j<C;j++) {
				char tmp = str.charAt(j);
				if(tmp =='.') {     //모래일때 처리
					queue.add(new int [] {i,j});
				}else {
					map[i][j] = tmp-'0';
				}
			}
		}
		
		int answer= 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();  //현재 처리해야하는 모래 큐
			for(int i=0;i<qsize;i++) {
				int [] now = queue.poll();
				
				for(int d=0;d<8;d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					sand[nr][nc]++;
					if(map[nr][nc]!=0 && sand[nr][nc]>=map[nr][nc]) {
						map[nr][nc]=0;
						queue.add(new int[] {nr,nc});
					}
				}
				
			}
			
			
			answer++;
		}
		
		System.out.println(answer-1);
		

	}
	

}
