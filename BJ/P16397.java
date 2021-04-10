import java.io.*;
import java.util.*;

public class P16397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int  N  = Integer.parseInt(st.nextToken());  //LED 
		int  T  = Integer.parseInt(st.nextToken());   // 버튼 최대 횟수
		int  G  = Integer.parseInt(st.nextToken());   // 탈출 넘버
		
		boolean[] used = new boolean[100000];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		used[N] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			if(cnt>T) {
				break;
			}
			for(int i=0;i<qsize;i++) {
				int now = queue.poll();
				if(now==G) {
					System.out.println(cnt);
					return;
				}
				//A버튼
				int tmp = now+1;
				
				if(tmp<100000 && used[tmp]==false) {
					queue.add(tmp);
					used[tmp]=true;
				}
				
				//B버튼
				if(now != 0) {
					tmp = now*2;
					if(tmp<=99999) {
						int size = (int) Math.log10(tmp);
						tmp -= Math.pow(10, size);
						if(used[tmp]==false) {
							queue.add(tmp);
							used[tmp]=true;
						}
					}
				}
			}
			cnt++;
		}
		System.out.println("ANG");
		
	}

}
