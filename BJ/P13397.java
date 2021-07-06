import java.io.*;
import java.util.*;

public class P13397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0; 
		int right = 10000;
		int ans =Integer.MAX_VALUE;
		while(left<=right) {
			int mid = (left+right)/2;
			//구간의점수(최댓값 - 최소값) 의 최소값 mid  == 즉 mid 보다 크면 안됨  
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int cnt=0;
			int maxGap = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);

				if(max-min>mid) {
					min = arr[i];
					max = arr[i];
					cnt++;
				}
				
				if(max-min>maxGap) {
					maxGap = max-min;
				}
				
				if(i==N-1)cnt++;
			}
			
			
			if(cnt<=M) {
				right = mid-1;
				if(ans>maxGap) {
					ans = maxGap;
				}
			}else if(cnt>M) {
				left = mid+1;
			}
		}
		
		System.out.println(ans);
		
		
	}

}
