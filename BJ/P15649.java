import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * 
 * ¼ø¿­
 *
 */
public class P15649 {
	
	static boolean[] used;
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		used = new boolean[N+1];
		arr = new int[M];
		
		perm(0,M);
	}
	
	public static void perm(int now,int end) {
		if(now==end) {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(used[i]==false) {
				used[i]=true;
				arr[now]=i;
				perm(now+1,end);
				used[i]=false;
			}
		}
		
	}

}
