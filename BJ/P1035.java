import java.util.*;
import java.io.*;
public class P1035 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ea = 0;
		int num =0;
		int idx =0;
		for(int i=0;i<5;i++) {
			String str = br.readLine();
			for(int j=0;j<5;j++) {
				num = num<<1;
				if(str.charAt(j)=='*') {
					ea++;
					num = num|(1);
				}
				idx++;
			}
		}
//		System.out.println("ea ="+ea);
//		System.out.println(num);
//		System.out.println(Integer.toBinaryString(num));
		boolean[] used = new boolean[(1<<25)-1];
		used[num] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		
		int step = 0;
		while(!queue.isEmpty()) {
			
			int qsize = queue.size();
			for(int s=0;s<qsize;s++) {
				int now = queue.poll();
				//다 인접해 있는지 확인
				int find = 0;
				Set<Integer> set = new HashSet<>();
				for(int i=0;i<26;i++) {
					if((now&(1<<i))!=0) {  //i번에 조각 존재
						Queue<Integer> adj = new LinkedList<Integer>();
						adj.add(i);
						set.add(i);
						while(!adj.isEmpty()) {
							int tmp = adj.poll();
							find++;
							//상
							if(tmp<20) {
								if((now&(1<<(tmp+5)))!=0) {
									if(!set.contains(tmp+5)) {
										set.add(tmp+5);
										adj.add(tmp+5);
									}
								}
							}
							//하
							if(tmp>=5) {
								if((now&(1<<(tmp-5)))!=0) {
									if(!set.contains(tmp-5)) {
										set.add(tmp-5);
										adj.add(tmp-5);
									}
								}
							}
							//좌
							if((tmp%5)!=4) {
								if((now&(1<<(tmp+1)))!=0) {
									if(!set.contains(tmp+1)) {
										set.add(tmp+1);
										adj.add(tmp+1);
									}
								}
							}
							//우
							if((tmp%5)!=0) {
								if((now&(1<<(tmp-1)))!=0) {
									if(!set.contains(tmp-1)) {
										set.add(tmp-1);
										adj.add(tmp-1);
									}
								}
							}
							
						}
						break;
					}
				}
				if(find ==ea) {
					System.out.println(step);
					return;
				}
				
				//각각 사방 이동
				for(int i=0;i<26;i++) {
					if((now&(1<<i))!=0) {  //i번에 조각 존재
						//상
						if(i<20) {
							if((now&(1<<(i+5)))==0) {
								int tmp  = now-(1<<i);
								tmp = tmp | (1<<(i+5));
								if(used[tmp]==false) {
									queue.add(tmp);
									used[tmp]=true;
								}
							}
						}
						//하
						if(i>=5) {
							if((now&(1<<(i-5)))==0) {
								int tmp  = now-(1<<i);
								tmp = tmp | (1<<(i-5));
								if(used[tmp]==false) {
									queue.add(tmp);
									used[tmp]=true;
								}
							}
						}
						//좌
						if((i%5)!=4) {
							if((now&(1<<(i+1)))==0) {
								int tmp  = now-(1<<i);
								tmp = tmp | (1<<(i+1));
								if(used[tmp]==false) {
									queue.add(tmp);
									used[tmp]=true;
								}
							}
						}
						//우
						if((i%5)!=0) {
							if((now&(1<<(i-1)))==0) {
								int tmp  = now-(1<<i);
								tmp = tmp | (1<<(i-1));
								if(used[tmp]==false) {
									queue.add(tmp);
									used[tmp]=true;
								}
							}
						}
					}
				}
				
			}
			
			step++;
		}
		

	}

}
