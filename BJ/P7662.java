import java.io.*;
import java.util.*;


public class P7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		for(int t=0;t<T;t++) {
			PriorityQueue<Integer> upQueue = new PriorityQueue<>();
			PriorityQueue<Integer> downQueue = new PriorityQueue<>(Collections.reverseOrder());

			Map<Integer, Integer> map = new HashMap<>();
			int num = Integer.parseInt(br.readLine());
			for(int i=0;i<num;i++) {
				st = new StringTokenizer(br.readLine());
				if(st.nextToken().equals("I")) {
					int tmp = Integer.parseInt(st.nextToken());
					upQueue.offer(tmp);
					downQueue.offer(tmp);
					if(map.containsKey(tmp)) {
						map.put(tmp, map.get(tmp)+1);
					}else {
						map.put(tmp, 1);
					}
				}else {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == -1) { //최솟값
						while(true) {
							if(upQueue.size()==0)break;
							int now = upQueue.peek();
							if(map.containsKey(now)) {
								upQueue.poll();
								int cnt = map.get(now);
								if(cnt==1) {
									map.remove(now);
								}else {
									map.put(now, cnt-1);
								}
								break;
							}else {
								upQueue.poll();
							}
						}
						
					}else {  //최댓값
						while(true) {
							if(downQueue.size()==0)break;
							int now = downQueue.peek();
							if(map.containsKey(now)) {
								downQueue.poll();
								int cnt = map.get(now);
								if(cnt==1) {
									map.remove(now);
								}else {
									map.put(now, cnt-1);
								}
								break;
							}else {
								downQueue.poll();
							}
						}
						
					}
				}
			}
			
			if(map.size()==0) {
				System.out.println("EMPTY");
			}else {
				int max =0;
				while(true) {
					int now = downQueue.peek();
					if(map.containsKey(now)) {
						max = downQueue.poll();
						break;
					}else {
						downQueue.poll();
					}
				}
				int min =0;
				while(true) {
					int now = upQueue.peek();
					if(map.containsKey(now)) {
						min = upQueue.poll();
						break;
					}else {
						upQueue.poll();
					}
				}
				System.out.println(max + " "+ min);
			}
			
			
		}
		
		
		
		
		

	}
	

}
