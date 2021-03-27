import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1756 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D =Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		List<int []> list = new ArrayList<int []>();
		
		
		st =new StringTokenizer(br.readLine());
		
		list.add(new int [] {Integer.parseInt(st.nextToken()),1,0});
		int now = list.get(0)[0];
		int nowIdx=0;
		for(int i=1;i<D;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>=now) {
				list.get(nowIdx)[1]++;
			}else {
				list.add(new int[] {num,1,i});
				now=num;
				nowIdx++;
			}
		}
		
		int cnt = D;
		
		st =new StringTokenizer(br.readLine());
		
		if(N>D) {
			System.out.println(0);
			return;
		}
		
		int prev = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(list.size()==0) {
				System.out.println(0);
				return;
			}
			
			if(num<=prev) {
				list.get(list.size()-1)[1]--;
				cnt--;
				if(list.get(list.size()-1)[1]==0) {
					list.remove(list.size()-1);
				}	
			}else {
				
				int left = 0;
				int right = list.size()-1;
				int idx = 0;
				while(left<=right) {
					int mid = (left+right)/2;
					idx = mid;
					
					if(list.get(mid)[0]>=num) {
						left = mid+1;
					}else if(list.get(mid)[0]<num) {
						right = mid-1;
						idx = right;
					}else if (list.get(mid)[0]==num){
						break;
					}
				}
				
				if(idx==-1) {
					System.out.println(0);
					return;
				}else {
					if(idx+1<list.size()) {
						cnt=list.get(idx+1)[2];
						while(list.size()!=idx+1)
							list.remove(list.size()-1);
					}
					list.get(idx)[1]--;
					cnt--;
					if(list.get(idx)[1]==0) {
						list.remove(idx);
					}
				}
			}
			prev = num;
		}
		
		System.out.println(cnt+1);
	

	}

}
