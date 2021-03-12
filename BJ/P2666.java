import java.io.*;
import java.util.*;

public class Main {
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(br.readLine());
		int[] arr =  new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		result = Integer.MAX_VALUE;
		
		Queue<Room> queue = new LinkedList<>();
		queue.add(new Room(left,right,0,0));
		
		while(!queue.isEmpty()) {
			Room now = queue.poll();
			//마지막 문처리했을경우 처리
			
			if(now.target==size) {
				if(result>now.cnt) {
					result = now.cnt;
				}
				continue;
			}
			
			if(result<now.cnt) {
				continue;
			}
			
			
			//문1 확인
			//일치
				int gap = Math.abs(arr[now.target]-now.open1);
				queue.add(new Room(arr[now.target],now.open2,now.target+1,now.cnt+gap));
				
			
			
			//문2 확인
				gap = Math.abs(arr[now.target]-now.open2);
				queue.add(new Room(now.open1,arr[now.target],now.target+1,now.cnt+gap));
		}
		
		
		System.out.println(result);
		
		
		
	}
	
	public static class Room{
		int open1;
		int open2;
		int target;
		int cnt;
		
		Room(int o1,int o2, int t, int c){
			open1 = o1;
			open2 = o2;
			target = t;
			cnt = c;
		}

	}
	
	

}
