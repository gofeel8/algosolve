import java.io.*;
import java.util.*;
public class P3151 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num, map.getOrDefault(num, 0)+1);
		}

		Arrays.sort(arr);
		
		long ans = 0;
		
		for(int fix = N-1;fix>=0;fix--) {
			map.put(arr[fix], map.get(arr[fix])-1);
			int left = 0;
			int right = fix-1;
			
			while(left<right) {
				int sum = arr[fix]+arr[left]+arr[right];
				if(sum==0) {
					if(arr[left]==arr[right]) {
						//map 에서 꺼내 두개의 뽑는 경우의 수 더하고 종료시킴 
						int tmp = map.get(arr[left]);
						//tmp 에서 2개 뽑는 경우의 수 
						tmp = (tmp)*(tmp-1)/2;
						ans+=tmp;
						break;
					}else {
						//map 에서 left ,righ 각각꺼내 곱하고 더하고 포인터 적절하게 움직임
						int lc = map.get(arr[left]);
						int rc = map.get(arr[right]);
						ans += lc*rc;
						left += lc;
						right -=rc;
					}
				}else if(sum>0) {
					right --;
				}else if(sum<0) {
					left++;
				}
			}
			
		}
		System.out.println(ans);
	}

}
