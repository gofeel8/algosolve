import java.io.*;
import java.util.*;

public class P1949 {
	public static int[][] dp;
	public static boolean[] visited;
	public static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[N+1];
		dp=new int[N+1][2];
		for(int i=1;i<=N;i++) {
			people[i]= Integer.parseInt(st.nextToken());
			dp[i][1]=people[i];
		}
		list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new boolean[N+1];
		//1 을 루트 로 보자
		dfs(1);
		
	
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	private static void dfs(int now) {
		visited[now]=true;
		
		for(int i=0;i<list[now].size();i++) {
			int can = list[now].get(i);
			if(visited[can]==false) {
				dfs(can);
				dp[now][1]+=dp[can][0];
				dp[now][0]+=Math.max(dp[can][0], dp[can][1]);
			}
		}
		
	}

}
