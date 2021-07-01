import java.io.*;
import java.util.*;


public class P14438 {
	public static int [] tree,input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input =  new int[N+1];
		tree = new int[N*4];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,N);
		
		int M= Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd =Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd==1) {
				//a 를 b 로 바꾼다
				update(a,input[a],b,1,1,N);
				input[a]=b;
			}else {
				//a에서 b까지 최소값 출력
				System.out.println(search(a, b, 1, 1, N));
			}
		}
		
	}
	
	public static int init(int Node,int NodeLeft, int NodeRight) {
		if(NodeLeft==NodeRight) {
			tree[Node]=input[NodeLeft];
			return tree[Node];
		}
		int mid = (NodeLeft+NodeRight)/2;
		tree[Node] = Math.min(init(Node*2,NodeLeft,mid),init(Node*2+1,mid+1,NodeRight));
		return tree[Node]; 
	}
	
	public static void update(int target,int oldValue, int newValue, int Node, int NodeLeft,int NodeRight) {
		if(NodeLeft>target || NodeRight<target) {
			return;
		}
		if(NodeLeft==NodeRight) {
			tree[Node]=newValue;
			return;
		}
		
		int mid = (NodeLeft+NodeRight)/2;
		update(target,oldValue,newValue,Node*2,NodeLeft,mid);
		update(target,oldValue,newValue,Node*2+1,mid+1,NodeRight);
		tree[Node]=Math.min(tree[Node*2], tree[Node*2+1]);
	}
	
	public static int search(int start,int end,int Node, int NodeLeft,int NodeRight) {
		if(start>NodeRight || end<NodeLeft) {
			return Integer.MAX_VALUE;
		}
		if(start<=NodeLeft&& NodeRight<=end) {
			return tree[Node];
		}
		
		int mid = (NodeLeft+NodeRight)/2;
		return Math.min(search(start,end,Node*2,NodeLeft,mid), search(start,end,Node*2+1,mid+1,NodeRight));
	}

}
