import java.io.*;
import java.util.*;

public class P2437 {
	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st  =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(arr[0] != 1) {
			System.out.println(1);
			return;
		}
		
		int sum=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>sum+1) {
				System.out.println(sum+1);
				return;
			}
			sum+=arr[i];
		}
		System.out.println(sum+1);

	}

}
