import java.io.*;
import java.util.*;

public class P1774 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		double [][] adj = new double[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				double dist = Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[j][0]), 2)+Math.pow(Math.abs(arr[i][1]-arr[j][1]), 2));
				adj[i][j]=dist;
				adj[j][i]=dist;
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b]=0;
			adj[b][a]=0;
		}
		
		boolean[] used = new boolean[N+1];
		PriorityQueue<double []> pq = new PriorityQueue<>(new Comparator<double []>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[1], o2[1]);
			}
		});
		
		int cnt = 0;
		pq.add(new double[] {1,0});
		
		double sum = 0;
		
		while(cnt!=N) {
			double[] now = pq.poll();
			if(used[(int) now[0]]==true)continue;
			used[(int) now[0]]=true;
			cnt++;
			sum += now[1];
		
			for(int i=1;i<=N;i++) {
				if(used[i]==false) {
					pq.add(new double[] {i,adj[(int) now[0]][i]});
				}
			}
		}
		
		String str = String.format("%.2f", sum);
		System.out.println(str);
		

	}

}
