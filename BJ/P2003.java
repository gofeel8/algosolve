import java.util.*;
import java.io.*;

public class P2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int result = 0;
		int sum = 0;
		
		while(right<N) {
			sum += arr[right];
			
			if(sum==M) {
				result++;
				sum -=arr[left];
				left++;
				right++;
			}else if(sum >M) {
				sum -=arr[left];
				left++;
				sum -=arr[right];
			}else if(sum <M) {
				right++;
			}
		}
		
		System.out.println(result);

	}

}
