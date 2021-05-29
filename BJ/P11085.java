import java.io.*;
import java.util.*;
public class P11085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int  p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		List<int []>[] list = new List[p];
		for(int i=0;i<p;i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i=0;i<w;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new int[] {y,z});
			list[y].add(new int[] {x,z});
		}
		
		int[] width = new int[p];
		Arrays.fill(width, -1);
		width[start] = Integer.MAX_VALUE;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now==end)continue;
			for(int i=0;i<list[now].size();i++) {
				int[] can = list[now].get(i);
				int able =0;
				if(width[now]>can[1]) {
					able = can[1];
				}else {
					able = width[now];
				}
				if(width[can[0]]<able) {
					width[can[0]]=able;
					queue.add(can[0]);
				}
			}
		}
		
		System.out.println(width[end]);
		
		

	}

}
