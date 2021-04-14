import java.io.*;
import java.util.*;
public class P16120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if(str.length()%3 != 1) {
			System.out.println("NP");
			return;
		}
		
		Stack<Character> stack = new Stack<>();
		
		int len = str.length();
		for(int i=0;i<len;i++) {
			char now = str.charAt(i);
			
			if(now == 'P') {
				stack.push('P');
			}else if(now =='A') {
				if(stack.size()<2) {
					System.out.println("NP");
					return;
				}else {
					if(i+1==len || str.charAt(i+1)=='A') {
						System.out.println("NP");
						return;
					}
					stack.pop();
					i++;
				}
			}
		}
		if(stack.size()==1) {
			System.out.println("PPAP");
		}else {
			System.out.println("NP");
		}

	}

}
