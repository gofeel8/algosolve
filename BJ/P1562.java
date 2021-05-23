import java.util.*;
import java.io.*;
public class P1562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N+1][10][1024];   //자리수 , 끝나는 수 , 사용된 수 
		
		for(int i=1;i<10;i++) {
			dp[1][i][1<<i]=1;
		}
		
		for(int i=2;i<=N;i++) {            // 자리수       
			for(int j=0;j<10;j++) {       //끝나는 수  
				if(j-1>=0) {
					for(int k=0;k<1024;k++) {
						if(dp[i-1][j-1][k] != 0) {
							dp[i][j][(k)|(1<<j)]+=dp[i-1][j-1][k];
							dp[i][j][(k)|(1<<j)] %= 1000000000;
						}
					}
				}
				if(j+1<10) {
					for(int k=0;k<1024;k++) {
						if(dp[i-1][j+1][k] != 0) {
							dp[i][j][(k)|(1<<j)]+=dp[i-1][j+1][k];
							dp[i][j][(k)|(1<<j)] %= 1000000000;
						}
					}
				}
			}
		}
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum+=dp[N][i][1023];
			sum %= 1000000000;
		}
		System.out.println(sum);
		

	}

}
