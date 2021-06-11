import java.io.*;
import java.util.*;

public class P13398 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr  =  new int[N];
		StringTokenizer  st  = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i =0;i<N;i++) {
			int sum = arr[i]; 
			if(sum>max)max = sum;
			for(int j=i+1;j<N;j++) {
				sum+=arr[j];
				if(sum<=arr[j]) {
					i=j-1;
					break;
				}else {
					if(sum>max)max = sum;
				}
			}
		}
		System.out.println(max);

	}

}
