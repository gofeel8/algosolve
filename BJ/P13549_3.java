import java.util.*;
import java.io.*;

public class P13549_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		
		
		int size = 100001;
		boolean[] checked = new boolean[size];
		Deque<int [] > deq = new ArrayDeque<>();
		deq.addFirst(new int[] {N,0});
		
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N]=0;
		while(!deq.isEmpty()) {
			int[] tmp = deq.poll();
			int now = tmp[0];
			int time =tmp[1];
			checked[now]=true;
			//순간이동
			if(now*2 < size && checked[now*2]==false && dist[now*2]>dist[now] ) {
				deq.addFirst(new int[] {now*2,time});
				dist[now*2]=dist[now];
			}
			//+1
			if(now+1 < size && checked[now+1]==false && dist[now+1]>dist[now]+1  ) {
				deq.addLast(new int[] {now+1,time+1});
				dist[now+1]=dist[now]+1;
			}
			
			//-1
			if(now-1 >=0&& checked[now-1]==false && dist[now-1]>dist[now]+1  ) {
				deq.addLast(new int[] {now-1,time+1});
				dist[now-1]=dist[now]+1;
			}
			
		}
		
		System.out.println(dist[K]);
		
		
		
	
	}
}
