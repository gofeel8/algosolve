package BJ;
import java.io.*;
import java.util.*;

public class P9466 {
    static boolean[] visited;
    static boolean[] finished;
	public static int[] arr;
    static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			visited =new boolean[N+1];
            finished = new boolean[N+1];
			arr = new int[N+1];
			count=0;
			
			
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				if(visited[i]==false) {
					dfs(i);
				}
			}
			System.out.println(N-count);
		}

	}

	static void dfs(int now) { 
        if(visited[now])
            return;
 
        visited[now] = true;
        int next = arr[now];
 
        if(visited[next] != true)
            dfs(next);
        else {
            if(finished[next] != true) {
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }
 
        finished[now] = true;
    }

}
