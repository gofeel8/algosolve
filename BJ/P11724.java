import java.io.*;
import java.util.*;

public class P11724 {
	public static List<Integer>[] list; 
	public static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		checked = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int result = 0;
		
		for(int i=1;i<=N;i++) {
			if(checked[i]==false) {
				result++;
				dfs(i);
			}
		}
		
		System.out.println(result);

	}

	private static void dfs(int idx) {
		
		for(int i=0;i<list[idx].size();i++) {
			int tmp = list[idx].get(i);
			if(checked[tmp]==false) {
				checked[tmp]=true;
				dfs(tmp);
			}
		}
	}

}
