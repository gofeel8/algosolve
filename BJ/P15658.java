import java.util.*;
import java.io.*;
public class P15658 {

	public static int min,max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr   =  new int [N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] cmd = new int[4];
		for(int i=0;i<4;i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		search(arr,0,cmd[0],cmd[1],cmd[2],cmd[3],arr[0]);
		System.out.println(max);
		System.out.println(min);

	}

	private static void search(int[] arr, int idx, int plus, int minus, int mul, int div, int sum) {
		if(idx+1==arr.length) {
			if(sum>max)max = sum;
			if(sum<min)min = sum;
			
			return;
		}
		
		//더해보자
		if(plus>0) {
			search(arr, idx+1, plus-1, minus, mul, div, sum+arr[idx+1]);
		}
		//빼보자
		if(minus>0) {
			search(arr, idx+1, plus, minus-1, mul, div, sum-arr[idx+1]);
		}
		//곱해보자
		if(mul>0) {
			search(arr, idx+1, plus, minus, mul-1, div, sum*arr[idx+1]);
		}
		//나눠보자
		if(div>0) {
			search(arr, idx+1, plus, minus, mul, div-1, sum/arr[idx+1]);
		}
	}

}
