import java.io.*;
import java.util.*;

public class P14889 {
	public static int N;
	public static int[][] map;
	public static boolean[] team;
	public static int MIN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		map = new int[N][N];
		team = new boolean[N];
		MIN =Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		
		comb(0,0);
		
		
		System.out.println(MIN);
	}

	private static void comb(int idx,int now) {
		if(idx==N)return;
		if(now==N/2) {
			//정산
			int a=0;
			int b=0;
			for(int i=0;i<N;i++) {
				if(team[i]) {
					for(int j=0;j<N;j++) {
						if(team[j]) {
							a += map[i][j];
						}
					}
					
				}else {
					for(int j=0;j<N;j++) {
						if(!team[j]) {
							b += map[i][j];
						}
					}
				}
			}
			
			MIN = Math.min(MIN, Math.abs(a-b));
			return;
		}
		
			//뽑고
			team[idx]=true;
			comb(idx+1,now+1);
			//안뽑고
			team[idx]=false;
			comb(idx+1,now);
		
	}

}
