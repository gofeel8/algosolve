import java.io.*;
import java.util.*;

public class P1197_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
	
		List<int []>[] list = new List[V+1];
		for(int i=0;i<=V;i++) {
			list[i]= new ArrayList<int []>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
			
		}
		
		int[] D = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1]=0;
		int sum = 0;
		int cnt =0;
		while(cnt!=V) {
			
			int Min=Integer.MAX_VALUE;
			int MinIdx=-1;
			
			for(int i=1;i<=V;i++) {
				if(visited[i]==false && D[i]<Min) {
					MinIdx=i;
					Min = D[i];
				}
			}
			
			visited[MinIdx]=true;
			sum+=Min;
			cnt++;
			
			for(int i=0;i<list[MinIdx].size();i++) {
				int b = list[MinIdx].get(i)[0];
				int c = list[MinIdx].get(i)[1];
				
				if(D[b]>c) {
					D[b]=c;
				}
			}
			
			
		}
		
		System.out.println(sum);
		
	
	}
	
}
