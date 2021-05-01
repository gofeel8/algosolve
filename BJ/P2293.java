import java.util.*;
import java.io.*;

public class P2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k+1];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] memo = new int[k+1];
		for(int i=1;i<=k;i++) {
			if(i%arr[0]==0) {
				memo[i]=1;
			}
		}
		
		
		for(int i=1;i<n;i++) {
			memo[0] = 1;
			for(int j=1;j<=k;j++) {
				if(j-arr[i]<0)continue;
				memo[j] = memo[j]+memo[j-arr[i]];
			}
		}
		
		System.out.println(memo[k]);

	}

}
