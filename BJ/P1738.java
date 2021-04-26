import java.util.*;
import java.io.*;
public class P1738 {
	public static final int MAX = 100000000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int []>[] list = new List[n+1];
		List<Integer>[] reverselist = new List[n+1];
		
		for(int i=0;i<=n;i++) {
			list[i] =  new ArrayList<>();
			reverselist[i] =  new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,-1*w});
			reverselist[b].add(a);
		}
		
		
		boolean[] visited = new boolean[n+1];
		
		
		Queue<Integer> queue  = new LinkedList<>();
		queue.add(n);
		visited[n]=true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<reverselist[now].size();i++) {
				int can = reverselist[now].get(i);
				if(visited[can]==false) {
					queue.add(can);
					visited[can]=true;
				}
			}
		}
		
		
		
		
		
		int[] dist = new int[n+1];
		Arrays.fill(dist,MAX);
		dist[1]=0;
		
		int[] parent = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		boolean cycle = false;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=0;k<list[j].size();k++) {
					int [] tmp = list[j].get(k);
					if(dist[tmp[0]]>dist[j]+tmp[1]) {
						dist[tmp[0]]=dist[j]+tmp[1];
						parent[tmp[0]]=j;
						if(i==n && visited[tmp[0]]) {
							cycle = true;
						}
					}
				}
			}
			
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(cycle) {
			bw.write("-1");
		}else {
			
			Stack<Integer> stack = new Stack<>();
			int start = n;
			while(parent[start]!=start) {
				stack.push(start);
				start = parent[start];
			}
			stack.push(1);
			while(!stack.isEmpty()) {
				bw.write(String.valueOf(stack.pop())+" ");
			}
		}
		bw.flush();
		bw.close();

	}

}
