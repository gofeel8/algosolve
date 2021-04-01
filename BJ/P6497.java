import java.io.*;
import java.util.*;
//pq를 사용한 prim 문제

public class P6497 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N==0 && M ==0) {
			break;
		}
		List<int []>[] list = new List[N];
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<int []>();
		}
		int total = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
			total +=c;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] -o2[1];
			}
		});
		
		int sum =0;
		int cnt = 0;
		boolean[] used = new boolean[N];
		pq.add(new int[] {0,0});
		while(!pq.isEmpty()) {
			if(cnt == N)break;
			int [] now = pq.poll();
			if(used[now[0]]==true) {
				continue;
			}
			used[now[0]]=true;
			cnt++;
			sum+=now[1];
			//현재에서 갈수있는곳 다 pq 에 때려넣기
			for(int i=0;i<list[now[0]].size();i++) {
				pq.add(list[now[0]].get(i));
			}
		}
		System.out.println(total-sum);

	}	
	}

}
