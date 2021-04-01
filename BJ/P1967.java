import java.io.*;
import java.util.*;
public class P1167 {
	public static long answer;
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
		
		System.out.println(answer);
		
		
	}
	private static int dfs(int now,int total) {
		if(total>answer)answer=total;
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<list[now].size();i++) {
			if(used[list[now].get(i)[0]]==true)continue; //부모노드 방문 금지 
			used[list[now].get(i)[0]]=true;
			pq.add(list[now].get(i)[1]+dfs(list[now].get(i)[0],total+list[now].get(i)[1]));
		}
		if(pq.size()==0) {
			return 0;
		}
		int a =pq.poll();
		if(pq.size()>0) {
			int b =pq.poll();
			if(a+b>answer)answer=a+b;
		}
		
		return a;
		
		
		
	}
}
