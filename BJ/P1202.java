import java.io.*;
import java.util.*;

public class P1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			pq.add(new Node(M, V));
			
		}

		int [] bag = new int[K];

		for(int i=0;i<K;i++) {
			bag[i]= Integer.parseInt(br.readLine());
		}

		Arrays.sort(bag);
		long answer = 0;
		
		
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<K;i++) {
			int can = bag[i];
			while(!pq.isEmpty()&& pq.peek().weigh<=can) {
				max.add(pq.poll().value);
			}
			
			if(!max.isEmpty()) {
				answer += max.poll();
			}
			
		}
		
		
		System.out.println(answer);

		
	}

	public static class Node implements Comparable<Node>{
		int weigh;
		int value;
		Node(int w, int v){
			weigh = w;
			value = v;
		}
		
		@Override
		public int compareTo(Node o) {
			return weigh- o.weigh;
		}
		
	}
}
