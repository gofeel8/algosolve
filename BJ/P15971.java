import java.io.*;
import java.util.*;

public class P15971 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  =Integer.parseInt(st.nextToken());
		int A  =Integer.parseInt(st.nextToken());
		int B  =Integer.parseInt(st.nextToken());
		
		List<int []>[] list = new List[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<int []>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp[] = new int[3];
			for(int j=0;j<3;j++) {
				tmp[j]=Integer.parseInt(st.nextToken());
			}
			list[tmp[0]].add(new int[] {tmp[1],tmp[2]});
			list[tmp[1]].add(new int[] {tmp[0],tmp[2]});
		}
		
		//A 에서 BFS 시작해서 B 만날때까지  sum 이랑 가장 큰값 기억하기
		
		boolean[] visited = new boolean[N+1];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {A,0,0});   //현재 방 ,sum, max
		visited[A]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int now = tmp[0];
			if(now == B) {
				System.out.println(tmp[1]-tmp[2]);
				break;
			}
			
			for(int i =0;i<list[now].size();i++) {
				if(visited[list[now].get(i)[0]]==false) {
					queue.add(new int[] {list[now].get(i)[0],tmp[1]+list[now].get(i)[1],tmp[2]>list[now].get(i)[1] ? tmp[2]:list[now].get(i)[1]});
					visited[list[now].get(i)[0]]=true;
				}
			}
			
			
		}
		
		return;

	}

}
