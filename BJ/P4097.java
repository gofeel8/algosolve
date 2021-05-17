import java.io.*;
import java.util.*;
public class P4097 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)break;
			
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			long sum =0;
			long max =Long.MIN_VALUE;
//			int left =0;
//			int right = 0;
			for(int i=0;i<N;i++) {
				sum+=arr[i];
				if(sum>max)max = sum;
				if(sum<=0) {
					sum = 0;
				}
			}
			
			System.out.println(max);
		}

	}

}
