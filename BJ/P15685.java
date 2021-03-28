import java.io.*;
import java.util.*;

public class P15685 {
	public static int[][] map;
	public static int[] dr = {0,-1,0,1};
	public static int[] dc = {-1,0,1,0};
	public static int color;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		map = new int[101][101];
		
		color = 1;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken()); //x 좌표
			int y= Integer.parseInt(st.nextToken()); //y 좌표
			int d= Integer.parseInt(st.nextToken()); //시작방향  0,1,2,3
			int g= Integer.parseInt(st.nextToken());  // 0<= 세대 <= 10   
 			
			List<int []> route = new ArrayList<int[]>();
			route.add(new int[] {y,x});
			map[y][x]=color++;
			switch (d) {
			case 0:  //우측
				route.add(new int[] {y,x+1});
				map[y][x+1]=color++;
				break;
			case 1:  //상
				route.add(new int[] {y-1,x});
				map[y-1][x]=color++;
				break;
			case 2:  //좌측
				route.add(new int[] {y,x-1});
				map[y][x-1]=color++;
				break;
			case 3:  //하
				route.add(new int[] {y+1,x});
				map[y+1][x]=color++;
				break;
			}
			
			//그리기 작업
			if(g>0) {
				draw(1,g,route);
			}
		}
		
		
		//정사각형 개수 세는 작업
		int cnt = 0;
		for(int i=0;i<101-1;i++) {
			for(int j=0;j<101-1;j++) {
				if(map[i][j]!=0&&map[i+1][j]!=0&&map[i][j+1]!=0&&map[i+1][j+1]!=0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}
	
	private static int where (int[] prev, int[] next) {
		if(prev[0]-next[0]==-1) {
			return 3;
		}else if(prev[0]-next[0]==1) {
			return 1;
		}else if(prev[1]-next[1]==1) {
			return 0;
		}else {
			return 2;
		}
	}


	private static void draw(int gener,int finsh, List<int[]> route) {
		if(gener==finsh+1) {
			return;
		}
		int[] start = Arrays.copyOf(route.get(route.size()-1), 2);
		int tmp = route.size()-2;
		for(int i=tmp;i>=0;i--) {
			int dir = where(route.get(i+1),route.get(i));
			start[0]=start[0]+dr[(dir+1)%4];
			start[1]=start[1]+dc[(dir+1)%4];
			map[start[0]][start[1]]=color++;
			route.add(new int[] {start[0],start[1]});
		}
		
		
		draw(gener+1,finsh,route);
	}

}
