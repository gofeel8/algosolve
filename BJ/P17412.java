import java.util.*;
import java.io.*;

public class P17412 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[][] C = new int[N+1][N+1];
		int[][] F = new int[N+1][N+1];
		
		
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			C[a][b]=1;
		}
		
		int cnt =0;
		while(true) {
			int[] D = new int[N+1];
			Arrays.fill(D, -1);
			D[1]=1;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(1);
			while(!queue.isEmpty()) {
				int now = queue.poll();
				for(int i=1;i<=N;i++) {
					if(C[now][i]-F[now][i]>0 && D[i]==-1) {
						D[i]=now;
						queue.add(i);
						if(i==2)break;
					}
				}
			}
			
			if(D[2]==-1)break;
			
			//sink 부터 시작해서 최솟값 찾기 과정은 패스
			
			// +1 또는 -1 업데이트
			
			for(int i=2;i!=1;i=D[i]) {
				F[D[i]][i]+=1;
				F[i][D[i]]-=1;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
