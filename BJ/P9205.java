import java.util.*;
import java.io.*;

public class P9205 {
	public static boolean[] visited;
	public static List<int []>list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			int num = Integer.parseInt(br.readLine());
			list = new ArrayList<int[]>();
			int[] home = new int[2];
			int[] festival = new int[2];
			
			visited = new boolean[num];
			
			st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for(int n=0;n<num;n++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a,b});
			}
			st = new StringTokenizer(br.readLine());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());
			
			if(search(home,festival)) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		
			
		}
	}
	private static boolean search(int[] now, int[] festival) {
		//now에서 festival까지 갈수있는지 확인
		if(dist(now,festival)<=1000) {
			return true;
		}
		//그렇지 않다면 편의점 방문
		for(int i=0;i<list.size();i++) {
			if(visited[i]==false && dist(now,list.get(i))<=1000) {
				visited[i]=true;
				if(search(list.get(i), festival)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static int dist(int[] now, int[] dest) {
		int a = Math.abs(now[0]-dest[0]);
		int b = Math.abs(now[1]-dest[1]);
		
		return a+b;
	}

}
