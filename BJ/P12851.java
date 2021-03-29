import java.util.*;
import java.io.*;

public class P13913_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int dong = Integer.parseInt(st.nextToken());
		if(subin==dong) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];
		int[] cnt = new int[100001];
		cnt[subin]=1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(subin);
		visited[subin]=true;
		cnt[subin]=1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int tmp :new int [] {now+1,now-1,now*2}) {
				if(tmp>=0 && tmp<=100000) {
					if(visited[tmp]==false) {//최초 도착
						dist[tmp]=dist[now]+1;
						cnt[tmp]=cnt[now];
						visited[tmp]=true;
						queue.add(tmp);
					}else {  //다른 방법
						if(dist[now]+1==dist[tmp]) {
							cnt[tmp]+=cnt[now];
						}
					}
				}
			}
		}
	System.out.println(dist[dong]);
	System.out.println(cnt[dong]);
	}
}
