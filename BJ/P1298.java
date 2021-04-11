import java.io.*;
import java.util.*;

public class P1298 {

	public static List<Integer>[] list;
	public static boolean[] used;
	public static int[] match;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		match = new int[N+1];
		list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		int cnt=0;
		for(int i=1;i<=N;i++) {
			used = new boolean[N+1];
			if(dfs(i))cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean dfs(int idx) {
		
		for(int i=0;i<list[idx].size();i++) {
			int can = list[idx].get(i);
			if(used[can])continue;
			used[can]=true;
			
			if(match[can]==0 || dfs(match[can])) {
				match[can]=idx;
				return true;
			}
		}
		
		
		return false;
	}

}
