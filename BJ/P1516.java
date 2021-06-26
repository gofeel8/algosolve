import java.io.*;
import java.util.*;

public class P1516 {
	public static int[] memo,time;
	public static List<Integer>[] need;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		time = new int[N+1];
		need = new List[N+1];
		for(int i=0;i<=N;i++) {
			need[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i]=t;
			while(st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				if(now == -1)break;
				need[i].add(now);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1;i<=N;i++) {
			bw.write(String.valueOf(dfs(i)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	private static int dfs(int now) {
		if(memo[now]!=0) {
			return memo[now];
		}
		
		int max = -1;
		for(int i=0;i<need[now].size();i++) {
			max = Math.max(max, dfs(need[now].get(i)));
		}
		
		if(max!=-1) {
			return memo[now]=max+time[now];
		}
		return memo[now]=time[now];
		
	}

}
