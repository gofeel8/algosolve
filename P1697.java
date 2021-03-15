import java.io.*;
import java.util.*;

public class P1697 {
	public static int me,you,size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		me = Integer.parseInt(st.nextToken());
		you = Integer.parseInt(st.nextToken());
		
		size = 200001;
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(me);
		visited[me]=true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for(int s=0;s<qsize;s++) {
				int now = queue.poll();
				if(now==you) {
					System.out.println(cnt);
					return;
				}
				if(now+1<size && visited[now+1]==false) {
					visited[now+1]=true;
					queue.add(now+1);
				}
				if(now-1>=0&& visited[now-1]==false) {
					visited[now-1]=true;
					queue.add(now-1);
				}
				if(now*2<size && visited[now*2]==false) {
					visited[now*2]=true;
					queue.add(now*2);
				}
			}
			cnt++;
		}
	}


}
