import java.util.*;
import java.io.*;

public class P2580 {
	public static int[][] map;
	public static int[] dr = {0,-1,-1,0,1,1,1,0,-1};
	public static int[] dc = {0,0,1,1,1,0,-1,-1,-1};
	
	public static int[][] dot = {{10,13,16},{37,40,43},{64,67,70}};
	public static List<int []>  blank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		blank = new ArrayList<int[]>();
		map = new int[9][9];
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j]=num;
				if(num==0) {
					blank.add(new int[] {i,j});
				}
				
			}
		}
		
		dfs(0);
		
		

	}
	
	public static boolean dfs(int idx) throws IOException {
		if(idx==blank.size()) {
			//프린트하기
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					bw.write(Integer.toString(map[i][j]));
					if(j!=8) {
						bw.write(" ");
					}
				}
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			return true;
		}
		
		int[] now = blank.get(idx);
		
		for(int i=1;i<=9;i++) {
			boolean flag = false;
			//같은 row 확인
			for(int j=0;j<9;j++) {
				if(map[now[0]][j]==i) {
					flag = true;
					break;
				}
			}
			
			if(flag)continue;
			
			//같은 col 확인
			for(int j=0;j<9;j++) {
				if(map[j][now[1]]==i) {
					flag = true;
					break;
				}
			}
			if(flag)continue;
			
			//같은 dot 확인
			int tmp = dot[now[0]/3][now[1]/3];
			for(int d=0;d<9;d++) {
				int nr =tmp/9+dr[d];
				int nc = tmp%9+dc[d];
				if(map[nr][nc]==i) {
					flag = true;
					break;
				}
			}
			if(flag)continue;
			
			map[now[0]][now[1]]=i;
			if(dfs(idx+1)) {
				return true;
			}
			map[now[0]][now[1]]=0;
			
		}
		return false;
	}

}
