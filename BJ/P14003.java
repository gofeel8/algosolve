import java.io.*;
import java.util.*;
public class P14003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[N];
		int[] parent = new int[N];
		int[] arr = new int[N];
		
		int end= 0;
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			parent[i] = i;
			if(i==0) {
				dp[end]=i;
				end++;
				continue;
			}
			
			if(now>arr[dp[end-1]]) {
				parent[i] = dp[end-1];
				dp[end]=i;
				end++;
				continue;
			}
			//이진탐색 시작 
			
			int left=0;
			int right = end-1;
			
			
			int idx=-1;
			while(left<=right) {
				int mid = (left+right)/2;
				
				
				if(now>arr[dp[mid]]) {
					left = mid+1;
				}else if(now<arr[dp[mid]]) {
					idx = mid;
					right = mid-1;
				}else {
					idx = mid;
					break;
				}
				
			}
			if(idx!=0) {
				parent[i] = dp[idx-1];
			}
			dp[idx]=i;	
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(end));
		
		bw.newLine();
		Stack<Integer> stack = new Stack<>();
		int start = dp[end-1];
		
		while(true) {
			stack.add(arr[start]);
			if(parent[start]==start)break;
			start = parent[start];
		}
		
		while(!stack.empty()) {
			bw.write(stack.pop()+" ");
		}
		bw.newLine();
		bw.flush();
		bw.close();

	}
 
}
