import java.util.*;
import java.io.*;

public class P2263 {
	public static int[] in,post,idx;
	public static int N;
	public static boolean[] used;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer  st = new StringTokenizer(br.readLine());
		in = new int[N+1];
		post = new int[N+1];
		idx  = new int[N+1];
		used =new boolean[N+1];
		for(int i=0;i<N;i++) {
			int num =Integer.parseInt(st.nextToken());
			in[i+1]=num;
			idx[num]=i+1;
		}
		
		st = new StringTokenizer(br.readLine());
			
		for(int i=0;i<N;i++) {
			post[i+1]=Integer.parseInt(st.nextToken());
		}
		
		findRoot(1, N,1,N);

		bw.flush();
		bw.close();
	}

	private static void findRoot(int istart, int iend,int pstart, int pend) throws IOException {
//		System.out.println("istart ="+istart +" iend= "+iend+" pstart="+pstart+" pend="+pend);
		if(istart>N || iend <=0 ||pstart>N || pend <=0 )return;
		int num = post[pend];
		if(used[num])return;
		bw.append(num +" ");
//		System.out.print(num +" ");
		used[num]=true;
		//왼쪽
		findRoot(istart, idx[num]-1, pstart, pstart+(idx[num]-1-istart));
		//오른쪽
		findRoot(idx[num]+1, iend, pstart+(idx[num]-istart), pend-1);
	}

}
