import java.util.*;
import java.io.*;

public class P11403 {

	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[] checked;
	static int N;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map  = new int[N][N];
		result = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		//�÷��̵�ͼ�
//		for(int i=0;i<N;i++) { //��ġ����
//			for(int j=0;j<N;j++) {  //������
//				for(int k=0;k<N;k++) {  //����
//					if(map[j][k]==1)continue;  //�̹� ���� �����Ƿ�
//					if(map[j][i]==1 && map[i][k]==1)map[j][k]=1;
//				}
//			}
//		}
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		
		//dfs �������� �ٽ� Ǯ��� 
		for(int i=0;i<N;i++) {
			checked = new boolean[N];
			dfs(i,i);
		}
		
		for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			System.out.print(result[i][j]+" ");
		}
		System.out.println();
	}
	
			

	}

	private static void dfs(int now,int start) {
		
		for(int i=0;i<N;i++) {
			if(map[now][i]==1&&checked[i]==false) {
				result[start][i]=1;
				checked[i]=true;
				dfs(i,start);
			}
		}
	}

}
