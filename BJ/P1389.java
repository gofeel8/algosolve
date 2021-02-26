import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389 {
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph=new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b]=1;
			graph[b][a]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)continue;
				for(int k=1;k<=N;k++) {
					if(k==i)continue;
					if(k==j)continue;
					if(graph[j][i] !=0 && graph[i][k] !=0) {
						if(graph[j][k]==0) {
							graph[j][k]=graph[j][i]+graph[i][k];
						}
						else {
							graph[j][k] = Math.min(graph[j][k], (graph[j][i]+graph[i][k]));
						}
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int minidx = 0;
		
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=N;j++) {
				sum+=graph[i][j];
//				System.out.print(graph[i][j]+ "");
			}
//			System.out.println();
			if(sum<min) {
				min=sum;
				minidx=i;
			}
		}
		
		System.out.println(minidx);

	}

}
