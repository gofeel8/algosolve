import java.io.*;
import java.util.*;

public class P3967 {
	public static int [][] arr =  new int[13][2];
	public static boolean[] used,fixed;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr[1]= new int[] {0,4};
		arr[2]= new int[] {1,1};
		arr[3]= new int[] {1,3};
		arr[4]= new int[] {1,5};
		arr[5]= new int[] {1,7};
		arr[6]= new int[] {2,2};
		arr[7]= new int[] {2,6};
		arr[8]= new int[] {3,1};
		arr[9]= new int[] {3,3};
		arr[10]= new int[] {3,5};
		arr[11]= new int[] {3,7};
		arr[12]= new int[] {4,4};
		
		
		
		map = new int[5][9];
		String str;
		
		used = new boolean[13];
		fixed = new boolean[13];
		
		int cnt =0;
		for(int i=0;i<5;i++) {
			str = br.readLine();
			for(int j=0;j<9;j++) {
				char tmp = str.charAt(j);
				if(tmp>='A' && tmp<='L' ) {
					cnt++;
					map[i][j]=tmp-'A'+1;
					used[tmp-'A'+1]=true;
					fixed[cnt]=true;
				}else if(tmp=='x'){
					map[i][j]=99;
					cnt++;
				}
			}
		}
		
		dfs(1);
		
		
		

	}

	private static boolean dfs(int idx) {
		if(idx==6) {
			//2,3,4,5
			int sum=map[arr[2][0]][arr[2][1]]+map[arr[3][0]][arr[3][1]]+map[arr[4][0]][arr[4][1]]+map[arr[5][0]][arr[5][1]];
			if(sum!=26)	return false;
		}
		else if(idx ==9) {
			//1,3,6,8
			int sum=map[arr[1][0]][arr[1][1]]+map[arr[3][0]][arr[3][1]]+map[arr[6][0]][arr[6][1]]+map[arr[8][0]][arr[8][1]];
			if(sum!=26)	return false;
		}
		else if(idx==12) {
			//8 9 10 11
			int sum=map[arr[8][0]][arr[8][1]]+map[arr[9][0]][arr[9][1]]+map[arr[10][0]][arr[10][1]]+map[arr[11][0]][arr[11][1]];
			if(sum!=26)	return false;

			//1 4 7 11
			sum=map[arr[1][0]][arr[1][1]]+map[arr[4][0]][arr[4][1]]+map[arr[7][0]][arr[7][1]]+map[arr[11][0]][arr[11][1]];
			if(sum!=26)	return false;

		}
		else if(idx==13) {  //정답 출력
			//2 6 9 12
			int sum=map[arr[2][0]][arr[2][1]]+map[arr[6][0]][arr[6][1]]+map[arr[9][0]][arr[9][1]]+map[arr[12][0]][arr[12][1]];
			if(sum!=26)	return false;
			//5 7 10 12
			sum=map[arr[5][0]][arr[5][1]]+map[arr[7][0]][arr[7][1]]+map[arr[10][0]][arr[10][1]]+map[arr[12][0]][arr[12][1]];
			if(sum!=26)	return false;

			for(int i=0;i<5;i++) {
				for(int j=0;j<9;j++) {
					if(map[i][j]==0) {
						System.out.print('.');

					}else {
						System.out.print((char)('A'+map[i][j]-1));
					}
				}
				System.out.println();
			}
			
			return true;
		}
		
		
		if(fixed[idx]==true) {
			return dfs(idx+1);
		}
		
		for(int i=1;i<=12;i++) {
			if(used[i]==false) {
				used[i]=true;
				//현재 idx 자리에 i 넣어주기
				int[] pos = arr[idx];
				map[pos[0]][pos[1]]=i;
				if(dfs(idx+1))return true;
				used[i]=false;
			}
		}
		return false;
		
	}

}
