import java.io.*;
import java.util.*;

public class P11444 {
	public static final int mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N   = Long.parseLong(br.readLine());
		
		if(N==1) {
			System.out.println(1);
		}else {
			long[][] arr = {{1,1},{1,0}};
			long[][] ans = matrix(N-1, arr);
			System.out.println(ans[0][0]);
		}
		

	}
	
	private static long[][] matrix(long b, long[][] arr) {
		long[][] rt = new long[arr.length][arr.length];
		if(b==1) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					rt[i][j]=arr[i][j]%mod;
				}
			}
			return rt;
		}

		long[][] tmp  = matrix(b/2, arr);


		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp.length;j++) {
				for(int k=0;k<tmp.length;k++) {
					rt[i][j] += (tmp[i][k]*tmp[k][j])%mod;
					rt[i][j] %= mod;
				}
			}
		}


		if(b%2==1) {
			long[][] cp = new long[rt.length][rt.length];
			for(int i=0;i<tmp.length;i++) {
				for(int j=0;j<tmp.length;j++) {
					for(int k=0;k<tmp.length;k++) {
						cp[i][j] += (rt[i][k]*arr[k][j])%mod;
						cp[i][j] %= mod;
					}
				}
			}	
			return cp;
		}

		return rt;


	}

}
