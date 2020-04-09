package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 프림
 * 인접행렬버전
 *
 */
public class BJ1197 {
	static int V, E;
	static int[][] adj;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		adj = new int[V + 1][V + 1];
		int E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			adj[x][y] = z;
			adj[y][x] = z;
		}
		
		int[] key = new int[V+1];
		boolean[] check = new boolean[V+1];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[1] = 0;
		
		
		for(int i=0;i<V-1;i++) {
			
			int index =-1;
			int min = Integer.MAX_VALUE;
			for(int j=1;j<V+1;j++) {
				if(!check[j] && key[j]<min) {
					index = j;
					min = key[j];
				}
			}
			
			check[index] = true;
			
			for(int j=1;j<V+1;j++) {
				if(!check[j] && adj[index][j] != 0 && key[j]>adj[index][j]) {
					key[j]=adj[index][j];
				}
			}
			
			
			
			
		}
		
		long result = 0;
		for(int i=1;i<=V;i++) {
			result += key[i];
		}
		System.out.println(result);
		
	}

}
