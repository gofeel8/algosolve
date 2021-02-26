import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P1707 {
	public static List<Integer>[] list;
	public static Set<Integer>left;
	public static Set<Integer>right;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc =Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for(int t=0;t<tc;t++) {
			st = new StringTokenizer(br.readLine());
			int V =Integer.parseInt(st.nextToken());
			int E =Integer.parseInt(st.nextToken());
			
			boolean flag= true;
			list = new List[V+1];
			
			left = new HashSet<>();
			right = new HashSet<>();
			
			for(int i=0;i<V+1;i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a =Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int i=1;i<=V;i++) {
				
				if(!left.contains(i)&& !right.contains(i)) {  //아직 처리하지 못한 점
					if(check(i)==false) {
						flag= false;
						break;
					}
				}
				
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}
	
	public static boolean check(int i) {
		
		Queue<int [] >queue = new LinkedList<int[]>();
		queue.add(new int[] {i,0});
		left.add(i);
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int me= tmp[0];
			int myside = tmp[1];
			
			
			for(int j=0; j<list[me].size();j++) {
				int cango = list[me].get(j);
				
				if(myside==0) {  //현재 주인공은 왼편  
					if(left.contains(cango)) {
						// NO!!!!
						return false;
					}else if(!right.contains(cango)) {
						right.add(cango);
						queue.add(new int[] {cango,1});
					}
				}else {         //현재 주인공은 오른편
					if(right.contains(cango)) {
						// NO!!!!
						return false;
					}else if(!left.contains(cango)) {
						left.add(cango);
						queue.add(new int[] {cango,0});
					}
				}
				
				
				
			}
		}
		return true;
		
	}

}
