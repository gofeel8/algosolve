import java.io.*;
import java.util.*;

public class P4368 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double[][] dist =new double[N][N];
		double[][] gps =  new double[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			double d1 = Double.parseDouble(st.nextToken());
			double d2 = Double.parseDouble(st.nextToken());
			gps[i][0]=d1;
			gps[i][1]=d2;
			
			for(int j=0;j<i;j++) {
				// j 별에서 i 별 가는 거리 계산
				double tmp = Math.sqrt((Math.pow(Math.abs(gps[i][0]-gps[j][0]),2)+Math.pow((gps[i][1]-gps[j][1]),2)));
				dist[i][j]=dist[j][i]= tmp;
			}
		}
		
		//프림 알고리즘
		
		boolean[] used =  new boolean[N];
		
		double[] min = new double[N];
		Arrays.fill(min, Double.MAX_VALUE);
		
		min[0] = 0;
		int cnt=0;
		while(cnt!=N-1) {
			double minValue=Double.MAX_VALUE;
			int idx =-1;
			for(int i=0;i<N;i++) {
				if(minValue>min[i]&&used[i]==false) {
					minValue=min[i];
					idx=i;
				}
			}
			
			if(idx==-1)break;
			
			used[idx]=true;

			//idx 에서 갈 수 있는 모든 점 체크후 갱신
			for(int i=0;i<N;i++) {
				if(used[i]==false) {
					if(min[i]>dist[idx][i]) {
						min[i]=dist[idx][i];
					}
				}
			}
			
			cnt++;
		}
		
		double sum = 0;
		for(int i=0;i<N;i++) {
			sum+=min[i];
		}
		System.out.println(Math.round((sum*100))/100.0);

	}

}
