import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * 중복순열
 * StringBuffer < StringBuilder < BufferedWriter
 * BufferedWriter 가 최고 빠르다
 *
 */
public class P15651 {
//	static StringBuilder sb;
	static BufferedWriter bw;

	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		perm(0,M);
		bw.flush();
		bw.close();
	}
	
	public static void perm(int now,int end) throws IOException {
		if(now==end) {
//			sb = new StringBuilder();
			for(int i=0;i<arr.length;i++) {
//				sb.append(arr[i]+" ");
				bw.write(arr[i]+" ");
			}
//			sb.deleteCharAt(sb.length()-1);
			bw.newLine();
			
//			System.out.println(sb.toString());
			return;
		}
		
		for(int i=1;i<=N;i++) {
				arr[now]=i;
				perm(now+1,end);
		}
		
	}

}
