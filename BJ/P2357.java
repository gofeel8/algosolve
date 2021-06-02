import java.io.*;
import java.util.*;
public class P2357 {
	
	public static int[] maxTree,minTree,arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		maxTree = new int[4*N];
		minTree = new int[4*N];
		
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		maxInit(1,1, N);
		minInit(1, 1, N);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(minSearch(start, end, 1, 1, N)+" "+maxSearch(start, end, 1, 1, N));
		}
		

	}

	public static int maxInit(int node, int nodeleft, int noderight) {
		if(nodeleft == noderight) {
			maxTree[node] = arr[nodeleft];
			return maxTree[node];
		}
		int mid = (nodeleft+noderight)/2;
		return maxTree[node] = Math.max(maxInit(node*2, nodeleft, mid),maxInit(node*2+1,mid+1,noderight));
	}
	
	public static int maxSearch(int start,int end,int node,int nodeL, int nodeR) {
		if(start>nodeR || end<nodeL)return -1;
		if(start<=nodeL && nodeR <=end)return maxTree[node];
		int mid =(nodeL+nodeR)/2;
		return Math.max(maxSearch(start, end, node*2, nodeL, mid), maxSearch(start, end, node*2+1, mid+1,nodeR));
	}
	
	
	public static int minInit(int node, int nodeleft, int noderight) {
		if(nodeleft == noderight) {
			minTree[node] = arr[nodeleft];
			return minTree[node];
		}
		int mid = (nodeleft+noderight)/2;
		return minTree[node] = Math.min(minInit(node*2, nodeleft, mid),minInit(node*2+1,mid+1,noderight));
	}
	
	public static int minSearch(int start,int end,int node,int nodeL, int nodeR) {
		if(start>nodeR || end<nodeL)return Integer.MAX_VALUE;
		if(start<=nodeL && nodeR <=end)return minTree[node];
		int mid =(nodeL+nodeR)/2;
		return Math.min(minSearch(start, end, node*2, nodeL, mid), minSearch(start, end, node*2+1, mid+1,nodeR));
	}

}
