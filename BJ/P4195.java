import java.util.*;
import java.io.*;

public class P4195 {
	public static int[] parent,sum;
	public static List<int []>adj;
	public static Map<String,Integer>map;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			adj = new ArrayList<int[]>();
			map = new HashMap<String, Integer>();
			
			int idx =0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String A =  st.nextToken();
				String B = st.nextToken();
				
				if(!map.containsKey(A)) {
					map.put(A, idx++);
				}
				if(!map.containsKey(B)) {
					map.put(B, idx++);
				}
				
				adj.add(new int[] {map.get(A),map.get(B)});
			}
			
			parent = new int[idx];
			sum = new int[idx];
			
			for(int i=0;i<idx;i++) {
				parent[i]=i;
				sum[i]=1;
			}
			
			
			for(int i=0;i<adj.size();i++) {
				int[] now = adj.get(i);
				union(now[0],now[1]);
				
			}
			
			
			
			
		}
		bw.flush();
		bw.close();
	}
	
	public static void union(int a,int b) throws IOException {
		int pa = findParent(a);
		int pb = findParent(b);
		
		
		if(pa == pb) {
			bw.write(String.valueOf(sum[pa]));
			bw.newLine();
			return;
		}
		
		parent[pb]=pa;
		sum[pa]+=sum[pb];

		bw.write(String.valueOf(sum[pa]));
		bw.newLine();
		
	}
	
	public static int findParent(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a]=findParent(parent[a]);
	}
	

}
