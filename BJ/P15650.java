import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * а╤гу
 *
 */
public class P15650 {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		comb(1,N,0,M);
		
	}
	
	public static void comb(int first,int last,int now,int end) {
		if(now ==end) {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");

			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());

			return;
		}
		
		for(int i=first;i<=last;i++) {
			arr[now]=i;
			comb(i+1,last,now+1,end);
		}
	}

}
