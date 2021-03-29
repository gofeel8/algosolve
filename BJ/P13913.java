import java.util.*;
import java.io.*;

public class P13913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int dong = Integer.parseInt(st.nextToken());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(dong==subin) {
			System.out.println(0);
			System.out.println(subin);
		}else if(dong<subin) {
			System.out.println(subin-dong);
			for(int i=subin;i>=dong;i--) {
				bw.write(i+" ");
			}
			bw.flush();
			bw.close();
		}else {
			int[] parent = new int[100001];
			Arrays.fill(parent, -1);
			parent[subin]=subin;
			int time = 1;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(subin);
			while(!queue.isEmpty()) {
				int qsize = queue.size();
				
				for(int s=0;s<qsize;s++) {
					int now = queue.poll();
					if(now == dong) {
						int idx = dong;
						System.out.println(time-1);
						String str = "";
	//					경로 출력
						Stack<Integer> stack = new Stack<>();
						stack.push(dong);
						while(parent[idx]!=subin) {
							idx=parent[idx];
							stack.push(idx);
						}
						stack.push(subin);
						while(!stack.isEmpty()) {
							bw.write(stack.pop()+" ");
						}
						bw.flush();
						bw.close();
						return;
					}
					
					//-1
					if(now>0&&parent[now-1]==-1) {
						parent[now-1]=now;
						queue.add(now-1);
					}
					//+1
					if(now<100000&&parent[now+1]==-1) {
						parent[now+1]=now;
						queue.add(now+1);
					}
					//*2
					if(now*2<=100000&&parent[now*2]==-1) {
						parent[now*2]=now;
						queue.add(now*2);
					}
				}
			time++;
			}
		
		}
		
	}
}
