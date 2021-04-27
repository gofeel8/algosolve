import java.util.*;
import java.io.*;
public class P2213 {
	
	public static boolean[] visited;
	public static int[][] dp;
	public static int[] score;
	public static List<Integer>[] list;
	public static List<Integer> route;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N  = Integer.parseInt(br.readLine());
		score = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			score[i]=Integer.parseInt(st.nextToken());
		}
		
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
		
		visited = new boolean[N+1];
		
		dp = new int[N+2][2];
		
		visited[1]=true;
		search(1);
		
		System.out.println(Math.max(dp[1][1], dp[1][0]));
		
		route = new ArrayList<Integer>();
		visited = new boolean[N+1];
		visited[1]=true;
		
		
		trace(1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Collections.sort(route);
		for(int i=0;i<route.size();i++) {
			bw.write(String.valueOf(route.get(i))+" ");
		}
		bw.flush();
		bw.close();
		

	}

	private static void trace(int now) {
		if(dp[now][1]>=dp[now][0]) {
			route.add(now);
			for(int i=0;i<list[now].size();i++) {
				int tmp = list[now].get(i);
				if(visited[tmp]==false) {
					
					visited[tmp]=true;
					for(int j=0;j<list[tmp].size();j++) {
						int tmp2 = list[tmp].get(j);
						if(visited[tmp2]==false) {
							visited[tmp2]=true;
							trace(list[tmp].get(j));
						}
					}
				}
			}
		}else {
			for(int i=0;i<list[now].size();i++) {
				int tmp = list[now].get(i);
				if(visited[tmp]==false) {
					visited[tmp]=true;
					trace(tmp);
				}
			}
		}
		
	}

	private static void search(int now) {
		
		
		//본인 선택
		dp[now][1]=score[now];
		//본인 미선택
		dp[now][0]=0;
		
		for(int i=0;i<list[now].size();i++) {
			int can = list[now].get(i);
			if(visited[can]==false) {
				visited[can]=true;
				search(can);
				dp[now][1]+=dp[can][0];
				dp[now][0]+=Math.max(dp[can][0], dp[can][1]);
			}
		}
		
		
	}

}
