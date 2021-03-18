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
		for(int i=0;i<N-1;i++) {
			
			int left=i+1;
			int right=N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				
				if((arr[mid]-arr[i])<M) {
					left=mid+1;
				}else if((arr[mid]-arr[i])>M) {
					right=mid-1;
					result=Math.min(result, arr[mid]-arr[i]);
				}else {
					System.out.println(M);
					return;
				}
			}
		}
		System.out.println(result);
		
	}

}
