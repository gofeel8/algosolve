package BJ;
import java.io.*;
import java.util.*;

public class P9466 {
    static int[] memo,step;
	public static int[] arr;
    static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			cnt=0;
			
			
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			memo = new int[N+1];
			step = new int[N+1];
			int s =1;
			for(int i=1;i<=N;i++) {
				if(step[i]==0) {
					int num = dfs(i,1,s++);
					cnt+=num;
				}
			}
			System.out.println(cnt);
		}

	}

	static int dfs(int now,int size,int st) { 
 
        memo[now]=size;
        step[now]=st;

        int next = arr[now];
        
        if(step[next]==st) {
        	return memo[next]-1;
        }else if(step[next]==0) {
        	return dfs(next,size+1,st);
        }else {
        	return size;
        }
        
        
    }

}
