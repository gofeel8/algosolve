import java.util.*;
import java.io.*;

public class P17779 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		
		int[][] map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0;r<N-2;r++) {
			for(int c=1;c<N-1;c++) {
				for(int d1=1;c-d1>=0;d1++) {
					for(int d2=1;c+d2<=N;d2++) {
						if(r+d1+d2>N)break;
						//인구수 카운팅
						int[] cnt = new int[6];
						for(int i=0;i<N;i++) {
							for(int j=0;j<N;j++) {
								if(isFive(i,j,r,c,d1,d2)) {
									cnt[5]+=map[i][j];
								}
								else {
									int tmp = number(i,j,r,c,d1,d2);
									cnt[tmp]+=map[i][j];
								}
							}
						}
						
						Arrays.sort(cnt);
						if(cnt[5]-cnt[1]<answer) {
							answer = cnt[5]-cnt[1];
						}
					}
				}
			}
		}
		System.out.println(answer);

	}

	private static int number(int nr, int nc, int sr, int sc,int d1, int d2) {
		if(nr<sr+d1 && nc <= sc) {
			return 1;
		}
		if(nr<=sr+d2 && sc<nc) {
			return 2;
		}
		if(nc<sc-d1+d2) {
			return 3;
		}
		return 4;
	}

	private static boolean isFive(int nr, int nc, int sr, int sc,int d1, int d2) {
		if(nr<sr)return false;
		if(nr>sr+d1+d2)return false;
		if(nc<sc-d1)return false;
		if(nc>sc+d2)return false;
		
		int gap = nr-sr;
		int leftLimit;
		if(gap>d1) {
			leftLimit = (sc-d1)+(gap-d1);
		}else {
			leftLimit = sc-gap;
		}
		
		int rightLimit;
		if(gap>d2) {
			rightLimit = (sc+d2)-(gap-d2);
		}else {
			rightLimit = sc+gap;
		}
		if(leftLimit<=nc && nc<=rightLimit) {
			return true;
		}
		
		return false;
	}

}
