import java.util.*;
import java.io.*;
public class P15684 {
	public static int N;
	public static int M;
	public static int H;
	
	public static void main(String[] args ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		boolean[][] bridge = new boolean[H][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			bridge[a][b]=true;
		}
		
		for(int i=0;i<4;i++) {
			if(comb(0,0,i,bridge)) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
		return;
		
		
		
		
		
		}

	private static boolean comb(int now, int idx,int total, boolean[][] bridge) {
		if(idx == total) {
			if(check(bridge)) {
				return true;
			}else {
				return false;
			}
		}
		
		
		for(int i=now;i<N*H;i++) {
			int r = i/N;
			int c = i%N;
			if(bridge[r][c])continue;
			else {
				bridge[r][c]=true;
				if(comb(i+1,idx+1,total,bridge)) {
					return true;
				}
				bridge[r][c]=false;
			}
		}
		
		
		
		return false;
	}

	private static boolean check(boolean[][] bridge) {
		
		for(int i=0;i<=N;i++) {
			int r=0;
			int c=i;
			for(int j=0;j<H;j++) {
				//왼쪽 체크
				if(c-1>=0&&bridge[r][c-1]==true) {
					c--;
				}
				//오른쪽체크
				else if(c<N&&bridge[r][c]==true) {
					c++;
				}
				
				r++;
			}
			
			if(c!=i)return false;
		}
		
		return true;
	}

}
