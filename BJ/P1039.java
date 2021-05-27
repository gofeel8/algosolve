import java.io.*;
import java.util.*;

public class P1039 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		
		int step = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(!queue.isEmpty()) {
			if(step == K) {
				//큐에서 가장 큰값 찾아서 출력
				int max  = -1;
				while(!queue.isEmpty()) {
					int n = queue.poll();
					if(n>max)max = n;
				}
				
				System.out.println(max);
				return;
			}
			
			int qsize =  queue.size();
			Set<Integer> used = new HashSet<>();
			for(int s=0;s<qsize;s++) {
				int now = queue.poll();
				char[] arr = Integer.toString(now).toCharArray();
				for(int i=0;i<arr.length-1;i++) {
					for(int j=i+1;j<arr.length;j++) {
						if(i==0 && arr[j]=='0')continue;
						
						char tmp = arr[i];
						arr[i] = arr[j];
						arr[j]= tmp;
						
						int newNum = Integer.parseInt(new String(arr));
						if(!used.contains(newNum)) {
							used.add(newNum);
							queue.add(newNum);
						}
						arr[j]=arr[i];
						arr[i]= tmp;
					}
					
				}
				
			}
			
			step++;
		}
		
		System.out.println(-1);
	
	}

}
