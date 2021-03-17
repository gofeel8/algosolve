import java.io.*;
import java.util.*;

public class P6198 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		
		int N = Integer.parseInt(br.readLine());
		long sum=0;
		
		int num;
		
		Stack<Integer> stack  =  new Stack<>();
		
		for(int i=0;i<N;i++) {
			num  = Integer.parseInt(br.readLine());
			
			
			while(stack.size()!=0 && stack.peek()<= num ) {
				stack.pop();
			}
			
			sum+=stack.size();
			stack.push(num);
			
		}
		
		
		
		System.out.println(sum);

	}

}
