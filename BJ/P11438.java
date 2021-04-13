import java.util.*;
import java.io.*;

public class P11438 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		boolean[] visited = new boolean[N+1];
		int[][] parent = new int[N+1][21];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1]=true;
		
		int[] depth  = new int[N+1];
		depth[1]=1;  // 맞나?
		int cnt=1;
		while(!queue.isEmpty()) {
			cnt++;
			int qsize = queue.size();
			for(int j=0;j<qsize;j++) {
				int now = queue.poll();
				for(int i=0;i<list[now].size();i++) {
					int can = list[now].get(i);
					if(visited[can]==false) {
						queue.add(can);
						visited[can]=true;
						parent[can][0]=now;
						depth[can]=cnt;
					}
				}
			}
		}
		
		
		for(int i=1;i<=20;i++) {
			for(int j=1;j<=N;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//a가 더 깊어야함
			if(depth[b]>depth[a]) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			
			for(int j=20;j>=0;j--) {
				if(depth[a]-depth[b] >= (1<<j)) {
					a = parent[a][j];
				}
			}
			
			if(a==b) {
//				System.out.println(a);
				bw.append(String.valueOf(a));
				bw.newLine();
				continue;
			}
			
			
			for(int j=20;j>=0;j--) {
				if(parent[a][j] != parent[b][j]) {
					a=parent[a][j];
					b=parent[b][j];
				}
			}
//			System.out.println(parent[a][0]);
			bw.append(String.valueOf(parent[a][0]));
			bw.newLine();	
			
		}
		
		bw.flush();
		bw.close();
	}
}
