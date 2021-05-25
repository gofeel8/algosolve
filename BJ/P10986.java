import java.io.*;
import java.util.*;
public class P10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] cnt = new int[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i>0) {
				arr[i]+=arr[i-1];
			}
			arr[i] %=M;
			
			cnt[arr[i]]++;
		}
		
		long ans = cnt[0];
		for(int i=0;i<M;i++) {
			ans += (long)(cnt[i]-1)*cnt[i]/2;
		}
		System.out.println(ans);
		
		

	}

}
