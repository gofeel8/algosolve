import java.io.*;
import java.util.*;
public class P1987 {
	public static boolean[] used;
	public static int R,C,max;
	public static char[][] map;
	public static int[] dr= {-1,0,1,0};
	public static int[] dc= {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		used = new boolean[26];
		max = -1;                  
		map = new char[R][C];
		String str;
		for(int i=0;i<R;i++) {
			str =br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		used[map[0][0]-'A']=true;
		dfs(0,0,1);
		System.out.println(max);
		
	}


	private static void dfs(int r, int c, int cnt) {
		if(cnt>max)max=cnt;
		
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
			if(used[map[nr][nc]-'A'])continue;
			used[map[nr][nc]-'A']=true;
			dfs(nr,nc,cnt+1);
			used[map[nr][nc]-'A']=false;
		}
		
	}

}
