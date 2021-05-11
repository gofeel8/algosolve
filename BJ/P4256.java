import java.io.*;
import java.util.*;
public class P4256 {
	public static BufferedWriter bw;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] pre = new int[N];
			int[] in = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] used = new boolean[N+1];
			search(1,pre,in,0,in.length-1,used);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}


	private static void search(int idx, int[] pre, int[] in, int left, int right ,boolean[] used) throws IOException {
		int memo  =0;
		boolean find = false;
		for(int i=0;i<pre.length;i++) {
			if(used[i])continue;
			for(int j=left;j<=right;j++) {
				if(in[j] == pre[i]) {
					memo= j;
					used[i]=true;
					find = true;
					break;
				}
			}
			if(find)break;
		}
		
		if(left<=memo-1) {
			search(idx*2, pre, in, left,memo-1,  used);
		}
		if(memo+1<=right) {
			search(idx*2+1, pre, in, memo+1 ,right,  used);
		}
		bw.write(in[memo]+" ");
	}

}
