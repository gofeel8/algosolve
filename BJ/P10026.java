import java.util.*;
import java.io.*;
public class P10026 {

	static int N;
	static char[][] map;
	static boolean[][] used;
	
	static int red;
	static int green;
	static int blue;
	static int redgreen;
	

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static boolean[][] blueMap ;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		used = new boolean[N][N];
		blueMap = new boolean[N][N]; 
		
		
		String str;
		
		for(int i=0;i<N;i++) {
			str =br.readLine();
			for(int j=0;j<N;j++)
				map[i][j] = str.charAt(j);
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(used[i][j]==false) {
					bfs(i,j);
				}
			}
		}
	
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(blueMap[i][j]==false) {
					bfs2(i,j);
				}
			}
		}
//		System.out.println(red);
//		System.out.println(green);
//		System.out.println(blue);
		System.out.println((red+green+blue)+" "+(redgreen+blue));
		

	}


	private static void bfs(int row, int col) {
		char now = map[row][col];
		if(now == 'R') {
			red++;
		}else if(now =='G') {
			green++;
		}else {
			blue++;
		}
		
		
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {row,col});
		used[row][col]=true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(map[tmp[0]][tmp[1]]=='B')blueMap[tmp[0]][tmp[1]]=true;
			
			for(int d=0;d<4;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
				if(used[nr][nc]==true)continue;
				
				if(map[nr][nc]==now) {
					queue.add(new int[] {nr,nc});
					used[nr][nc]=true;
				}
			
			}
			
		}
	}
	
	private static void bfs2(int row, int col) {
		redgreen++;
		
		
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {row,col});
		blueMap[row][col]=true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
				if(blueMap[nr][nc]==true)continue;
				
				queue.add(new int[] {nr,nc});
				blueMap[nr][nc]=true;
			
			}
			
		}
	}

}
