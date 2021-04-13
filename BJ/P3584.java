import java.util.*;
import java.io.*;

public class P3584 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] parent = new int[N+1];
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b]=a;
			}
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[N+1];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(a);
			queue.add(b);
			visited[a]=true;
			visited[b]=true;
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				int nowParent = parent[now];
				if(visited[nowParent]==true) {
					//찾았다
					System.out.println(nowParent);
					break;
				}
				if(nowParent != 0 ) {
					queue.add(nowParent);
				}
				visited[nowParent]=true;
			}
			
		}
		
	}
}
