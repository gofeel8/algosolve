import java.io.*;
import java.util.*;
public class P11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> list = new ArrayList<Integer>();
		
		int[] up = new int[N];
		list.add(arr[0]);
		up[0]=1;
		for(int i=1;i<N;i++) {
			int now = arr[i];
			int memo = -1;
			for(int j=0;j<list.size();j++) {
				if(list.get(j)>=now) {
					memo = j;
					break;
				}
			}
			if(memo == -1) {
				list.add(now);
				up[i] = list.size();
			}else {
				list.remove(memo);
				list.add(memo,now);
				up[i] = memo+1;
			}
		}
		
		
		list.clear();
		int[] down = new int[N];
		list.add(arr[N-1]);
		down[N-1]=1;
		for(int i=N-2;i>=0;i--) {
			int now = arr[i];
			int memo = -1;
			for(int j=0;j<list.size();j++) {
				if(list.get(j)>=now) {
					memo = j;
					break;
				}
			}
			if(memo == -1) {
				list.add(now);
				down[i] = list.size();
			}else {
				list.remove(memo);
				list.add(memo,now);
				down[i] = memo+1;
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			if(up[i]+down[i]>max) {
				max =up[i]+down[i]; 
			}
		}
		System.out.println(max-1);
	}
}
