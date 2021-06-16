import java.io.*;
import java.util.*;

public class P17616 {
	public static boolean[] visited;
	public static List<Integer>[] uplist,downlist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		uplist = new  List[N+1];
		downlist =new  List[N+1];
		for(int i=0;i<=N;i++) {
			uplist[i] = new ArrayList<Integer>();
			downlist[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			//a가 b보다 높음
			uplist[b].add(a);
			downlist[a].add(b);
		}
		
		visited = new boolean[N+1];
		
		int up = dfs(X,0);
		int down = dfs(X,1);
		System.out.println((1+up)+" "+(N-down));
		
		
	}

	private static int dfs(int x, int mode) {
		int rt=0;
		if(mode ==0) { //x보다 잘난놈 찾아 리턴
			for(int i=0;i<uplist[x].size();i++) {
				int can = uplist[x].get(i);
				if(visited[can]==false) {
					visited[can]=true;
					rt++;
					rt+=dfs(can,mode);
				}
			}
		}else { //x보다 못난놈 찾아리턴
			for(int i=0;i<downlist[x].size();i++) {
				int can = downlist[x].get(i);
				if(visited[can]==false) {
					visited[can]=true;
					rt++;
					rt+=dfs(can,mode);
				}
			}
		}
		return rt;
	}
	

}
