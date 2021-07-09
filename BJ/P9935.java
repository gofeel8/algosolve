import java.io.*;
import java.util.*;
public class P9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		String bomb = br.readLine().trim();
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=1;i<=bomb.length();i++) {
			map.put(bomb.charAt(i-1), i);
		}
		Deque<Character> dq = new LinkedList<Character>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char now = str.charAt(i);
			
			if(map.containsKey(now)) {
				dq.addLast(now);
				int num = map.get(now);
				if(!stack.isEmpty()&&(stack.peek()==num-1)) {
					stack.push(num);
//					System.out.println(stack.peek());
					if(num==bomb.length()) {
						for(int j=0;j<bomb.length();j++) {
							stack.pop();
							dq.pollLast();
						}
					}
				}else {
					if(num==1) {
						stack.push(1);
						if(num==bomb.length()) {
							for(int j=0;j<bomb.length();j++) {
								stack.pop();
								dq.pollLast();
							}
						}
					}else {
						stack.push(0);
					}
				}
			}else {
				dq.addLast(now);
				stack.push(0);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(dq.isEmpty()) {
			bw.write("FRULA");
//			System.out.println("FRULA");
		}else {
			while(!dq.isEmpty()) {
//				System.out.print(dq.pollFirst());
				bw.write(dq.pollFirst());
			}
		}
		bw.flush();
		bw.close();
	}
	
}
