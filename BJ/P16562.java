import java.io.*;
import java.util.*;

public class P16562 {
	public static int[] parent,price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		price = new int[N+1];
		
		parent = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			parent[i]=i;
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int sum=0;
		for(int i=1;i<=N;i++) {
			if(parent[i]==i) {
				sum+=price[i];
			}
		}
		
		System.out.println(sum<=K ? sum : "Oh no");

	}
	
	public static int findParent(int n) {
		if(parent[n]==n) {
			return n;
		}else {
			return parent[n]= findParent(parent[n]);
		}
	}
	
	public static void union (int a,int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if(pa==pb)return;
		
		if(price[pa]<price[pb]) {
			parent[pb]=pa;
		}else {
			parent[pa]=pb;
		}
		
	}

}
