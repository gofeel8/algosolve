import java.io.*;
import java.util.*;
public class P1725 {
	public static int [] arr;
	public static int MAX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		Stack<Integer> stack = new  Stack<>();
		stack.push(0);
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
				int height = arr[stack.pop()];
				int area = height * (i-stack.peek()-1);
				if(area > MAX) {
					MAX = area;
				}
			}
			
			stack.push(i);
		}

		while(stack.size()!=1) {
			int height = arr[stack.pop()];
			int area = height * (N-stack.peek());
			if(area > MAX) {
				MAX = area;
			}
		}
	
		System.out.println(MAX);
	}

}
