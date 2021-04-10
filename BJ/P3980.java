import java.io.*;
import java.util.*;

public class P3980 {
	public static boolean[] used;
	public static List<int []>[] list;
	public static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		for(int t=0;t<TC;t++) {
			answer = 0;
			list =new List[11];
			used = new boolean[11];
			
			for(int i=0;i<11;i++) {
				list[i] = new LinkedList<>();
			}
			for(int i=0;i<11;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<11;j++) {
					int num  = Integer.parseInt(st.nextToken());
					if(num>0) {
						list[j].add(new int[] {i,num});   //i는 j번째 위치에서 뛸 수 있다.
					}
				}
			}
			
			dfs(0,0);
			System.out.println(answer);
		}
		

	}

	private static void dfs(int idx, int sum) {
		if(idx==11) {
			if(sum>answer) {
				answer = sum;
			}
			return;
		}
		
		for(int i=0;i<list[idx].size();i++) {
			int now = list[idx].get(i)[0];
			if(used[now]==false) {
				used[now]=true;
				dfs(idx+1,sum+list[idx].get(i)[1]);
				used[now]=false;
			}
		}
		
	}

}
