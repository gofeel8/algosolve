import java.util.*;
import java.io.*;
public class P14950 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		List<int []>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		
		boolean[] used = new boolean[N+1];
		
		int sum = 0;
		for(int i = 0 ;i < N;i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for(int j=1;j<=N;j++) {
				if(used[j])continue;
				if(dist[j]<min) {
					min = dist[j];
					minIdx  = j;
				}
			}
			if(minIdx ==-1)break;
			if(i!=0) {
				sum  = sum + dist[minIdx]+((i-1)*T);
			}
			used[minIdx]=true;
			
			
			//minIdx 에서 업그레이드 
			for(int j=0;j<list[minIdx].size();j++) {
				int[] can = list[minIdx].get(j);
				if(used[can[0]])continue;
				if(dist[can[0]]>can[1])dist[can[0]]=can[1];
			}
			
		}
		System.out.println(sum);

	}

}
