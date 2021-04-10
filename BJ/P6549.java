import java.io.*;
import java.util.*;
public class P6549 {
	public static long [] arr;
	public static long MAX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		while(true) {
			MAX = 0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0)break;
			arr = new long[N+1];
			Stack<Integer> stack = new  Stack<>();
			stack.push(0);
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
					long height = arr[stack.pop()];
					long area = height * (i-stack.peek()-1);
					if(area > MAX) {
						MAX = area;
					}
				}
				
				stack.push(i);
			}
			
			while(stack.size()!=1) {
				long height = arr[stack.pop()];
				long area = height * (N-stack.peek());
				if(area > MAX) {
					MAX = area;
				}
			}
			
			System.out.println(MAX);
		}
	}

}
