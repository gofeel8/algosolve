import java.io.*;
import java.util.*;
public class P2571 {
	public static int MAX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		MAX = 0;
		int[][] sum = new int[102][102];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int  col  = Integer.parseInt(st.nextToken());
			int  row  = 100-Integer.parseInt(st.nextToken());
			
			for(int j=0;j<10;j++) {
				if(sum[row][col+j]==1)continue;
				else if(sum[row+1][col+j]==0) {
					int idx =1;
					for(int k=0;k<10;k++) {
						sum[row-k][col+j]=idx;
						idx++;
					}
					int tmp = 10;
					while(sum[row-tmp][col+j]!=0) {
						sum[row-tmp][col+j]=idx;
						idx++;
						tmp++;
					}
				}else { // 도중에 낌
					int idx = sum[row+1][col+j]+1;
					for(int k=0;k<10;k++) {
						sum[row-k][col+j]=idx;
						idx++;
					}
					
					int tmp = 10;
					while(sum[row-tmp][col+j]!=0) {
						sum[row-tmp][col+j]=idx;
						idx++;
						tmp++;
					}
					
				}
			}
		}
		
//		for(int i=0;i<sum.length;i++) {
//			System.out.println(Arrays.toString(sum[i]));
//		}
		
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				int num = sum[i][j];
				if(num ==0)continue;
				if(num>MAX)MAX =num;
			
				for(int k=1;k<101;k++) {
					if(j+k>100)break;
					if(sum[i][j+k]==0)break;
					if(sum[i][j+k]>=num) {
						int tmp = num*(k+1);
						if(tmp>MAX)MAX=tmp;
					}else if(sum[i][j+k]<num) {
						num =sum[i][j+k];
						int tmp = num*(k+1);
						if(tmp>MAX)MAX=tmp;
					}
				}
				
			}
		}
		System.out.println(MAX);

	}

}
