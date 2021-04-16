import java.io.*;
import java.util.*;
public class P1135 {
	public static int[] dp;
	public static List<Integer>[] list;
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new List[N];
		
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==-1)continue;
			list[num].add(i);
		}
		
		dp = new int[N];
		Arrays.fill(dp, 1);
		dp[0]=0;
		
		dfs(0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(String.valueOf(dp[0]));
		bw.flush();
		bw.close();
	}

	private static int dfs(int now) {
		int max=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<list[now].size();i++) {
			pq.add(dfs(list[now].get(i)));
		}
		
		for(int i=0;i<list[now].size();i++) {
			int num = pq.poll()+i;
			max = Math.max(max, num);
		}
		
		return dp[now]=dp[now]+max;
	}

}
