import java.util.*;
import java.io.*;

public class P14621 {
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		
		boolean[] isMan = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			char tmp = st.nextToken().charAt(0);
			if(tmp=='M') {
				isMan[i]=true;
			}
		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});		
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(isMan[a]&&isMan[b])continue;
			if(!isMan[a]&&!isMan[b])continue;
			
			pq.add(new int[] {a,b,c});
		}
		
		
		int answer = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			if(cnt==N-1) {
				System.out.println(answer);
				return;
			}
			
			int[] now = pq.poll();
			if(findParent(now[0]) == findParent(now[1]))continue;
			union(now[0],now[1]);
			cnt++;
			answer+=now[2];
		}
		
		if(cnt==N-1) {
			System.out.println(answer);
			return;
		}
		System.out.println(-1);
		
	}
	
	public static int findParent(int now) {
		if(parent[now]==now) {
			return now;
		}
		
		return parent[now]=findParent(parent[now]);
	}
	
	public static void union(int a,int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		parent[pa]=pb;
	}

}
