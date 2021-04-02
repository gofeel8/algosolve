import java.util.*;
import java.io.*;

public class P2239 {
	public static boolean[][] vertical,horizon;
	public static boolean[][][] rectangle;
	public static List<int []>zero;
	public static int[][] map;
	public static boolean find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vertical = new boolean[9][10];
		horizon = new boolean[9][10];
		rectangle = new boolean[3][3][10];
		zero = new ArrayList<int[]>();
		map = new int[9][9];
		
		for(int i=0;i<9;i++) {
			String str =br.readLine();
			for(int j=0;j<9;j++) {
				int num = str.charAt(j)-'0';
				map[i][j]=num;
				if(num ==0) {
					zero.add(new int[] {i,j});
				}else {
					horizon[i][num]=true;
					vertical[j][num]=true;
					rectangle[i/3][j/3][num]=true;
				}
			}
		}
		
		dfs(0,zero.size());
		

	}

	private static void dfs(int idx, int size) throws IOException {
		if(idx==size) {
			//출력
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					bw.write(String.valueOf(map[i][j]));
				}
				bw.newLine();
			}
			bw.flush();
			bw.close();
			//종료
			find=true;
			return;
		}
		
		if(idx==zero.size()) {
			return;
		}
		
		//zero idx 자리에 1~9 까지 조건 확인 후 넣기
		int[] now = zero.get(idx);
		for(int i=1;i<=9;i++) {
			if(horizon[now[0]][i]==false && vertical[now[1]][i]==false && rectangle[now[0]/3][now[1]/3][i]==false ) {
				horizon[now[0]][i]=true;
				vertical[now[1]][i]=true;
				rectangle[now[0]/3][now[1]/3][i]=true;
				map[now[0]][now[1]]=i;
				dfs(idx+1,size);
				if(find)return;
				horizon[now[0]][i]=false;
				vertical[now[1]][i]=false;
				rectangle[now[0]/3][now[1]/3][i]=false;
			}
		}
		
	}

}
