package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 프림
 * 인접리스트 버전  + priority queue 구현
 *
 */
public class BJ1197_3 {
	static int V, E;
	static List<List<Node>>list;
	static PriorityQueue<Node> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		list = new LinkedList<List<Node>>();
		for(int i=0;i<=V;i++)
			list.add(new LinkedList<Node>());
		
		int E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.get(x).add(new Node(y,z));
			list.get(y).add(new Node(x,z));
		}
		queue = new PriorityQueue<>();
		
		boolean[] check = new boolean[V+1];
		
		queue.add(new Node(1, 0));
		long result =0;
		int cnt = 0;
		while(cnt != V) {
			
			
			Node temp = queue.poll();
			int target = temp.gps;
			
			if(check[target]==true)continue;
			
			check[target] = true;
			result += temp.score;
			cnt++;
			
			for(int j=0;j<list.get(target).size();j++) {
				Node able = list.get(target).get(j);
				queue.add(new Node(able.gps, able.score));
			}
			
			
		}
		
		System.out.println(result);
		
	}
	public static class Node implements Comparable<Node>{
		int gps;
		int score;
		
		Node(int x,int y){
			gps =x;
			score =y;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(score, o.score);
		}
	}

}
