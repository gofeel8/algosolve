import java.io.*;
import java.util.*;

public class P1306 {

	public static void main(String[] args)  throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		
		int[] arr = new int [N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dq.add(arr[1]);
		for(int i=2;i<=2*M-1;i++) {
			if(i>N)break;
			int now = arr[i];
			while(!dq.isEmpty() && dq.peekLast()<now) {
				dq.pollLast();
			}
			dq.addLast(now);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = M ; i<=N-M+1;i++) {
			bw.append(String.valueOf(dq.peekFirst())+" ");
			
			if(i==N-M+1)break;
			int removeNum = arr[i-M+1];
			
			if(dq.peekFirst()== removeNum) {
				dq.pollFirst();
			}
			if(i+M>N) break;
			int addNum= arr[i+M];
			while(!dq.isEmpty() && dq.peekLast()<addNum) {
				dq.pollLast();
			}
			dq.addLast(addNum);
		}
		
		bw.flush();
		bw.close();

	}

}
