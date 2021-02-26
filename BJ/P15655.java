import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P15655 {

	static int[] arr;
	static int N;
	static int[] input;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		comb(0,0,M);
		
	}
	
	public static void comb(int first,int now,int end) {
		if(now ==end) {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");

			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());

			return;
		}
		
		for(int i=first;i<input.length;i++) {
			arr[now]=input[i];
			comb(i+1,now+1,end);
		}
	}

}
