import java.io.*;
import java.util.*;

public class P11967 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		List<int []>[][] list = new List[N+1][N+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				list[i][j] = new ArrayList<int[]>();
			}
		}
		for(int i=0;i<M;i++) {
			st = new  StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		
		
		boolean[][] light = new boolean[N+1][N+1];
		boolean[][] visited = new boolean[N+1][N+1];
		boolean[][] check = new boolean[N+1][N+1];
		
		light[1][1]=true;
		visited[1][1]=true;
		
		Queue<int []> queue = new LinkedList<int[]>();                  //양 위치
		queue.add(new int[] {1,1});
		
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for(int q =0;q<qsize;q++) {
				int[] now = queue.poll();
				if(check[now[0]][now[1]]==false) {
					check[now[0]][now[1]]=true;
					for(int i=0;i<list[now[0]][now[1]].size();i++) {
						int[] can = list[now[0]][now[1]].get(i);
						if(light[can[0]][can[1]]==false) {
							light[can[0]][can[1]]=true;
							for(int d=0;d<4;d++) {
								int nr =can[0]+dr[d];
								int nc =can[1]+dc[d];
								if(nr<=0 || nr>N ||nc<=0 || nc>N)continue;
								if(visited[nr][nc]==true) { //갈 수있음  
									queue.add(can);
									visited[can[0]][can[1]]=true;
									break;
								}
							}
						}
					}
				}
				
				for(int d=0;d<4;d++) {
					int nr =now[0]+dr[d];
					int nc =now[1]+dc[d];
					if(nr<=0 || nr>N ||nc<=0 || nc>N)continue;
					if(visited[nr][nc]==false && light[nr][nc]) { //갈 수있음  
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}

				
			
			}
		}
		
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(light[i]));
			for(int j=1;j<=N;j++) {
				if(light[i][j])cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
