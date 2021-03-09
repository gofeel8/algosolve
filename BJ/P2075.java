import java.util.*;
import java.io.*;

public class P2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				queue.add(Integer.parseInt(st.nextToken()));
				if(queue.size()>N) {
					queue.poll(); 
				}
			}
		}

		System.out.println(queue.poll());
		
		

	}

}
