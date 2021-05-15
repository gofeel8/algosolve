import java.io.*;
import java.util.*;
public class P10423 {
	public static int[] parent;
	public static Set<Integer> center;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());
		
		center = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			center.add(Integer.parseInt(st.nextToken()));
		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] a1, int[] a2) {
				return a1[2]-a2[2];
			}
		});
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		if(N==K) {
			System.out.println(0);
			return;
		}
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		
		int cnt = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int pa = findParent(now[0]);
			int pb = findParent(now[1]);
			if(pa==pb)continue;
			if(center.contains(pa)&&center.contains(pb))continue;
			union(pa, pb);
			cnt++;
			sum+=now[2];
			if(cnt == N-K)break;
		}
		System.out.println(sum);
		
	}
	
	public static int findParent(int now) {
		if(parent[now]==now) {
			return now;
		}
		
		return parent[now] = findParent(parent[now]);
	}
	
	public static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		if(center.contains(pa)) {
			parent[pb]=pa;
		}else {
			parent[pa]=pb;
		}
	}

}
