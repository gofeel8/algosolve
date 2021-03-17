import java.io.*;
import java.util.*;

public class P2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> height = new Stack<>();
		
		stack.add(-1);
		height.add(-1);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num=0;
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			while(stack.peek()!=-1 && height.peek()<=num) {
				stack.pop();
				height.pop();
			}
			
			if(stack.peek() == -1) {
				bw.append("0 ");
			}else { // 높은 벽을 만났을때
				bw.append((stack.peek()+1)+" ");
			}
			stack.push(i);
			height.push(num);
			
			
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
