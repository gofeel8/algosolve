import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {
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
		for(int i=0;i<V-1;i++) {
			st = new StringTokenizer(br.readLine());
			int now =Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			list[now].add(new int[] {go,point});
			list[go].add(new int[] {now,point});
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
