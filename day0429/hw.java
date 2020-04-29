import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EXP4050 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int i=0;i<N;i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int result = 0;
			int cnt =1;
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(cnt%3!=0) {
					result+=now;
				}
				cnt++;
			}
			System.out.println("#"+tc+" "+result);
		}

	}

}
