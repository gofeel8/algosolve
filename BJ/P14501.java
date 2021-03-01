import java.util.*;
import java.io.*;

public class P14501 {
	public static int N;
	public static int[][] arr;
	public static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		result = 0;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0]=a;
			arr[i][1]=b;
		}
		
		
		for(int i=1;i<=N;i++) {
			search(i,arr[i][1]);
		}
		
		System.out.println(result);
		
		
		
		
	}
	private static void search(int day, int sum) {
		if(day+arr[day][0]>N+1)return;
		if(sum>result)result=sum;
		
		int nextday = day + arr[day][0];
		for(int i=nextday;i<=N;i++) {

			
			search(i, sum+arr[i][1]);
		}
	}

}
