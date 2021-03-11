import java.io.*;
import java.util.*;

public class P17406 {
	
	public static boolean[] used;
	public static int[][] command;
	public static int N,M,K;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		int[][] arr = new int[N][M];
		
		used = new boolean[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		command = new int[K][3];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0]=Integer.parseInt(st.nextToken())-1;
			command[i][1]=Integer.parseInt(st.nextToken())-1;
			command[i][2]=Integer.parseInt(st.nextToken());
		}
		
		
		perm(0,arr);
		
		System.out.println(result);
	}

	private static void perm(int idx,int[][] arr) {
		if(idx == K ) {
			
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<M;j++) {
					sum+=arr[i][j];
				}
				result = Math.min(result, sum);
			}
			
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(used[i]==false) {
				used[i]=true;
				int[][] tmp = rotate(i,arr);
				perm(idx+1,tmp);
				used[i]=false;
			}
		}
		
		
	}

	private static int[][] rotate(int i, int[][] arr) {
		int[][] rt = new int[N][M];
		for(int j=0;j<N;j++) {
			rt[j]=Arrays.copyOf(arr[j], M);
		}
		int startRow= command[i][0]-command[i][2];
		int endRow= command[i][0]+command[i][2];
		int startCol= command[i][1]-command[i][2];
		int endCol= command[i][1]+command[i][2];
		
		while(startRow!=endRow) {
			move(rt,startRow,endRow,startCol,endCol);
			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
		
		
		return rt;
	}

	private static void move(int[][] arr, int startRow, int endRow, int startCol, int endCol) {
		int nowRow = startRow;
		int nowCol = startCol;
		
		//오른쪽
		int memo1,memo2;
		memo1=arr[nowRow][nowCol];
		while(nowCol<endCol) {
			memo2=arr[nowRow][nowCol+1];
			arr[nowRow][nowCol+1]=memo1;
			memo1=memo2;
			nowCol++;
		}
		//아래
		while(nowRow<endRow) {
			memo2=arr[nowRow+1][nowCol];
			arr[nowRow+1][nowCol]=memo1;
			memo1=memo2;
			nowRow++;
		}
		
		//왼쪽
		while(nowCol>startCol) {
			memo2=arr[nowRow][nowCol-1];
			arr[nowRow][nowCol-1]=memo1;
			memo1=memo2;
			nowCol--;
		}
		
		
		//위로
		while(nowRow>startRow) {
			memo2=arr[nowRow-1][nowCol];
			arr[nowRow-1][nowCol]=memo1;
			memo1=memo2;
			nowRow--;
		}
		
	}

}
