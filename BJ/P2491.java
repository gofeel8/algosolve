import java.io.*;
import java.util.*;

public class P2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		int[] up = new int[N];
		int[] down = new int[N];
		
		int ans = 1;
		for(int i=0;i<N;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
			if(i==0) {
				up[i]=1;
				down[i]=1;
			}else { 
					//up
					if(arr[i]>=arr[i-1]) {
						up[i]=up[i-1]+1;
					}else {
						up[i]=1;
					}
					ans = Math.max(ans, up[i]);
					//down
					if(arr[i]<=arr[i-1]) {
						down[i]=down[i-1]+1;
					}else {
						down[i]=1;
					}
					ans = Math.max(ans, down[i]);
			}
		}
		
		System.out.println(ans);
		
		
		

	}

}
