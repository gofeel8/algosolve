import java.io.*;
import java.util.*;
public class P14248 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start =Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		visited[start]= true;
		int cnt = 1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now+arr[now]<=N && visited[now+arr[now]]==false) {
				queue.add(now+arr[now]);
				visited[now+arr[now]]=true;
				cnt ++;
			}
			if(now-arr[now]>=1 && visited[now-arr[now]]==false) {
				queue.add(now-arr[now]);
				visited[now-arr[now]]=true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
