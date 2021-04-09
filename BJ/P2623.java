import java.io.*;
import java.util.*;
public class P2623 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N+1];
		List<Integer>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j=0;j<num-1;j++) {
				int tmp= Integer.parseInt(st.nextToken());
				input[tmp]++;
				list[prev].add(tmp);
				prev =tmp;
			}
		}
		
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(input[i]==0) {
				queue.add(i);
				cnt ++;
			}
		}
		List<Integer> answer = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int now = queue.poll();
			answer.add(now);
			
			for(int i=0;i<list[now].size();i++) {
				int go = list[now].get(i);
				input[go]--;
				if(input[go]==0) {
					queue.add(go);
					cnt++;
				}
			}
		}
		
		if(cnt == N) {
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}else {
			System.out.println(0);
		}
		
		
	}

}
