import java.io.*;
import java.util.*;


public class P14225 {
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int size = (int)Math.pow(2, N);
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=1;i<size;i++) {
			int sum = 0;
			for(int j=0;j<N;j++) {
				if((i & (1<<j)) != 0 ) {
					sum+=arr[j];
				}
			}
			set.add(sum);
		}
		int num =1;
		while(true) {
			if(!set.contains(num)) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}



}
