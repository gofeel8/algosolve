import java.io.*;
import java.util.*;
public class P11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		while(N!=0) {
			stack.push(N%B);
			N/=B;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			int now =stack.pop();
			if(now>9) {
				sb.append((char)('A'+(now-10)));
			}else {
				sb.append(now);
			}
		}
		System.out.println(sb.toString());
	
	}

}
