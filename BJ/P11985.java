import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11985 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long[] price = new long[N+1];
		Arrays.fill(price, Long.MAX_VALUE);
		price[0]=0;
		for(int i=1;i<=N;i++) {
			int big = arr[i];
			int small = arr[i];
			for(int j = 0; j<M;j++) {
				if(i-j==0)break;
				if(big<arr[i-j])big = arr[i-j];
				if(small>arr[i-j])small = arr[i-j];
				long nowprice =(K +(long)(j+1)*(big-small))+price[i-j-1];
				price[i] = Math.min(price[i], nowprice);
			}
		}
		System.out.println(price[N]);
		
		

	}

}
