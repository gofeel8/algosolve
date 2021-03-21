package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1068 {
	public static List<Integer>[] list;
	public static boolean[] visited;
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		list = new List[N];
		visited = new boolean[N];
		result = 0;
		for(int i=0;i<N;i++) {
			list[i]=new ArrayList<>();
		}
		
		int root=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i]=tmp;
			if(tmp != -1) {
				list[tmp].add(i);
			}else {
				root = i;
			}
		}
		
		int del = Integer.parseInt(br.readLine());
		
		if(arr[del]==-1) {
			System.out.println(0);
			return;
		}
		
		for(int i=0;i<list[arr[del]].size();i++) {
			if(list[arr[del]].get(i) == del) {
				list[arr[del]].remove(i);
				break;
			}
		}
		
		search(root);
		System.out.println(result);

	}

	private static void search(int root) {
		if(list[root].size()==0) {
			result++;
			return;
		}
		for(int i=0;i<list[root].size();i++) {
			search(list[root].get(i));
		}
		
	}

}


