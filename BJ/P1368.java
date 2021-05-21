import java.io.*;
import java.util.*;
public class P1368 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N];
		for(int i=0;i<N;i++) {
			dist [i] = Integer.parseInt(br.readLine());
		}
		StringTokenizer st;
		int[][] adj = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[N];
		int sum = 0;
		for(int i =0;i<N;i++) {
			int minIdx  = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(visited[j])continue;
				if(dist[j] < min) {
					min = dist[j];
					minIdx = j;
				}
			}
			
			visited[minIdx]=true;
			sum += dist[minIdx];
			
			for(int j=0;j<N;j++) {
				if(visited[j])continue;
				if(dist[j] > adj[minIdx][j]) {
					dist[j]=adj[minIdx][j];
				}
			}
			
			
		}
		System.out.println(sum);

	}

}
