import java.io.*;
import java.util.*;

public class P17951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int right = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right+=arr[i];
		}
		
		int left = 0;
		int ans = 0;

		while(left<=right) {
			int mid = (left+right)/2;
			
			//mid로 가능하냐 
			
			int sum =0;
			int cnt =0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				sum+= arr[i];
				if(sum>=mid) {
					if(min>sum)min = sum;
					cnt++;
					sum=0;
				}
			}
			if(cnt==K) {
				if(ans<min)ans = min;
				left = mid +1;				
			}else if(cnt<K) {
				right = mid-1;
			}else if(cnt>K) {
				left = mid +1;
			}
			
		}
		System.out.println(ans);
	}

}
