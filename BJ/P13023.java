import java.io.*;
import java.util.*;
public class P13023 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new List[N];
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			boolean[] used = new boolean[N];
			used[i] = true;
			if(dfs(i,1,used,list)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);

	}

	private static boolean dfs(int now, int cnt, boolean[] used,List<Integer>[] list ) {
		if(cnt==5) {
			return true;
		}
		
		for(int i=0;i<list[now].size();i++) {
			int can = list[now].get(i);
			if(used[can]==false) {
				used[can]=true;
				if(dfs(can,cnt+1,used,list)) {
					return true;
				}
				used[can]=false;
			}
		}
		
		return false;
	}

}
