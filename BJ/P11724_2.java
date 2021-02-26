import java.io.*;
import java.util.*;

import org.xml.sax.HandlerBase;

public class P11724_2 {
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=1;i<=N;i++) {
			int tmp = findParent(i);
			set.add(tmp);
		}
		
		System.out.println(set.size());
		
		
		
		

	}
	
	public static int findParent(int num) {
		if(parent[num] == num) {
			return num;
		}else {
			int tmp =findParent(parent[num]);
			parent[num]=tmp;
			return tmp;
		}
	}
	
	public static void union(int a,int b) {
		int pa=findParent(a);
		int pb=findParent(b);
		if(pa!=pb) {
			parent[pb]=pa;
		}
	}

	

}
