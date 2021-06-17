import java.util.*;
import java.io.*;

public class P2467 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		
		int min = Integer.MAX_VALUE;
		int a =0;
		int b =0;
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(sum ==0) {
				System.out.println(arr[left]+" "+arr[right]);
				return;
			}else if(sum < 0) {
				if(Math.abs(sum)<min) {
					min = Math.abs(sum);
					a =left;
					b = right;
				}
				left++;
			}else if(sum>0) {
				if(sum<min) {
					min = sum;
					a =left;
					b = right;
				}
				right--;
			}
		}
		System.out.println(arr[a]+" "+arr[b]);
	}

}
