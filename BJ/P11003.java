package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N  = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		ArrayDeque<int[]> dq =new ArrayDeque<>();

		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.getLast()[1]>now) {
				dq.removeLast();
			}
			
			dq.addLast(new int[] {i,now});
			
			while(dq.getFirst()[0]<=i-L) {
				dq.removeFirst();
			}
			bw.write(dq.getFirst()[1]+" ");
		}
		
		
		bw.flush();
		bw.close();
		
		

	}

}

