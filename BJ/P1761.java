import java.io.*;
import java.util.*;

public class P1761 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<int []>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<int []>();
		}
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		
		int[][] parent = new int [N+1][18];
		int[] dist = new int[N+1];
		int[] depth = new int[N+1];
		boolean[] visited = new boolean[N+1];
		//1부터 시작
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		
		int level=0;
		while(!queue.isEmpty()) {
			level++;
			int qsize = queue.size();
			for(int s=0;s<qsize;s++) {
				int now = queue.poll();
				for(int i=0;i<list[now].size();i++) {
					int can = list[now].get(i)[0];
					if(visited[can]==false) {
						parent[can][0]=now;
						dist[can]=dist[now]+list[now].get(i)[1];
						depth[can]=level;
						queue.add(can);
						visited[can]=true;
					}
				}
			}
		}
		
		for(int i=1;i<18;i++) {
			for(int j=1;j<=N;j++) {
				parent[j][i]=parent[parent[j][i-1]][i-1];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int ans =0;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(depth[b]>depth[a]) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			ans += dist[a];
			ans += dist[b];
			
			for(int j=17;j>=0;j--) {
				if(depth[a]-depth[b]>=(1<<j)) {
					a = parent[a][j];
				}
			}
			
			int node;
			if(a==b) {
				node = a;
			}
			else {
				for(int j=17;j>=0;j--) {
					if(parent[a][j] != parent[b][j]) {
						a = parent[a][j];
						b = parent[b][j];
					}
				}
				node = parent[a][0];
			}
			System.out.println(ans-dist[node]*2);
				
		}
		
		
		
	}

}
