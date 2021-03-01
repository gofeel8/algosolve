import java.io.*;
import java.util.*;

public class P15683 {
	public static int[][] map;
	public static List<int []> cctv;
	public static int N;
	public static int M;
	public static int RESULT;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<int[]>();
		boolean[][] visible = new boolean[N][M];
		RESULT = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num > 0 && num < 6) {
					cctv.add(new int[] {i,j});
					visible[i][j]=true;
				}
				if(num == 6) {
					visible[i][j]=true;
				}
			}
		}
		
		dfs(0,visible);
		
		System.out.println(RESULT);
		
		
		
	}
	private static void dfs(int idx , boolean[][] visible) {
		if(idx == cctv.size()) {
			//카운트해주기
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visible[i][j]==false)cnt++;
				}
			}
			//기록 갱신 해주기
			if(RESULT>cnt) {
				RESULT=cnt;
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++) {
//						if(visible[i][j]) {
//							System.out.print('o');
//						}else {
//							System.out.print('x');
//						}
//					}
//					System.out.println();
//				}
			}
			return;
		}
		
		int[] now =  cctv.get(idx);
		int model = map[now[0]][now[1]];
		boolean[][] copy = new boolean[N][M];
		
		
		switch (model) {
		case 1:
			//상
			copy = copy(visible);
			up(now[0],now[1],copy);
			dfs(idx+1,copy);
			//하
			copy = copy(visible);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			//좌
			copy = copy(visible);
			left(now[0],now[1],copy);
			dfs(idx+1,copy);
			//우
			copy = copy(visible);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			break;
		case 2:
			//상하
			copy = copy(visible);
			up(now[0],now[1],copy);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			//좌우
			copy = copy(visible);
			left(now[0],now[1],copy);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			break;
		case 3:
			//상우
			copy = copy(visible);
			up(now[0],now[1],copy);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			//우하
			copy = copy(visible);
			right(now[0],now[1],copy);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			//하좌
			copy = copy(visible);
			left(now[0],now[1],copy);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			//좌상
			copy = copy(visible);
			up(now[0],now[1],copy);
			left(now[0],now[1],copy);
			dfs(idx+1,copy);
			break;
		case 4:
			//좌상우
			copy = copy(visible);
			up(now[0],now[1],copy);
			left(now[0],now[1],copy);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			
			//상우하
			copy = copy(visible);
			up(now[0],now[1],copy);
			down(now[0],now[1],copy);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			//우하좌
			copy = copy(visible);
			down(now[0],now[1],copy);
			left(now[0],now[1],copy);
			right(now[0],now[1],copy);
			dfs(idx+1,copy);
			//하좌상
			copy = copy(visible);
			up(now[0],now[1],copy);
			left(now[0],now[1],copy);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			break;
		case 5:
			//상하좌우
			copy = copy(visible);
			up(now[0],now[1],copy);
			left(now[0],now[1],copy);
			right(now[0],now[1],copy);
			down(now[0],now[1],copy);
			dfs(idx+1,copy);
			break;
		default:
			break;
		}
	
	}
	
	public static boolean[][] copy (boolean[][] visible){
		
		boolean[][] rt = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			rt[i]=Arrays.copyOf(visible[i], visible[i].length);
		}
		return rt;
	}
	
	public static void up(int row,int col,boolean[][] visible) {
		for(int i=row;i>=0;i--) {
			if(map[i][col]==6) {
				break;
			}
			visible[i][col]=true;
		}
		
	}
	public static void down(int row,int col,boolean[][] visible) {
		for(int i=row;i<N;i++) {
			if(map[i][col]==6) {
				break;
			}
			visible[i][col]=true;
		}
	}
	public static void left(int row,int col,boolean[][] visible) {
		for(int i=col;i>=0;i--) {
			if(map[row][i]==6) {
				break;
			}
			visible[row][i]=true;
		}
	}
	public static void right(int row,int col,boolean[][] visible) {
		for(int i=col;i<M;i++) {
			if(map[row][i]==6) {
				break;
			}
			visible[row][i]=true;
		}
	}
	

}
