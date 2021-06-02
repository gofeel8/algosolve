import java.io.*;
import java.util.*;
public class P2042 {

	public static long[] tree;
	public static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());    // 수의 개수
		int M = Integer.parseInt(st.nextToken());   // 변경횟수
		int K = Integer.parseInt(st.nextToken());   //합 구하는 횟수
		tree =new long[N*4];
		arr = new long[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1,1,N);
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			long c= Long.parseLong(st.nextToken());
			
			if(a==1) {    // b번째 수를 c로 바꿈
				update(b,arr[b],c,1,1,N);
				arr[b]=c;
			}else {     //b 부터 c까지의 합을 출력 
				long num =search(b, c, 1, 1, N);
				bw.write(String.valueOf(num));
				bw.newLine();
//				System.out.println(search(b, c, 1, 1, N));
			}
		}
		bw.flush();
		bw.close();

	}
	
	public static long init(int idx,int left,int right) {
		if(left==right) {
			tree[idx] = arr[left];
			return tree[idx];
		}
		int mid = (left+right)/2;
		tree[idx] = init(idx*2,left,mid)+init(idx*2+1,mid+1,right);
		return tree[idx];
	}
	
	public static void update(long idx, long ov , long nv, int Node, int NodeL, int NodeR) {
		if(NodeL>idx || NodeR<idx)return;
		if(NodeL == NodeR) {
			tree[Node]=nv;
			return;
		}
		tree[Node]-=ov;
		tree[Node]+=nv;
		
		int mid = (NodeL+NodeR)/2;
		update(idx,ov,nv,Node*2,NodeL,mid);
		update(idx,ov,nv,Node*2+1,mid+1,NodeR);
	}
	
	public static long search(long left,long right,int Node, int NodeL, int NodeR) {
		if(right<NodeL || left>NodeR) return 0;
		
		if(left<=NodeL && NodeR<=right) {
			return tree[Node];
		}
		
		int mid = (NodeL+NodeR)/2;
		return search(left,right,Node*2,NodeL,mid)+search(left,right,Node*2+1,mid+1,NodeR);
	}

}
