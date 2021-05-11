import java.io.*;
import java.util.*;

public class P21312 {
	public static int[] arr =new int[3];
	public static int[] selected =new int[3];
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr =new int[3];
		selected = new int[3];
		arr[0]= Integer.parseInt(st.nextToken());
		arr[1]= Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		
		comb(0,0);
		System.out.println(answer);
	}

	private static void comb(int now, int idx) {
		//정산
		int mul = selected[0];
		for(int i=1;i<idx;i++) {
			mul *= selected[i];
		}
		if((answer % 2 == 1 &&  mul% 2 ==1) || (answer % 2 == 0 &&  mul% 2 ==0) ) {
			answer = Math.max(answer, mul);
		}else if(answer % 2==0 && mul % 2 ==1) {
			answer = mul;
		}
		
		if(idx==3) {
			return;
		}
		
		for(int i=now;i<3;i++) {
			selected[idx]=arr[i];
			comb(i+1,idx+1);
		}
	}

}
