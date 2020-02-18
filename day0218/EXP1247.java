import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int min;
	static int clientNum;
	static boolean[] visited;
	public static Map[] arr;
	public static Map[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			min = Integer.MAX_VALUE;
			clientNum = Integer.parseInt(br.readLine());
			visited = new boolean[clientNum];
			result = new Map[clientNum+2];
			arr = new Map[clientNum+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<clientNum+2;i++) {
				arr[i]=new Map(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			result[0]=arr[0];
			result[clientNum+1]=arr[1];
			dfs(0);
			System.out.println("#"+tc+" "+min);
		}

	}
	
	static int cnt =0;
	public static void dfs(int target) {
		if(target == clientNum) {
			int sum = 0;
			for(int i=0;i<result.length-1;i++) {
				sum += Math.abs(result[i].row-result[i+1].row)+Math.abs(result[i].col-result[i+1].col);
			}
			if(min>sum) {
				min=sum;
			}
			return;
		}
		
		for(int i=0;i<clientNum;i++) {
			if(visited[i]==false) {
				result[target+1]=arr[i+2];
				visited[i]=true;
				dfs(target+1);
				visited[i]=false;
			}
			
		}
			
	}
	
	public static class Map{
		int row;
		int col;
		Map(int x,int y){
			row =x;
			col =y;
		}
		@Override
		public String toString() {
			return "row : "+row+" col : "+col;
		}
		
	}

}
