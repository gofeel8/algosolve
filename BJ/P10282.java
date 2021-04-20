import java.io.*;
import java.util.*;

public class P10282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			
			List<int []>[] list = new List[n+1];
			for(int q=0;q<=n;q++) {
				list[q]=new ArrayList<int[]>();
			}
			
			for(int j=0;j<d;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new int[] {a,s});
			}
			
			boolean[] used = new boolean[n+1];
			PriorityQueue<int []>pq = new PriorityQueue<>(new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			int time=0;
			int cnt =0;
			pq.add(new int[] {c,0});
			while(!pq.isEmpty()) {
				int[] now =pq.poll();
				if(used[now[0]])continue;
				used[now[0]]=true;
				cnt++;
				time = now[1];
				for(int s=0;s<list[now[0]].size();s++) {
					int[] tmp = list[now[0]].get(s);
					pq.add(new int[] {tmp[0],time+tmp[1]});
				}
			}
			bw.write(String.valueOf(cnt)+" "+String.valueOf(time));
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
