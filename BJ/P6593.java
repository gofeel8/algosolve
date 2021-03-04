import java.util.*;
import java.io.*;

public class P6593 {
	public static int[] dr = {-1,0,1,0,0,0};
	public static int[] dc = {0,1,0,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st =new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L==0)break;
			
			char[][][] map = new char[L][R][C];
			int[] exit = new int[3];
			int[] start = new int[3];
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String str = br.readLine();
					for(int k=0;k<C;k++) {
						char tmp = str.charAt(k);
						map[i][j][k]=tmp;
						if(tmp == 'E') {
							start[0]=i;
							start[1]=j;
							start[2]=k;
						}else if(tmp == 'S') {
							exit[0]=i;
							exit[1]=j;
							exit[2]=k;
						}
					}
				}
				br.readLine();
			}
				
				
				
			Queue<int []> queue = new LinkedList<int[]>();
			queue.add(start);
				
			boolean find =false;
				
			int cnt=0;
			while(!queue.isEmpty()) {
				cnt++;
					
				int size = queue.size();
					
				for(int s=0;s<size;s++) {
					int[] now = queue.poll();
						
					for(int d=0;d<6;d++) {
					int nz = now[0]+dz[d];
					int nr = now[1]+dr[d];
					int nc = now[2]+dc[d];
				
							
						
						if(nr<0 || nr>=R || nc<0 || nc>=C || nz<0 || nz>=L)continue;
						if(map[nz][nr][nc] == '#' || map[nz][nr][nc] == 'E' )continue;
						
						if(map[nz][nr][nc]=='S') {
							System.out.println("Escaped in "+cnt+" minute(s).");
							find = true;
							break;
						}
						if(map[nz][nr][nc]=='.') {
							queue.add(new int[] {nz,nr,nc});
							map[nz][nr][nc]='E';
						}
					}
					if(find)break;					
				}
				if(find)break;
			}
			if(find == false) {
				System.out.println("Trapped!");
			}
			
			
			
			
		}


	}

}
