import java.util.*;
import java.io.*;
public class P1005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());//건물의 개수
			int K  = Integer.parseInt(st.nextToken());//규칙의 개수
			
			st = new StringTokenizer(br.readLine());
			int[] time = new int[N+1];
			for(int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] input = new int[N+1];
			List<Integer>[] list = new List[N+1];
			for(int i=0;i<=N;i++) {
				list[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				input[b]++;
			}
			
			int dest = Integer.parseInt(br.readLine());

			
			
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] sum = new int [N+1];
			for(int i=1;i<=N;i++) {
				if(input[i]==0) {
					sum[i]=time[i];
					queue.add(i);
				}
			}
			
			//start 부터 시작
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(now == dest ) {
					System.out.println(sum[now]);
					break;
				}
				
				for(int i = 0; i<list[now].size();i++) {
					int go = list[now].get(i);
					if(sum[go]<sum[now]+time[go]) {
						sum[go]=sum[now]+time[go];
					}
					input[go]--;
					if(input[go]==0) {
						queue.add(go);
					}
				}
				
			}
			
		}

	}

}
