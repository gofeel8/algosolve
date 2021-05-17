import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class P2887 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		Comparator<int []> cp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		};
		
		PriorityQueue<int []> xpq = new PriorityQueue<>(cp);
		PriorityQueue<int []> ypq = new PriorityQueue<>(cp);
		PriorityQueue<int []> zpq = new PriorityQueue<>(cp);
		
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			 xpq.add(new int[] {Integer.parseInt(st.nextToken()),i});
			 ypq.add(new int[] {Integer.parseInt(st.nextToken()),i});
			 zpq.add(new int[] {Integer.parseInt(st.nextToken()),i});
		}
		
		int[][] xarr = new int[N][2];
		int[][] yarr = new int[N][2];
		int[][] zarr = new int[N][2];
		
		
		Map<Integer, Integer> xmap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> ymap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> zmap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<N;i++) {
			xarr[i][0] = xpq.peek()[0];
			xarr[i][1]=xpq.poll()[1];
			xmap.put(xarr[i][1], i);
			yarr[i][0] = ypq.peek()[0];
			yarr[i][1] =ypq.poll()[1];
			ymap.put(yarr[i][1], i);
			zarr[i][0] = zpq.peek()[0];
			zarr[i][1] = zpq.poll()[1];
			zmap.put(zarr[i][1], i);
		}
		
		boolean[] visited = new boolean[N];
		
		PriorityQueue<int []> pq = new PriorityQueue<>(cp);
		
		pq.add(new int[] {0,0});
		int cnt =0;
		long sum = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(visited[now[1]])continue;
			visited[now[1]]=true;
			sum+=now[0];
			cnt++;
			//now에서 갈 수있는곳 업데이트
			
			int idx = xmap.get(now[1]);
			if(idx-1>=0) {
				pq.add(new int[] {Math.abs(xarr[idx][0]-xarr[idx-1][0]),xarr[idx-1][1]});
			}
			if(idx+1<N) {
				pq.add(new int[] {Math.abs(xarr[idx+1][0]-xarr[idx][0]),xarr[idx+1][1]});
			}
			
			idx = ymap.get(now[1]);
			if(idx-1>=0) {
				pq.add(new int[] {Math.abs(yarr[idx][0]-yarr[idx-1][0]),yarr[idx-1][1]});
			}
			if(idx+1<N) {
				pq.add(new int[] {Math.abs(yarr[idx+1][0]-yarr[idx][0]),yarr[idx+1][1]});
			}
			
			
			
			idx = zmap.get(now[1]);
			if(idx-1>=0) {
				pq.add(new int[] {Math.abs(zarr[idx][0]-zarr[idx-1][0]),zarr[idx-1][1]});
			}
			if(idx+1<N) {
				pq.add(new int[] {Math.abs(zarr[idx+1][0]-zarr[idx][0]),zarr[idx+1][1]});
			}
			
			
			
			if(cnt == N)break;
		}
		
		System.out.println(sum);
		

	}

}
