import java.io.*;
import java.util.*;

public class P6209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+2];
		arr[n+1]=d;
		int answer =0;
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = d;
		while(left<=right) {
			int mid = (left+right)/2;             // 최소 점프거리 mid  , 이보다 낮은거면 돌을 빼보자 
			int cnt =0;   
			for(int i=0;i<n+2;i++) {
				for(int j=i+1;j<n+2;j++) {
					if(arr[j]-arr[i]>=mid) {
						i=j-1;
						break;
					}else {
						cnt++;
					}
				}
			}
			
			if(cnt>m) {              // 최소 mid 를 뛰기 위해선 cnt만큼의 돌을 빼야한다 m보다 많으면 최소거리를 좁혀줘야한다 
				right = mid-1;
			}else {
				answer = mid;
				left=mid+1;
			}
			
		}
		System.out.println(answer);

	}

}
