import java.util.*;
import java.io.*;

public class P5014 {
	public static int F,S,G,U,D;
	public static boolean[] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());  //총 층수
		S = Integer.parseInt(st.nextToken());  //현재 위치
		G = Integer.parseInt(st.nextToken());  //회사 위치
		U = Integer.parseInt(st.nextToken());  //Up
		D = Integer.parseInt(st.nextToken());  //Down
		
		if(S == G) {
			System.out.println("0");
			return;
		}
		
		
		visited = new boolean[F+1];
		visited[S]= true;
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(S);
		int cnt=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			cnt++;
			
			for(int i=0;i<size;i++) {
				int tmp = queue.poll();
				
				//위
				int up =tmp+U;
				if(up<=F && visited[up]==false) {
					if(up == G) {
						System.out.println(cnt);
						return;
					}else {
						queue.add(up);
						visited[up]=true;
					}
				}
				
				//아래
				int down =tmp-D;
				if(down>0 && visited[down]==false) {
					if(down == G) {
						System.out.println(cnt);
						return;
					}else {
						queue.add(down);
						visited[down]=true;
					}
				}
			}
			
		}
		
		System.out.println("use the stairs");
		

	}

}
