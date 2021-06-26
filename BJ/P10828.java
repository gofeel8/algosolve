package GPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		myStack stack = new myStack(10);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st  = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			case "top":
				System.out.println(stack.top());
				break;

			default:
				break;
			}
		}
	}

	
	
	public static class myStack {
		int top;
		int[] arr;
		
		public myStack(int size){
			arr = new int[size];
			top = -1;
		}
		public void push(int num) {
			++top;
			if(top==arr.length) {
				multiple();
			}
			arr[top]=num;
		}
		public int pop() {
			if(empty()==1) {
				return -1;
			}
			return arr[top--];
		}
		public int size() {
			return top+1;
		}
		public int empty() {
			if(top==-1) {
				return 1;
			}else {
				return 0;
			}
		}
		
		public int top() {
			if(empty()==1) {
				return -1;
			}
			return arr[top];
		}
		
		public void multiple() {
			int[] newArr = new int[arr.length*2];
			for(int i=0;i<arr.length;i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
	}
}

