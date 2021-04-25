import java.io.*;
import java.util.*;

public class P1306_2 {
	public static int[] tree,arr;

	public static void main(String[] args)  throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		tree = new int [10000000];
		arr = new int [N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1,N,1);
		
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = M; i <= N  ; i++) {
			int lo = i - M + 1;
			int hi = i + M - 1;

			bw.write(search(lo, hi, 1, 1, N)+" ");
			if(i== N - M + 1)break;
		}

		
		
		
		bw.flush();
		bw.close();
		
		
	
	}
	
	public static int init(int left, int right, int now) {
		if(left == right) {
			tree[now] = arr[left];
			return tree[now];
		}
		int mid = (left+right)/2;
		return tree[now] = Math.max(init(left,mid,now*2),  init(mid+1,right,now*2+1));
	}
	
	public static int search(int left,int right , int Node ,int lNode, int rNode) {
		if(left>rNode || right <lNode) {
			return 0;
		}
		if(left<=lNode && right>=rNode) {
			return tree[Node];
		}
		

		int mid = (lNode+rNode)/2;
		return Math.max(search(left,right,Node*2,lNode,mid),search(left,right,Node*2+1,mid+1,rNode));
	}
	
	

}
