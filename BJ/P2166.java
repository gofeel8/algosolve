import java.io.*;
import java.util.*;

public class P2166 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long[][] arr = new long[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			arr[i][0]=x;
			arr[i][1]=y;
		}
		long sum =0;
		for(int i=1;i<N-1;i++) {
			sum += ccw(arr[0][0],arr[i][0],arr[i+1][0],arr[0][1],arr[i][1],arr[i+1][1]);
		}
		
		sum = Math.abs(sum);
		if(sum%2==0) {
			System.out.println(sum/2+".0");
		}else {
			System.out.println(sum/2+".5");			
		}
		
		
	}
	public static long ccw(long x1,long x2,long x3, long y1, long y2,long y3) {
		return (x1*y2)+(x2*y3)+(x3*y1)-(x2*y1)-(x3*y2)-(x1*y3);
	}
}
