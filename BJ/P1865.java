import java.io.*;
import java.util.*;
public class P1865 {

	public static final int MAX =1000000;  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(st.nextToken());
			int M =Integer.parseInt(st.nextToken());
			int W =Integer.parseInt(st.nextToken());
			int [][] map = new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				Arrays.fill(map[i], MAX);
			}
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if(map[s][e]>time) {
					map[s][e]=time;
					map[e][s]=time;
				}
			}
			
			for(int j=0;j<W;j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				map[s][e]=-time;
			}
			
			boolean flag =false;
			
			for(int a=1;a<=N;a++) {//경유 
				for(int b=1;b<=N;b++) { //출발
					for(int c=1;c<=N;c++) {//도착
						if(map[b][c]>map[b][a]+map[a][c]) {
							map[b][c]=map[b][a]+map[a][c];
							if(b==c && map[b][c]<0) {
								flag= true;
								break;
							}
						}
					}
					if(flag)break;
				}
				if(flag)break;
				
			}
			
			System.out.println(flag ? "YES" : "NO");
			
		}

	}

}
