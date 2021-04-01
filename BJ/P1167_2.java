import java.io.*;
import java.util.*;
public class P1167_2 {
	public static long answer;
	public static int root;
	public static List<int []>[] list;
	public static boolean[] used;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V =Integer.parseInt(br.readLine());
		StringTokenizer st;
		list =new List[V+1];
		used = new boolean[V+1];
		for(int i=0;i<=V;i++) {
			list[i]=new ArrayList<int[]>();
		}
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int now =Integer.parseInt(st.nextToken());
			while(true) {
				int go = Integer.parseInt(st.nextToken());
				if(go==-1)break;
				int point = Integer.parseInt(st.nextToken());
				list[now].add(new int[] {go,point});
			}
		}
		
		answer = -1;
		used[1]=true;
		dfs(1,0);
		
		used = new boolean[V+1];
		used[root]=true;
		dfs(root,0);
		
		System.out.println(answer);
		
		
	}
	private static void dfs(int now,int total) {
		
		boolean flag = false;
		
		for(int i=0;i<list[now].size();i++) {
			if(used[list[now].get(i)[0]]==true)continue; //부모노드 방문 금지 
			used[list[now].get(i)[0]]=true;
			dfs(list[now].get(i)[0],total+list[now].get(i)[1]);
			flag =true;
		}
		
		if(flag==false) {
			if(total>answer) {
				root = now;
				answer=total;
			}
			
		}
		
		
		
	}
}
