import java.io.*;
import java.util.*;


public class P8983 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M  =Integer.parseInt(st.nextToken());
		int N  =Integer.parseInt(st.nextToken());
		int L  =Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int cnt =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			//x에 가까운 사대 찾기
			
			int left = 0;
			int right = M-1;
			int ans = 0;
			while(left<=right) {
				int mid = (left+right)/2;
				if(arr[mid]<x) {
					ans=mid;
					left= mid+1;
				}else if(arr[mid]>x) {
					right = mid-1;
				}else {
					ans = mid;
					break;
				}
			}
			
			if(ans < M-1) {
				if((arr[ans+1]-x) < (x-arr[ans])) {
					ans = ans+1;
				}
			}
			
			int dist = (y-0) + Math.abs(x-arr[ans]);
			if(dist <= L)cnt++;
		}
		System.out.println(cnt);

	}

}
