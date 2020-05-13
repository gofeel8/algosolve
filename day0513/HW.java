import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N + 1];
		List<Integer>[] comm = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++) {
			comm[i]=new ArrayList<Integer>();
		}
		
		StringBuilder result = new StringBuilder();
		Set<Integer> set= new TreeSet<Integer>(); 		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			comm[a].add(b);
			set.add(a); // 출발선일 가능성이있는것들 set에 넣음
			array[b]++;
		}
		
		boolean[] used = new boolean[N+1];
		
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int i=1;i<N+1;i++) {
			if(array[i]==0)queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			result.append(num+" ");
			used[num]=true;
			
			for(int i=0;i<comm[num].size();i++) {
					array[comm[num].get(i)]--;
					if(array[comm[num].get(i)]==0) {
						queue.add(comm[num].get(i));
					}
			}
		}
		
		
		for(int i=1;i<N+1;i++) {
			if(used[i]==false) {
				result.append(i+" ");
			}
		}
		
		System.out.println(result.toString().trim());

	}
}
