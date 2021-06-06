import java.io.*;
import java.util.*;
public class P3015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		stack.add(new int[] {Integer.parseInt(br.readLine()),1});
		long ans = 0;
		for(int i=1;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			int same=1;
			while(!stack.isEmpty()) {
				int[] peek = stack.peek();
				if(peek[0]<now) {
					stack.pop();
					ans+=peek[1];
				}else if(peek[0] == now) {
					stack.pop();
					ans+=peek[1];
					same += peek[1];
				}else if(peek[0]>now) {
					ans++;
					break;
				}
			}
			stack.push(new int[] {now,same});
		}
		System.out.println(ans);
	}

}
