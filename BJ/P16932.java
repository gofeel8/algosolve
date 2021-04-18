import java.io.*;
import java.util.*;

public class P16932 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		
		Map<Integer, Integer> cntmap = new HashMap<Integer, Integer>();
//		List<int []> zero = new ArrayList<int[]>();
		Queue<int []>zero = new LinkedList<int[]>();
		int idx =2;
		boolean [][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j])continue;
				visited[i][j]=true;
				if(map[i][j]==1) {
					Queue<int []> queue = new LinkedList<int[]>();
					queue.add(new int[] {i,j});
					map[i][j]=idx;
					int cnt =1;
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						for(int d=0;d<4;d++) {
							int nr = now[0]+dr[d];
							int nc = now[1]+dc[d];
							if(nr<0 || nr>=N || nc<0 || nc>=M)continue;
							if(visited[nr][nc])continue;
							if(map[nr][nc]==1) {
								queue.add(new int[] {nr,nc});
								map[nr][nc]=idx;
								cnt++;
								visited[nr][nc]=true;
							}else if(map[nr][nc]==0) {
								zero.add(new int[] {nr,nc});
								visited[nr][nc]=true;
							}
						}
					}
					cntmap.put(idx, cnt);
					idx++;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		
		while(!zero.isEmpty()) {
			int[] now = zero.poll();
			int cnt=1;
//			boolean[] used = new boolean[idx];
			Set<Integer> used = new HashSet<>();
			for(int d=0;d<4;d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M)continue;
				if(map[nr][nc]!=0 && !used.contains(map[nr][nc])) {
					cnt+=cntmap.get(map[nr][nc]);
//					used[map[nr][nc]]=true;
					used.add(map[nr][nc]);
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);

	}

}
