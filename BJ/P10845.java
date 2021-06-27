package GPS;

import java.io.*;
import java.util.*;


public class Queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		myQueue queue = new myQueue(10);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.push(num);
				break;
			case "pop":
				System.out.println(queue.pop());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.empty());
				break;
			case "front":
				System.out.println(queue.front());
				break;
			case "back":
				System.out.println(queue.back());
				break;

			default:
				break;
			}
		}
	}
	
	public static class myQueue{
		int front;
		int rear;
		int[] arr;
		
		public myQueue(int size) {
			front = 0;
			rear = 0;
			arr = new int[size];
		}
		
		public void push(int num) {
			if(rear==arr.length) {
				int[] newArr = new int[arr.length*2];
				for(int i=0;i<arr.length;i++) {
					newArr[i]= arr[i];
				}
				arr = newArr;
			}
			
			arr[rear++]=num;
		}
		
		public int pop() {
			if(empty()==1) {
				return -1;
			}
			return arr[front++];
		}
		
		public int size() {
			return rear-front;
		}
		
		public int empty() {
			if(front==rear) {
				return 1;
			}
			return 0;
		}
		public int front() {
			if(empty()==1) {
				return -1;
			}
			return arr[front];
		}
		
		public int back() {
			if(empty()==1) {
				return -1;
			}
			return arr[rear-1];
		}
		
	}

}
