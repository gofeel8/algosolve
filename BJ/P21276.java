import java.util.*;
import java.io.*;

public class P21276 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		
		String[] name = new String[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		Map<String, Integer>map = new HashMap<String, Integer>();
		for(int i=0;i<N;i++) {
			name[i] = st.nextToken();
		}
		Arrays.sort(name);
		for(int i=0;i<N;i++) {
			map.put(name[i], i);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] childs = new List[N];
		List<Integer>[] parents = new List[N];
		List<String>[] answer = new List[N];
		for(int i=0;i<N;i++) {
			childs[i] = new ArrayList<>();
			parents[i] = new ArrayList<>();
			answer[i] = new ArrayList<>();
		}
		
		int[] cnt = new int[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent = st.nextToken();
			childs[map.get(parent)].add(map.get(child));
			parents[map.get(child)].add(map.get(parent));
			cnt[map.get(child)]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i=0;i<N;i++) {
			if(cnt[i]==0) {
				queue.add(i);
			}
		}
		
		int qsize  = queue.size();
		System.out.println(qsize);
		for(int i=0;i<qsize;i++) {
			int tmp = queue.poll();
			System.out.print(name[tmp]+" ");
			queue.add(tmp);
		}System.out.println();

		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<childs[now].size();i++) {  //순서 뒤죽박죽
				int c = childs[now].get(i);
				cnt[c]--;
				if(cnt[c]==0) {
					answer[now].add(name[c]);
					queue.add(c);
				}
			}
		}
		for(int i=0;i<answer.length;i++) {
			Collections.sort(answer[i]);
		}
		for(int i=0;i<N;i++) {
			System.out.print(name[i]+" "+answer[i].size()+" ");
			for(int j=0;j<answer[i].size();j++) {
				System.out.print(answer[i].get(j)+" ");
			}System.out.println();
		}
		
	}

}
