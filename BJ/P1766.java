import java.io.*;
import java.util.*;

public class P1766 {
	public static List<Integer>[] adj;
	public static int[] cnt;
	public static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new List[N+1];
		for(int i=0;i<=N;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		cnt = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B);
			cnt[B]++;
		}
		
		used = new boolean[N+1];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			if(cnt[i]==0) {
				pq.add(i);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(!pq.isEmpty()) {
			int now = pq.poll();
			bw.write(String.valueOf(now)+" ");
			for(int i=0;i<adj[now].size();i++) {
				int tmp =adj[now].get(i);
				cnt[tmp]--;
				if(cnt[tmp]==0)pq.add(tmp);
			}
		}
		bw.flush();
		bw.close();
		
	
	}
	

}
