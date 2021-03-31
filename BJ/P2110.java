import java.util.*;
import java.io.*;
public class P2110 {
	public static int[] home;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		home = new int[N];
		for(int i=0;i<N;i++) {
			home[i]=Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);
		
		int rt =0;
		
		int left=1;
		int right = home[N-1];
		
		while(left<=right) {
			int mid = (left+right)/2;
			//mid 로 집을 지을 수 있는가
			int now = home[0];
			int cnt=1;
			for(int i=1;i<N;i++) {
				if(home[i]-now>=mid) {
					cnt++;
					now=home[i];
				}
			}			
			if(cnt<C) {
				//지을 수 없으면
				right = mid-1;
				
			}
			else {
			//지을 수 있다면
				rt = mid;
				left=mid+1;
			}
		}
		
		System.out.println(rt);
		
		
	}
	
	

}
