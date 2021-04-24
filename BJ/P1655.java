import java.io.*;
import java.util.*;

public class P1655 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> rpq = new PriorityQueue<>();
		PriorityQueue<Integer> lpq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<N;i++) {
			int wantSize = i/2;
			int now = Integer.parseInt(br.readLine());
			
			if(rpq.size()!=0 && now<=rpq.peek()) {
				lpq.add(now);
			}else {
				rpq.add(now);
			}
			
			
			if(lpq.size()>wantSize) {
				while(lpq.size()!=wantSize) {
					rpq.add(lpq.poll());
				}
			}else if(lpq.size()<wantSize) {
				while(lpq.size()!=wantSize) {
					lpq.add(rpq.poll());
				}
			}
			bw.write(String.valueOf(rpq.peek()));
			bw.newLine();
			
		 
		}
		bw.flush();
		bw.close();

	}

}
