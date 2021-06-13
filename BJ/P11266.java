import java.io.*;
import java.util.*;

public class P11266 {
	public static int idx;
	public static int[] order;
	public static List<Integer>[] list;
	public static boolean[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new List[V+1];
		for(int i=0;i<=V;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		ans= new boolean[V+1];
		order = new int[V+1];
		
		for(int i=1;i<=V;i++) {
			if(order[i]==0) {
				idx = 1;
				dfs(i,true);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<ans.length;i++) {
			if(ans[i]) {
				queue.add(i);
			}
		}
		bw.write(String.valueOf(queue.size()));
		bw.newLine();
		while(!queue.isEmpty()) {
			bw.write(String.valueOf(queue.poll())+" ");
			
		}
		bw.flush();
		bw.close();
		
	}

	private static int dfs(int now, boolean root) {
		order[now]  = idx++;
		int min = order[now];
		
		int child =0;
				
		for(int i=0;i<list[now].size();i++) {
			int tmp = list[now].get(i);
			if(order[tmp]==0) {
				//자식발견
				child ++;
				int value = dfs(tmp,false);
				//자식이 나없어도 높은곳가나 확인
				if(!root&& order[now]<=value) {
					ans[now]=true;
				}
				
				min = Math.min(min, value);
			}else {
				//이전에 체크했던곳
				min = Math.min(min, order[tmp]);
			}
		}
		
		
		if(root && child>1) {
			ans[now]=true;
		}
		
		return min;
		
		
	}

}
