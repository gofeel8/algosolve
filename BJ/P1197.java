import java.io.*;
import java.util.*;

public class P1197 {
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for(int i=1;i<=V;i++) {
			parent[i]=i;
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		int select = 0;
		int sum=0;
		while(select<V-1) {
			
			int now[] = pq.poll();
			
			int f1 = findParent(now[0]);
			int f2 = findParent(now[1]);
			if(f1==f2)continue;
			
			union(f1,f2);
			sum+=now[2];
			select++;
		}
		
		System.out.println(sum);

	}
	
	
	public static int findParent(int now) {
		if(parent[now]==now) {
			return now;
		}
		return parent[now]=findParent(parent[now]);
	}
	
	public static void union(int n1,int n2) {
		parent[n2]=n1;
	}

}
