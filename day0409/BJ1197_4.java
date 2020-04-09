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
 * 
 * 크루스칼
 *
 */
public class BJ1197_4 {
	static int V, E;
	static int[] parents;
	static int[] rank;
	static PriorityQueue<Node> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		rank = new int[V+1];
		queue = new PriorityQueue<>();
		
		int E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			queue.add(new Node(x, y, z));
		}
		
		for(int i=1;i<=V;i++) {
			parents[i]=i;
		}
		
		int cnt =0;
		int result =0;
		while(cnt != V-1) {
			Node temp = queue.poll();
			int p1 = findParent(temp.x);
			int p2 = findParent(temp.y);
			if(p1==p2)continue;
			cnt++;
			result += temp.w;
			union(p1, p2);
		}
		
		System.out.println(result);
		
	}
	
	public static int findParent(int x) {
		if(x==parents[x])return x;
		parents[x]=findParent(parents[x]);
		return parents[x];
	}
	
	public static void union(int n1,int n2) {
		int x = findParent(n1);
		int y = findParent(n2);
		if(rank[x]>rank[y]) {
			parents[y]=x;
		}else {
			parents[x]=y;
			if(rank[x]==rank[y])rank[y]++;
		}
	}
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		
		public Node(int x,int y,int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}
	}

}
