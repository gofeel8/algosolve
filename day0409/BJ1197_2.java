package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 프림
 * 인접리스트 버전
 *
 */
public class BJ1197_2 {
	static int V, E;
	static List<List<Node>>list;

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
		
		int[] key = new int[V+1];
		boolean[] check = new boolean[V+1];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[1] = 0;
		
		
		for(int i=0;i<V-1;i++) {
			
			int index =-1;
			int min = Integer.MAX_VALUE;
			for(int j=1;j<V+1;j++) {
				if(!check[j] && key[j]<min) {
					index = j;
					min = key[j];
				}
			}
			
			check[index] = true;
			
			for(int j=0;j<list.get(index).size();j++) {
				Node temp = list.get(index).get(j);
				if(!check[temp.gps] && key[temp.gps]>temp.score) {
					key[temp.gps]=temp.score;
				}
			}
			
			
			
		}
		
		long result = 0;
		for(int i=1;i<=V;i++) {
			result += key[i];
		}
		System.out.println(result);
		
	}
	public static class Node{
		int gps;
		int score;
		
		Node(int x,int y){
			gps =x;
			score =y;
		}
	}

}
