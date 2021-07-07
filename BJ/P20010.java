import java.io.*;
import java.util.*;

public class P20010 {
	public static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<int []>[] adjList = new List[N];
		for(int i=0;i<N;i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		max = -1;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new int[] {b,c});
			adjList[b].add(new int[] {a,c});
		}
		
		boolean[] used = new boolean[N];
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int [] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {0,0,-1});
		int cnt =0;
		int sum =0;
		List<int []>[] shortList = new List[N];
		for(int i=0;i<N;i++) {
			shortList[i] = new ArrayList<int[]>();
		}
		while(!pq.isEmpty()) {
			while(used[pq.peek()[0]]==true) {
				pq.poll();
			}
			if(pq.size()==0)break;
			int[] now = pq.poll();
			cnt++;
			sum += now[1];
			used[now[0]]=true;
			
			if(now[2]!=-1) {
				shortList[now[2]].add(new int[] {now[0],now[1]});
				shortList[now[0]].add(new int[] {now[2],now[1]});
			}
			
			for(int i=0;i<adjList[now[0]].size();i++) {
				int[] can =adjList[now[0]].get(i);
				if(used[can[0]]==false) {
					pq.add(new int[] {can[0],can[1],now[0]});
				}
			}
			if(cnt == N)break;
			
		}
		for(int start=0;start<N;start++) {
			boolean[] visited = new boolean[N];
			visited[start]=true;
			dfs(start,shortList,visited,0);
		}
		
		System.out.println(sum);
		System.out.println(max);
	}

	private static void dfs(int idx, List<int[]>[] list, boolean[] visited, int sum) {
		if(sum>max)max = sum;
		int rt=0;
		for(int i=0;i<list[idx].size();i++) {
			int[] can = list[idx].get(i);
			if(visited[can[0]])continue;
			
			visited[can[0]]=true;
			dfs(can[0],list,visited,sum+can[1]);
		}
		
	}

}
