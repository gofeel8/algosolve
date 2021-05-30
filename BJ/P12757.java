import java.io.*;
import java.util.*;

public class P12757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(k);
			map.put(k, v);
		}
		
		Collections.sort(list);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			int idx  = search(list, key);
			if(c==1) {     // insert
				int value = Integer.parseInt(st.nextToken());
				list.add(idx, key);
				map.put(key, value);
			}else if(c==2) {   // update
				int value = Integer.parseInt(st.nextToken());
				int prev = -1;
				if(idx>0) {
					prev = idx-1;
				}
				int next = -1;
				if(list.size()!=idx) {
					next = idx;
				}
				int gap=10000000, gap2=10000000;
				if(prev != -1) {
					gap=  Math.abs(list.get(prev)-key);
				}
				if(next!=-1) {
					gap2 = Math.abs(list.get(next)-key);
				}
				if(gap2==gap)continue;
				if(gap<=K || gap2<=K) {
					if(gap<gap2) {
						map.put(list.get(prev), value);
					}else {
						map.put(list.get(next), value);
					}
				}
				
			}else if(c==3) { // read
				
				int prev = -1;
				if(idx>0) {
					prev = idx-1;
				}
				int next = -1;
				if(list.size()!=idx) {
					next = idx;
				}
				int gap=10000000, gap2=10000000;
				if(prev != -1) {
					gap=  Math.abs(list.get(prev)-key);
				}
				if(next!=-1) {
					gap2 = Math.abs(list.get(next)-key);
				}
				
				if(gap>K && gap2>K) {
					bw.write("-1");
					bw.newLine();
//					System.out.println("-1");
				}else if(gap == gap2) {
					bw.write("?");
					bw.newLine();
//					System.out.println("?");
				}else if(gap<gap2) {
					bw.write(String.valueOf(map.get(list.get(prev))));
					bw.newLine();
//					System.out.println(map.get(list.get(prev)));
				}else if(gap>gap2) {
					bw.write(String.valueOf(map.get(list.get(next))));
					bw.newLine();
//					System.out.println(map.get(list.get(next)));
					
				}
				
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static int search(List<Integer> list,int key) {   // key 가 들어가야할 위치 반환
		//이진탐색
		int left = 0; 
		int right = list.size()-1;
		int rt =right;
		while(left<=right) {
			int mid = (left+right)/2;
			int now = list.get(mid);
			if(now>key) {
				rt = mid;
				right = mid-1;
			}else if(now<key) {
				left = mid+1;
			}else if(now == key) {
				return mid;
			}
		}
		
		return rt;
	}

}
