import java.io.*;
import java.util.*;
public class P2473 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE;
		int[] minArr = new int[3];
		
		for(int fix = N-1;fix>=0;fix--) {
			int left = 0;
			int right = fix-1;
			while(left<right) {
				long tmp = (long)arr[left]+arr[right]+arr[fix];
				if(min > Math.abs(tmp)) {
					min = Math.abs(tmp);
					minArr[0] = arr[fix];
					minArr[1] = arr[left];
					minArr[2] = arr[right];
				}
				
				if(tmp >0) {
					right--;
				}
				else {
						left++;
				}
			}
		}
		Arrays.sort(minArr);
		for(int i=0;i<3;i++) {
			System.out.print(minArr[i]+" ");
		}
		
	}

}
