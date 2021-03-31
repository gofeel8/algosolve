import java.util.*;
import java.io.*;

public class P17281 {
	public static int[] turn;
	public static boolean[] used;
	public static int answer,N;
	public static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N][10];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		answer =Integer.MIN_VALUE;
		turn = new int[10];
		used = new boolean[10];
		used[1]=true;
		turn[4]=1;
		perm(1);
		System.out.println(answer);

	}

	private static void perm(int idx) {
		if(idx==10) {
//			System.out.println(Arrays.toString(turn));
			
			int nowIdx = 1;
			int sum=0;
			for(int i=0;i<N;i++) {
				int out=0;
				boolean[] pos =new boolean[4];
				
				while(out!=3) {
					pos[0]=true;
					int num = arr[i][turn[nowIdx++]];
					if(nowIdx==10)nowIdx=1;
					if(num==0) {
						out++;
						continue;
					}
					
					for(int j=3;j>=0;j--) {
						if(pos[j]) {
							if(j+num>=4) {
								sum++;
								pos[j]=false;
							}else {
								pos[j+num]=true;
								pos[j]=false;
							}
						}
					}
					
					
				}
				
			}
			if(sum>answer)answer=sum;
			
			return;	
		}
		
		if(idx==4) {
			perm(idx+1);
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(used[i]==false) {
				used[i]=true;
				turn[idx]=i;
				perm(idx+1);
				used[i]=false;
			}
		}
		
	}

}
