import java.lang.*;
import java.util.*;
import java.io.*;
/**
 *  Linkedlist 로 하면 시간 초과 o
 *  ArrayList로 하면 시간초과 x
 *  한참 삽질함
 */
public class P1939 {
	static boolean[] visited;
	static List<int[]>[] list;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		int maxC =0;
		int minC =Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			minC = Math.min(minC, c);
			maxC = Math.max(maxC, c);
			list[a].add(new int[]{b,c});
			list[b].add(new int[]{a,c});
		}
		st = new StringTokenizer(br.readLine());
		int land1 = Integer.parseInt(st.nextToken());
		int land2 = Integer.parseInt(st.nextToken());
		int result = 0;
		while(minC<=maxC) {
			visited = new boolean[N+1];
			int mid =(minC+maxC)/2;
			if(Bfs(land1,land2,mid)) {
				result=mid;
				minC=mid+1;
			}else {
				maxC=mid-1;
			}
		}
		System.out.println(result);
	}
	private static boolean Bfs(int land1, int land2, int mid) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(land1);

		visited[land1]=true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<list[now].size();i++) {
				if(visited[list[now].get(i)[0]]==false &&list[now].get(i)[1]>=mid) {
					if(list[now].get(i)[0]==land2) {
						return true;	
					}
					visited[list[now].get(i)[0]]=true;
					queue.add(list[now].get(i)[0]);
				}
				
			}
		}
		return false;
	}
}
