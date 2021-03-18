package algo;
import java.io.*;
import java.util.*;

public class P2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int result = Integer.MAX_VALUE;
		int start =0;
		int end=1;
		
		while(end!=N) {
			int gap=arr[end]-arr[start];
			if(gap<M) {
				end++;
			}else if(gap>M) {
				result=Math.min(gap, result);
				start++;
			}else {
				System.out.println(M);
				return;
			}
			if(start==end) {
				end++;
			}
		}
		
		System.out.println(result);
		
	}

}
