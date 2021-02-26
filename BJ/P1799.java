import java.util.*;
import java.io.*;

public class P1799 {
	static int N;
	static int[] dr = {-1,+1,+1,-1};
	static int[] dc = {+1,+1,-1,-1};
	static boolean[][] color;        //true 컬러 false 컬러
	static boolean[][] map;
	static boolean[] Lcheck;   //    
	static boolean[] Rcheck;   //    
	static List<int[]>list;
	static int LMAX,RMAX;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		color = new boolean[N][N]; 
		list = new ArrayList<int[]>();
		LMAX=0;
		RMAX=0;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num ==1) {
					map[i][j]= true;
					list.add(new int[] {i,j});
				}
				
				if(i%2==0) {
					if(j%2==0) {
						color[i][j]=true;
					}
				}else {
					if(j%2==1) {
						color[i][j]=true;
					}
				}
			}
		}
		
		for(int i=0;i<list.size();i++) {
			int[] now = list.get(i);
			boolean nowColor = color[now[0]][now[1]]; 
			Lcheck = new boolean[2*N];
			Rcheck = new boolean[2*N];
			
			Lcheck[now[0]+now[1]] = true;
			Rcheck[now[0]-now[1]+(N-1)]=true;
			put(i+1,nowColor,1);
			
		}
		
		System.out.println(LMAX+RMAX);
		
	}

	private static void put(int idx, boolean nowColor,int cnt) {
		if(nowColor==true) {
			if(cnt>LMAX)LMAX=cnt;
		}else {
			if(cnt>RMAX)RMAX=cnt;
				
		}
		
		for(int i=idx;i<list.size();i++) {
			int[] now = list.get(i);
			if(color[now[0]][now[1]]!=nowColor)continue;

			//왼쪽 대각선도 오른쪽 대각선도 사용중이지 않다면 내가 쓴다
			if(Lcheck[now[0]+now[1]]==false && Rcheck[now[0]-now[1]+(N-1)]==false) {
				Lcheck[now[0]+now[1]] = true;
				Rcheck[now[0]-now[1]+(N-1)]=true;
				put(i+1,nowColor,cnt+1);
				Lcheck[now[0]+now[1]] = false;
				Rcheck[now[0]-now[1]+(N-1)]=false;
			}
			
		}
		
	}

}