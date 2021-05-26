import java.io.*;
import java.util.*;
public class P14718 {
	public static int[][] arr;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Set<Integer> hset = new TreeSet<>();
		Set<Integer> mset = new TreeSet<>();
		Set<Integer> jset = new TreeSet<>();
		
		arr = new int[N][3];
		
		answer =Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[i][0]=h;
			arr[i][1]=m;
			arr[i][2]=j;
			hset.add(h);
			mset.add(m);
			jset.add(j);
		}
		
		Iterator<Integer> it = hset.iterator();
		while(it.hasNext()) {
			int h = it.next();
			Iterator<Integer> jit = jset.iterator();
			while(jit.hasNext()) {
				int j = jit.next();
				Iterator<Integer> mit = mset.iterator();
				while(mit.hasNext()) {
					int m = mit.next();
					int cnt = 0;
					for(int i=0;i<N;i++) {
						if(arr[i][0]<=h && arr[i][1]<=m && arr[i][2]<=j) {
							cnt++;
						}
						if(cnt == K)break;
					}
					if(cnt==K) {
						if(answer>h+j+m)answer = h+j+m;
					}
				}
			}
				
		}
		
		System.out.println(answer);
	}


}
