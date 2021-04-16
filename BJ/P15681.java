import java.io.*;
import java.util.*;

public class P15681 {
	public static int[] dp;
	public static boolean[] visited;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		visited = new boolean[N+1];
		
		list = new List[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(R);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<Q;i++) {
			int n = Integer.parseInt(br.readLine());
			bw.append(String.valueOf(dp[n]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

	private static int dfs(int now) {
		dp[now]=1;
	
		visited[now]=true;
		
		for(int i=0;i<list[now].size();i++) {
			int can = list[now].get(i);
			if(visited[can]==false) {
				dp[now]+=dfs(can);
			}
			
		}
		
		return dp[now];
	}

}
