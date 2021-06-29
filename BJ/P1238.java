import java.io.*;
import java.util.*;
public class P1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		Node[] arr = new Node[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			if(arr[start]==null) {
				arr[start] = new Node(end,time,null);
			}else {
				Node now = arr[start];
				while(now.next!=null) {
					now = now.next;
				}
				now.next = new Node(end,time,null);
			}
		}
		
		
		int[] memo = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			if(i==X)continue;   //나중에 처리 예정
			
			
			//i 에서 X 까지 다익스트라 구해보기
			int[] time  = new int[N+1];
			Arrays.fill(time, Integer.MAX_VALUE);
			time[i] = 0;
			
			boolean[] used = new boolean[N+1];
			while(true) {
				int minIdx = -1;
				int min = Integer.MAX_VALUE;
				for(int j=1;j<=N;j++) {
					if(used[j]==false&&time[j]<min) {   
						min = time[j];
						minIdx = j;
					}
				}
				if(minIdx == -1)break;
				
				if(minIdx==X) {
					memo[i]=time[minIdx];
					break;
				}
				
				used[minIdx]=true;
				Node tmp = arr[minIdx];
				while(tmp!=null) {
					if(time[tmp.able]>time[minIdx]+tmp.time) {
						time[tmp.able]=time[minIdx]+tmp.time;
					}
					
					tmp = tmp.next;
				}
				
			}
			
			
		}
		
		
		
		//X에서 각각 
		
		int[] Xtime  = new int[N+1];
		Arrays.fill(Xtime, Integer.MAX_VALUE);
		Xtime[X] = 0;
		boolean[] used = new boolean[N+1];
		while(true) {
			int minIdx = -1;
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=N;j++) {
				if(used[j]==false&&Xtime[j]<min) {      
					min = Xtime[j];
					minIdx = j;
				}
			}
			if(minIdx == -1)break;
			
			used[minIdx]=true;
			Node tmp = arr[minIdx];
			while(tmp!=null) {
				if(Xtime[tmp.able]>Xtime[minIdx]+tmp.time) {
					Xtime[tmp.able]=Xtime[minIdx]+tmp.time;
				}
				tmp = tmp.next;
			}
			
		}
		int max = -1;
		for(int i=1;i<=N;i++) {
			if(memo[i]+Xtime[i]>max) {
				max=memo[i]+Xtime[i];
			}
		}
		System.out.println(max);
	}
	
	public static class Node{
		int able;
		int time;
		Node next;
		
		public Node(int a,int t,Node n) {
			able =a;
			time =t;
			next =n;
		}
	}

}
