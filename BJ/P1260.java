import java.io.*;
import java.util.*;

public class P1260 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1;i<=N;i++) {
			
			Collections.sort(list[i]);
		}
		
//		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(list[i].toArray(new Integer[list[i].size()])));
//		}
		
		
		dfs(V);
//		System.out.println();
		bw.newLine();
		visited = new boolean[N+1];
		
		bfs(V);
		
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int start) throws IOException {
//		System.out.print(start+" ");
		bw.write(start+" ");
		visited[start]=true;
		for(int i=0;i<list[start].size();i++) {
			int temp = list[start].get(i);
			if(visited[temp]==false) {
				dfs(temp);
			}
		}
	}
	
	
	public static void bfs(int start) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start]=true;
		while(!queue.isEmpty()) {
			int now =queue.poll();
//			System.out.print(now+" ");
			bw.write(now+" ");
			for(int i=0;i<list[now].size();i++) {
				int tmp=list[now].get(i);
				if(visited[tmp]==false) {
					queue.add(tmp);
					visited[tmp]=true;
				}
			}
		}
	}

	
}
