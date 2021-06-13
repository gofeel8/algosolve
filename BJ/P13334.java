package BJ;
import java.util.*;
import java.io.*;
public class P13334 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<int [] >list  = new ArrayList<int[]>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st  = new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
			if(b<a) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			list.add(new int[] {a,b});
		}
		
		int d =  Integer.parseInt(br.readLine());
		
		Collections.sort(list,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int right = 0;
		int max = 0;
		int ans = 0;
		for(int left = 0; left<list.size();left++) {

			if(list.get(left)[1]-list.get(left)[0]>d)continue;
			
			//left 값 갱신
			int now  = list.get(left)[0];
			int dist = now+d;
			
			while(!pq.isEmpty()&&pq.peek()<=dist) {
				pq.poll();
				ans++;
			}
			// right 넓히고
			while(right<list.size() && list.get(right)[0]<=dist) {
				if(list.get(right)[1]-list.get(right)[0]>d) {
					right++;
					continue;
				}
				if(list.get(right)[1]<=dist) {
					ans++;
				}else {
					pq.add(list.get(right)[1]);
				}
				right++;
			}
			if(ans>max )max =ans;
			// left  뺴고
			ans--;
		}
		System.out.println(max);
		
	}

}
