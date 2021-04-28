import java.io.*;
import java.util.*;

public class P14476_2 {
	public static int[] arr;
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] left,right;
		left = new int[N];
		right = new int[N];
		
		left[0] = arr[0];
		for(int i=1;i<N;i++) {
			left[i] = GCD(arr[i],left[i-1]);
		}
		
		right[N-1]=arr[N-1];
		for(int i=N-2;i>=0;i--) {
			right[i] = GCD(arr[i],right[i+1]);
		}
		
		int max=-1;
		int maxIdx=-1;
		
		for(int i=0;i<N;i++) {
			int gcd;
			if(i==0) {
				gcd = right[1];
			}else if(i==N-1) {
				gcd = left[N-2];
			}else {
				gcd = GCD(left[i-1],right[i+1]);
			}
			if(arr[i]%gcd==0)continue;
			
			if(gcd>max) {
				max = gcd;
				maxIdx=i;
			}
		}
		if(maxIdx==-1) {
			System.out.println(-1);
		}else {
			System.out.println(max+" "+arr[maxIdx]);
		}
		
	}
	
	public static int GCD(int a,int b) {
		if(b>a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if(a%b==0) {
			return b;
		}
		
		return GCD(b,a%b);
	}

}
