import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P20542 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		String answer = br.readLine();
		
		//v -> v,w
		// i -> i,j,l
		
		int[][] memo = new int[M+1][N+1];
		for(int i=1;i<=N;i++) {
			memo[0][i]=i;
		}
		
		for(int i=1;i<=M;i++) {
			memo[i][0]=i;
		}
		
		
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=N;j++) {
				char now = str.charAt(j-1);
				char ans = answer.charAt(i-1);
				if(now==ans) {
					memo[i][j]=memo[i-1][j-1];
				}else if(now == 'v' && ans =='w') {
					memo[i][j]=memo[i-1][j-1];					
				}else if(now =='i' && (ans=='j' || ans=='l')) {
					memo[i][j]=memo[i-1][j-1];
				}else {
					int min;
					min = Math.min(memo[i-1][j-1], memo[i-1][j]);
					min = Math.min(min, memo[i][j-1]);
					memo[i][j]=min+1;
				}
			}
		}
		
		System.out.println(memo[M][N]);
		
		
		
		
	}

}
