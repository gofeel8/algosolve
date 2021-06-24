import java.io.*;
import java.util.*;

public class P13702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		
		long left = 0;
		long right = max;
		long ans =0;
		while(left<=right) {
			long mid = (left+right)/2;
			if(mid==0) {
				left=mid+1;
				continue;
			}
			long cnt=0;
			for(int i=0;i<N;i++) {
				cnt+=arr[i]/mid;
			}
			if(cnt>=K) {
				ans=mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(ans);
		
	}

}
