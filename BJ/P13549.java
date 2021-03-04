import java.util.*;
import java.io.*;

public class P13549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		
		
		int size = 100001;
		
		boolean[] visited = new boolean[size];
		
		if(N==K) {
			System.out.println(0);
			return;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N,0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] now =queue.poll();
			
			int pos = now[0];
			int time = now[1];
			//순간이동 먼저
			while(pos!=0 && pos<size) {
				if(visited[pos]==false) {
					queue.add(new int[] {pos,time});
					visited[pos]=true;
					if(pos==K) {
						System.out.println(time);
						return;
					}
				}
				pos *=2;
			}
			
			pos=now[0];
			//걷기
			if(pos+1<size && visited[pos+1]==false) {
				queue.add(new int[] {pos+1,time+1});
				visited[pos+1]=true;
				if(pos+1 == K) {
					System.out.println(time+1);
					return;
				}
			}
			
			if(pos-1>=0&& visited[pos-1]==false) {
				queue.add(new int[] {pos-1,time+1});
				visited[pos-1]=true;
				if(pos-1 == K) {
					System.out.println(time+1);
					return;
				}
			}
		}

	}

}
