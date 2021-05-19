import java.io.*;
import java.util.*;
public class P11779 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M  = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<int []>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		//목적지와 엔드 같을경우?
		
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {start,0,-1});
		int[] parent = new int[N+1];
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(visited[now[0]])continue;
			visited[now[0]]=true;
			dist[now[0]]=now[1];
			parent[now[0]]=now[2];
			if(now[0]==end)break;
			for(int i=0;i<list[now[0]].size();i++) {
				int can = list[now[0]].get(i)[0];
				if(visited[can])continue;
				int price = dist[now[0]]+list[now[0]].get(i)[1];
				if(price<dist[can]) {
					pq.add(new int[] {can,price,now[0]});
				}
			}
		}
		Stack<Integer> route = new Stack<>();
		route.push(end);
		int idx = end;
		while(true) {
			idx= parent[idx];
			if(idx==-1)break;
			route.push(idx);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.println(String.valueOf(dist[end]));
		bw.write(String.valueOf(route.size()));
		bw.newLine();
		while(!route.isEmpty()) {
			bw.write(String.valueOf(route.pop()+" "));
		}
		bw.flush();
		bw.close();

	}

}
