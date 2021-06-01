import java.io.*;
import java.util.*;

public class P20040 {

	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N   = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];

		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int pa = findParnet(a);
			int pb = findParnet(b);
			if(pa==pb) {
				System.out.println(i);
				return;
			}
			union(pa, pb);
			
		}
		System.out.println(0);

	}
	
	public static int findParnet(int num) {
		if(parent[num]==num) {
			return num;
		}
		
		return parent[num] = findParnet(parent[num]);
	}
	
	public static void union(int pa,int pb) {
		if(pa<pb) {
			parent[pb]=pa;
		}else {
			parent[pa]=pb;
		}
	}

}
