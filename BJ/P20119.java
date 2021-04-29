import java.io.*;
import java.util.*;

public class P20119 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] make = new boolean[N+1];
		int M  = Integer.parseInt(st.nextToken());
		
		List<Integer> answer = new ArrayList<Integer>();
		
		
		List<Integer>[] list = new List[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Set<Integer>>[] set = new List[N+1];
		
		for(int i=0;i<=N;i++) {
			set[i] = new ArrayList<Set<Integer>>();
		}
		
		
		for(int i=0;i<M;i++) {
			st =new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int[] tmp = new int[k];
			Set<Integer> tmpSet = new HashSet<>();
			for(int j=0;j<k;j++) {
				int num = Integer.parseInt(st.nextToken());
				tmp[j] = num;
				tmpSet.add(num);
			}
			int now = Integer.parseInt(st.nextToken());
			set[now].add(tmpSet);
			
//			map.put(now, k);
			for(int j=0;j<k;j++) {
				list[tmp[j]].add(now);
			}
		}
		
		
		
//		for(int i=0;i<set.length;i++) {
//			System.out.println("i="+i);
//			for(int j=0;j<set[i].size();j++) {
//				Iterator it  = set[i].get(j).iterator();
//				while(it.hasNext()) {
//					System.out.print(it.next()+" ");
//				}
//				System.out.println();
//			}
//		}
//		
		
		
		
		int L  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<L;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			answer.add(tmp);
			make[tmp]=true;
		}
		
		for(int i=0;i<answer.size();i++) {
			int now = answer.get(i);
			for(int j=0;j<list[now].size();j++) {
				int tmp = list[now].get(j);
				if(make[tmp])continue;
				
				for(int k=0;k<set[tmp].size();k++) {
					if(set[tmp].get(k).contains(now)) {
						set[tmp].get(k).remove(now);
						if(set[tmp].get(k).size()==0 && make[tmp]==false) {
							make[tmp]=true;
							answer.add(tmp);
						}
					}
				}
				
				
			}
		}

		
	
		

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer.size()));
		bw.newLine();

		Collections.sort(answer);
		for(int num : answer) {
			bw.write(String.valueOf(num)+" ");
		}
		bw.flush();
		bw.close();
	}

}
