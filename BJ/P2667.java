import java.io.*;
import java.util.*;

public class P2667 {
	static int[][] map;
	static List<Integer> list;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str =br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		

	}

	private static void bfs(int r, int c) {
		int cnt=0;
//		System.out.println(r+","+c);
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		map[r][c]=0;
		cnt++;
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int nr=arr[0];
			int nc=arr[1];
			
			for(int i=0;i<4;i++) {
					if(nr+dr[i]>=0 && nr+dr[i]<N && nc+dc[i]>=0 && nc+dc[i]<N) {
						if(map[nr+dr[i]][nc+dc[i]]==1) {
							map[nr+dr[i]][nc+dc[i]]=0;
							queue.add(new int[] {nr+dr[i],nc+dc[i]});
							cnt++;
						}
					}
			}
		}
		list.add(cnt);
		return;
	}

}
