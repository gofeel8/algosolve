import java.io.*;
import java.util.*;

public class P2098 {
	public static boolean[] visited;
	public static int result;
	public static int[][]  map;
	public static int N;
	public static int[][] memo;
	private static int INF = 16 * 1_000_000;
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		memo= new int[N][(1<<N)-1];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(memo[i], INF);
		}
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
			visited[0]=true;
			
//			search(0,0,0|1);
			System.out.println(search(0,0,0|1));
		

	}

	private static int search(int now,int idx,int route) {
		
		if(idx==N-1) {
			//다시 맨 처음으로 돌아오는길
			if(map[now][0]!=0) {
//				sum+=map[now][0];
//				result = Math.min(result, sum);
				return map[now][0];
			}
			return INF;
		
		}
		
		if(memo[now][route]!=INF) {
			return memo[now][route];
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]==false) {
				if(map[now][i]!=0) {
					visited[i]=true;
					memo[now][route] = Math.min(memo[now][route],(map[now][i]) +search(i, idx+1,(route | 1<<i)));
					visited[i]=false;
				}
			}
		}
		
		
		return memo[now][route];
			
	}
}
