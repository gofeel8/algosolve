import java.util.*;
import java.io.*;
public class P4991 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w==0) break;
			char[][] map = new char[h][w];
			
			int sr =0;
			int sc = 0;
			int cnt = 0;
			for(int i=0;i<h;i++) {
				map[i]=br.readLine().toCharArray();
				for(int j=0;j<w;j++) {
					if(map[i][j]=='o') {
						sr = i;
						sc = j;
					}
					else if(map[i][j]=='*') {
						map[i][j] = (char)('0'+cnt);
						cnt++;
					}
				}
			}
			
			boolean[][][] visited = new boolean[1024][h][w]; 
			Queue<int []>queue = new LinkedList<int[]>();
			queue.add(new int[] {sr,sc,0,0});
			visited[0][sr][sc]=true;
			
			int step = 0;
			boolean find =false;
			while(!queue.isEmpty()) {
				int qsize = queue.size();
				
				
				for(int s= 0;s<qsize;s++) {
					int[] now = queue.poll();
					int nowCnt = now[3];
					if(map[now[0]][now[1]]!='.' && map[now[0]][now[1]]!='o') {
						int num = map[now[0]][now[1]]-'0';
						if(visited[now[2]|(1<<num)][now[0]][now[1]]==false) {
							nowCnt++;
							now[2] = now[2]|(1<<num);
							visited[now[2]][now[0]][now[1]]=true;
						}
					}
					if(nowCnt==cnt) {
						System.out.println(step);
						find = true;
						break;
					}
					
					
					for(int d= 0;d<4;d++) {
						int nr = now[0]+dr[d];
						int nc = now[1]+dc[d];
						
						if(nr<0 || nr>=h  || nc<0 | nc>=w)continue;
						if(map[nr][nc]=='x')continue;
						if(visited[now[2]][nr][nc])continue;
						visited[now[2]][nr][nc]=true;
						queue.add(new int[] {nr,nc,now[2],nowCnt});
					}
					
					
				}
				if(find)break;
				
				
				
				step++;
			}
			
			if(find == false) {
				System.out.println(-1);
			}
			
			
			
			
		}
	}

}
