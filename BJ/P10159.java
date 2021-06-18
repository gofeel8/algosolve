import java.io.*;
import java.util.*;

public class P10159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		List<Integer>[] bigList = new List[N+1];   //나보다 무거운 것들
		List<Integer>[] smallList = new List[N+1];  // 나보다 가벼운 것들
		
		for(int i=0;i<=N;i++) {
			bigList[i]=new ArrayList<Integer>();
			smallList[i]=new ArrayList<Integer>();
			
		}
		
		for(int i=0;i<M;i++) {
			st  = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//a가 b보다 무거움
			bigList[b].add(a);
			smallList[a].add(b);
		}
		
		for(int now=1;now<=N;now++) {
			boolean[] checked = new boolean[N+1];
			int cnt=0;
			//무거운것 찾기
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(now);
			while(!queue.isEmpty()) {
				int tmp = queue.poll();
				for(int i=0;i<bigList[tmp].size();i++) {
					int can =bigList[tmp].get(i);
					if(checked[can]==false) {
						checked[can]=true;
						cnt++;
						queue.add(can);
					}
				}
			}
			
			//가벼운것 찾기
			checked = new boolean[N+1];
			queue.add(now);
			while(!queue.isEmpty()) {
				int tmp = queue.poll();
				for(int i=0;i<smallList[tmp].size();i++) {
					int can =smallList[tmp].get(i);
					if(checked[can]==false) {
						checked[can]=true;
						cnt++;
						queue.add(can);
					}
				}
			}
			bw.write(String.valueOf(N-cnt-1));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
