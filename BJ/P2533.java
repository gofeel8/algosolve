import java.io.*;
import java.util.*;

public class P2533 {
	public static List<Integer>[] list;
	public static int[][] dp;
	public static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		dp = new int[2][N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st ;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visited[1]=true;
		search(1);
		
		System.out.println(Math.min(dp[0][1], dp[1][1]));
		
	}

	private static void search(int idx) {
		
		dp[1][idx]=1;
		for(int i=0;i<list[idx].size();i++) {
			int can = list[idx].get(i);
			if(visited[can])continue;
			visited[can] = true;
			search(can);
			dp[0][idx] += dp[1][can];
			dp[1][idx] += Math.min(dp[0][can],dp[1][can]);
		}
		
	}

}
