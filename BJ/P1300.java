import java.io.*;
import java.util.*;

public class P1300 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = K;
		
		int ans = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			//mid 보다 같거나 낮은 수의 개수
			int cnt=0;
			for(int i=1;i<=N;i++) {
				long tmp=0;
				tmp = Math.min(mid/i, N);
				cnt+=tmp;
			}
			if(cnt<K) {
				left = mid +1;
			}else {
				right =mid -1;
				ans = mid;
			}
		}
		System.out.println(ans);
		
		
	}

}
