import java.io.*;
import java.util.*;

public class P1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S =Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		
		int left =0;
		int right=0;
		int sum=arr[left];
		int answer = Integer.MAX_VALUE;
		while(true) {
			if(sum>=S) {
				answer =Math.min(answer, right-left+1);
				sum-=arr[left];
				left++;
			}
			else if(sum<S) {
				right++;
				if(right==N)break;
				sum+=arr[right];
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

	}

}
