import java.io.*;
import java.util.*;

/**
 * 
 * 중복 조합
 *
 */
public class P15652 {
	
	static int[] arr;
	static int N;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr=new int[M];
		
		comb(1,0,M);
		
		bw.flush();
		bw.close();
	}

	public static void comb(int num,int now,int end) throws IOException {
		if(now==end) {
			for(int i=0;i<arr.length;i++) {
				bw.write(arr[i]+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=num; i<=N;i++) {
			arr[now]=i;
			comb(i,now+1,end);
		}
	}
}
