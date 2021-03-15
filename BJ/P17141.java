import java.io.*;
import java.util.*;

public class P17141 {
	public static List<int []> list;
	public static int[][] map;
	public static int result;
	public static int space;
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list = new ArrayList<int[]>(); 
		result = Integer.MAX_VALUE;
		space = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j]=tmp;
				if(tmp == 2) { //리스트에 저장
					list.add(new int[] {i,j});
					space++;
				}
				else if(tmp == 0 ) {
					space++;
				}
			}
		}
		
		int[] selected = new int[M];
		comb(0,0,selected );
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}

	private static void comb(int now, int idx,int[] arr) {
		if(idx==M) {
			//arr 에 선택된 곳에 바이러스를 놓고서 가득 채워질때까지 몇초가 경과하나 보고 result 갱신하기
			int cnt=0;
			boolean [][] visited = new boolean[N][N];
			Queue<int []> queue = new LinkedList<int[]>();
			for(int i=0;i<M;i++) {
				int[] tmp = list.get(arr[i]);
				queue.add(new int[] {tmp[0],tmp[1]});
				visited[tmp[0]][tmp[1]]=true;
				cnt++;
			}
			int time=-1;
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				time++;
				
				for(int i=0;i<size;i++) {
					int[] tmp = queue.poll();
					for(int d=0;d<4;d++) {
						int nr =tmp[0]+dr[d];
						int nc =tmp[1]+dc[d];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
						if(visited[nr][nc]==true)continue;
						if(map[nr][nc]==1)continue;
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
						cnt++;
					}
				}
				
			}
			
			if(cnt==space) {
				result = Math.min(time, result);
			}
			
			
			
			
			return;
		}
		
		for(int i=now;i<list.size();i++) {
			arr[idx]=i;
			comb(i+1,idx+1,arr);
		}
	}

}
