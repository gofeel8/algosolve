import java.io.*;
import java.util.*;

public class P3055 {
	public static char[][] map;
	public static int R;
	public static int C;
	public static Queue<int []> water;
	public static Queue<int []> dochi;
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		water = new LinkedList<int[]>();
		dochi = new LinkedList<int[]>();
		
		map = new char[R][C];
		String str;
		for(int i=0;i<R;i++) {
			str =br.readLine();
			for(int j=0;j<C;j++) {
				char tmp =str.charAt(j);
				map[i][j]=tmp;
				if(tmp =='*') {
					water.add(new int[] {i,j});
					
				}else if(tmp =='S') {
					dochi.add(new int[] {i,j});
				}
					
			}
		}
		
		
//		System.out.println(water.size());
//		System.out.println(dochi.size());
		int time =0;
		while(!dochi.isEmpty()) {
			time++;
			int dsize = dochi.size();
			int wsize = water.size();
			
			//물부터 채우기
			for(int i=0;i<wsize;i++) {
				int[] now = water.poll();
				
				for(int d=0;d<4;d++){
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]=='D' ||map[nr][nc]=='*'  || map[nr][nc]=='X' )continue;
					map[nr][nc]='*';
					water.add(new int[] {nr,nc});
				}
			}
			
			//고슴도치가 갈수있는곳 가기
			
			for(int i=0;i<dsize;i++) {
				int[] now = dochi.poll();
				
				for(int d=0;d<4;d++){
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
					if(map[nr][nc]=='S'|| map[nr][nc]=='*'  || map[nr][nc]=='X' )continue;
					if(map[nr][nc]=='D') {
						System.out.println(time);
						return;
					}
					map[nr][nc]='S';
					dochi.add(new int[] {nr,nc});
				}
			}
			
			
			
		}
		
		
		System.out.println("KAKTUS");
		
		
		
		
		

	}

}
