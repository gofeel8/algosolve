import java.io.*;
import java.util.*;
public class P17140 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
			
		int[][] map = new int[101][101];
		for(int i=1;i<=3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		int rowIdx = 3;
		int colIdx = 3;
		
		for(int i=0;i<=100;i++) {
			if(map[r][c]==k) {
				System.out.println(i);
				return;
			}
			
			if(rowIdx>=colIdx) { //행연산
				int maxIdx = 0;
				for(int j=1;j<=rowIdx;j++) {
					TreeMap<Integer, Integer> tmap = new TreeMap<>();
					for(int q=1;q<101;q++) {
						int num = map[j][q];
						if(num !=0) {
							tmap.put(num, tmap.getOrDefault(num, 0)+1);
						}
					}
					
					PriorityQueue<Node> pq = new PriorityQueue<>();
					for(Integer it : tmap.keySet()) {
						pq.add(new Node(it,tmap.get(it)));
						
					}
					
					int tmpIdx =1;
					while(!pq.isEmpty()) {
						Node now =pq.poll();
						if(tmpIdx==101)break;
						map[j][tmpIdx++]=now.num;
						map[j][tmpIdx++]=now.cnt;
						if(maxIdx<tmpIdx) {
							maxIdx = tmpIdx;
						}
					}
					
					for(int z=tmpIdx;z<101;z++) {
						map[j][z]=0;
					}
					
				}
				colIdx=maxIdx-1;
			}else {  // 열 연산
				int maxIdx = 0;
				for(int j=1;j<=colIdx;j++) {
					TreeMap<Integer, Integer> tmap = new TreeMap<>();
					for(int q=1;q<101;q++) {
						int num = map[q][j];
						if(num!=0) {
							tmap.put(num, tmap.getOrDefault(num, 0)+1);
						}
					}
					
					PriorityQueue<Node> pq = new PriorityQueue<>();
					for(Integer it : tmap.keySet()) {
						pq.add(new Node(it,tmap.get(it)));
						
					}
					
					int tmpIdx =1;
					while(!pq.isEmpty()) {
						Node now =pq.poll();
						if(tmpIdx==101)break;
						map[tmpIdx++][j]=now.num;
						map[tmpIdx++][j]=now.cnt;
						if(maxIdx<tmpIdx) {
							maxIdx = tmpIdx;
						}
					}
					for(int z=tmpIdx;z<101;z++) {
						map[z][j]=0;
					}
					
				}
				rowIdx=maxIdx-1;
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	public static class Node implements Comparable<Node>{
		int num;
		int cnt;
		
		public Node(int n,int c){
			num = n;
			cnt = c;
		}
		@Override
		public int compareTo(Node o) {
			if(cnt != o.cnt) {
				return cnt-o.cnt;
			}else {
				return num - o.num;
			}
		}
		
	}

}
