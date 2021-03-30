import java.util.*;
import java.io.*;
public class P1339 {

	public static List<Character> list;
	public static String[] arr;
	public static int[] num;
	public static boolean[] visited;
	public static int Max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		list = new ArrayList<Character>();
		for(int i=0;i<N;i++) {
			String str =br.readLine();
			arr[i]=str;
			for(int j=0;j<str.length();j++) {
				char now = str.charAt(j);
				boolean flag =false;
				for(int q=0;q<list.size();q++) {
					if(list.get(q)==now) {
						flag =true;
					}
				}
				if(flag==false) {
					list.add(now);
				}
			}
		}
		
		Max = Integer.MIN_VALUE;
		num = new int[list.size()];
		visited = new boolean[10];
		dfs(0);
		System.out.println(Max);

	}
	
	public static void dfs(int idx) {
		if(idx == list.size()) {
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				String now = arr[i];
				
				int q=1;
				for(int j=now.length()-1;j>=0;j--) {
					char tmp = now.charAt(j);
					sum += num[list.indexOf(tmp)]*q;
					q *=10;
				}
			}
			
			if(Max<sum) {
				Max = sum;
			}
			return;
		}
		
		
		for(int i=9;i>9-list.size();i--) {
			if(visited[i]==false) {
				visited[i]=true;
				num[idx]=i;
				dfs(idx+1);
				visited[i]=false;
			}
		}
	}

}
