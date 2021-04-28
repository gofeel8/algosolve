import java.io.*;
import java.util.*;

public class P14476 {
	public static int[] tree,arr;
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		tree = new int[1<<21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1,N,1);
		
		int max=0,maxIdx=0;
		
		int gcd=-1;
		for(int i=1;i<=N;i++) {
			int a = search(1,i-1,1,1,N);
			int b = search(i+1,N,1,1,N);
			if(a!=-1 && b!=-1) {
				gcd = GCD(a,b);
			}else if(a==-1) {
				gcd = b;
			}else {
				gcd =a;
			}
			if(arr[i]%gcd==0) {
				continue;
			}
			
			if(gcd>max) {
				max = gcd;
				maxIdx=i;
			}
		}
		if(max!=0) {
			System.out.println(max+" "+arr[maxIdx]);
		}else {
			System.out.println(-1);
		}

	}
	
	public static int init(int left,int right,int Node) {
		if(left==right) {
			tree[Node]=arr[left];
			return tree[Node];
		}
		int mid = (left+right)/2;
		tree[Node]=GCD(init(left,mid,Node*2),init(mid+1,right,Node*2+1));
		return tree[Node];
	}
	
	public static int search(int left,int right,int Node , int nleft, int nright) {
		if(left>nright || right < nleft) return -1;
		if(left <= nleft && right >= nright) return tree[Node];
		
		int mid = (nleft+nright)/2;
		int a = search(left,right,Node*2,nleft,mid);
		int b = search(left,right,Node*2+1,mid+1,nright);
		if(a!= -1 && b != -1) {
			return GCD(a,b);
		}else if(a==-1) {
			return b;
		}else {
			return a;
		}
	}
	
	public static int GCD(int a,int b) {
		if(b>a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if(a%b==0) {
			return b;
		}
		
		return GCD(b,a%b);
	}

}
