import java.io.*;
import java.util.*;

public class P16947 {
	public static List<Integer>[] list ;
	public static int N;
	public static Set<Integer> rotateSet;
	public static boolean[] visited;
	public static List<Integer> rotateList;
	public static int findPoint;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new List[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		visited = new boolean[N+1];
		rotateList = new ArrayList<Integer>();
		findPoint = -1;
		rotateSet = new HashSet<>();
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		
		visited[1]=true;
		rotateList.add(1);
		dfs(1,0); //1번부터 dfs 해서 순환선 찾기
		for(int i=rotateList.indexOf(findPoint);i<rotateList.size();i++) {
			rotateSet.add(rotateList.get(i));
		}
		
		for(int i=1;i<=N;i++) {
			if(rotateSet.contains(i)) {
				System.out.print(0+" ");
			}else {
				System.out.print(bfs(i)+" ");
			}
		}
		

	}

	private static int bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		visited = new boolean[N+1];
		visited[num] = true;
		int cnt=0;
		while(!queue.isEmpty()) {
		
			int size = queue.size();
			
			for(int s=0;s<size;s++) {
				
			int now = queue.poll();
			if(rotateSet.contains(now)) {
				return cnt;
			}
			for(int i=0;i<list[now].size();i++) {
					int next = list[now].get(i);
					if(visited[next]==false) {
						queue.add(next);
						visited[next]=true;
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}

	private static void dfs(int num,int back) {
		
		for(int i=0;i<list[num].size();i++) {
			int now = list[num].get(i);
			if(visited[now]==false) {
				visited[now]=true;
				rotateList.add(now);
				dfs(now,num);
				if(findPoint!=-1)break;
				rotateList.remove(rotateList.indexOf(now));
				visited[now]=false;
			}else if(visited[now]==true && back != now){  
				findPoint =now;
				break;
			}
		}
		
	}

}


//4
//1 3
//4 3
//4 2
//1 2
