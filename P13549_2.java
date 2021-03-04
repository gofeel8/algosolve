import java.util.*;
import java.io.*;

public class P13549_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		
		int size =100000;
		
		int[] dist = new int[size+1];
		boolean[] checked = new boolean[size+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[N]=0;
		PriorityQueue<int [] >queue = new PriorityQueue(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}	
		});
		
		queue.add(new int[] {N,0});
		
		while(!queue.isEmpty()) {
			
			int[] now =queue.poll();
			
			
			int idx = now[0];
			int time = now[1];
			if(checked[idx])continue;
			checked[idx]=true;
			
			//순간이동
			if(idx*2<size+1&&checked[idx*2]==false && dist[idx*2]>time ) {
				dist[idx*2]=time;
				queue.add(new int[] {idx*2,time});
			}
			//+1
			if(idx+1<size+1&&checked[idx+1]==false && dist[idx+1]>time+1 ) {
				dist[idx+1]=time+1;
				queue.add(new int[] {idx+1,time+1});
			}
			
			//-1
			if(idx-1>=0 &&checked[idx-1]==false && dist[idx-1]>time+1 ) {
				dist[idx-1]=time+1;
				queue.add(new int[] {idx-1,time+1});
			}
			
		}
		
		System.out.println(dist[K]);
	}
}
