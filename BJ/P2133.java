import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		if(N%2==1) {
			System.out.println(0);
			return;
		}
		dp[0]=1;
		dp[2]=3;
		for(int i=4;i<=N;i=i+2) {
			dp[i]=dp[i-2]*3;
			for(int j=4;j<=i;j=j+2) {
				dp[i]+=dp[i-j]*2;
			}
		}
		System.out.println(dp[N]);
	}

}
