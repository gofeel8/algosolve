import java.util.*;
import java.io.*;

public class P17471 {
	public static int N;
	public static int[] person;
	public static List<Integer>[] adjlist;
	public static boolean[] selected;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		person = new int[N+1];
		selected = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		result =Integer.MAX_VALUE;
		
		adjlist = new List[N+1];
		for(int i=0;i<=N;i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 0 )continue;
			else {
				for(int j=0;j<num;j++) {
					adjlist[i].add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		
		subset(1);
		
		
		
		
		
		System.out.println(result==Integer.MAX_VALUE ? -1 : result);
		
		
	}

	private static void subset(int idx) {
		if(idx>N){
			boolean[] checked = Arrays.copyOf(selected, N+1);
			boolean[] unchecked = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				unchecked[i] = !checked[i];
			}
		
			//현재 true 끼리 연결되었는지 확인 리턴값 확인
			int a = bfs(checked);
			
			//현재 false 끼리 연결되어있는지 확인 리턴값 확인
			int b = bfs(unchecked);
			
			//리턴 + 리턴 이 N일때 인구수 차이 확인후 갱신
			if(a+b == N) {
				int asum =0;
				int bsum =0;
				
				for(int i=1;i<=N;i++) {
					if(selected[i]) {
						asum+=person[i];
					}else {
						bsum+=person[i];
					}
				}
				
				result = Math.min(Math.abs(asum-bsum), result);
				
			}
			return;
		}
		
		
			//뽑고
			selected[idx]=true;
			subset(idx+1);
			
			//안뽑고
			selected[idx]=false;
			subset(idx+1);
		
		
	}

	private static int bfs(boolean[] array) {
		int cnt = 0;
		
		int idx = 0;
		for(int i=1;i<=N;i++) {
			if(array[i]) {
				idx = i;
				break;
			}
		}
		
		
		//idx 부터 bfs 하며 
		//array가 true 인거만 queue에 추가 하며 cnt 올리기
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		array[idx]=false;
		cnt++;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<adjlist[now].size();i++) {
				int tmp =adjlist[now].get(i);
				if(array[tmp]) {
					queue.add(tmp);
					array[tmp]=false;
					cnt++;
				}
			}
		}
		
		
		return cnt;
		
	}

}
