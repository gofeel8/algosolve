import java.io.*;
import java.util.*;

public class P6236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		long sum = 0;
		long max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
			sum += arr[i];
			if(arr[i]>max)max = arr[i];
		}
		
		long left = max;
		long right = sum;
		long answer = 0;
		while(left<=right) {
			long mid = (left+right)/2;
			
			//mid 로 생활 가능?
			long cash = mid;
			int cnt = 1;
			for(int i=0;i<arr.length;i++) {
				if(cash>=arr[i]) {
					cash-=arr[i];
				}else {
					cash = mid;
					cnt ++;
					cash-=arr[i];
				}
			}
			if(cnt>M) {
				//생활불가
				//돈 더 꺼내야함
				left = mid+1;
			}else {
				answer = mid;
				//생활 가능 , 돈좀 줄여볼까
				right = mid-1;
			}
		}
		System.out.println(answer);

	}

}
