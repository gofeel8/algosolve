import java.io.*;
import java.util.*;

public class P1043 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());   //사람 수
		int M = Integer.parseInt(st.nextToken());  // 파티 수
		
		st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<num;i++) {
			int who = Integer.parseInt(st.nextToken());
			queue.add(who);
			visited[who]=true;
		}
		
		
		boolean[][] map = new boolean[M+1][N+1];
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				map[i][Integer.parseInt(st.nextToken())]=true;
			}
		} 
		
		
		boolean[] lie = new boolean[M+1];
		
		while(!queue.isEmpty()) {
			int now = queue.poll();  // 진실을 알고있는 사람이 갈수있는 파티 처리 하기
			
			for(int i=1;i<=M;i++) {
				if(lie[i]==false && map[i][now]==true) {  //이 파티에 가는 사람들 다  queue 에 집어넣어야함
					lie[i]=true;
					
					for(int q=1;q<=N;q++) {
						if(visited[q]==false && map[i][q]==true) {
							queue.add(q);
							visited[q]=true;
						}
					}
					
				}
			}
			
		}
	
		int cnt =0;
		for(int i=1;i<=M;i++) {
			if(lie[i]==false)cnt++;
		}
		System.out.println(cnt);
	}

}
