import java.util.*;
import java.io.*;

public class P2352 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
			int left=0, right=list.size()-1;
			int idx =0;
			while(left<=right) {
				int mid = (left+right)/2;
				
				if(list.get(mid)<arr[i]) {
					idx = mid;
					left = mid+1;
				}else if(list.get(mid)>arr[i]) {
					right = mid-1;
				}else {
					idx = idx-1;
					break;
				}
			}
			idx++;
			if(list.size()==idx) {
				list.add(arr[i]);
			}else {
				int tmp = list.get(idx);
				if(tmp>arr[i]) {
					list.remove(idx);
					list.add(idx,arr[i]);
				}
			}
			
		}
		
		System.out.println(list.size()-1);
		

	}

}
