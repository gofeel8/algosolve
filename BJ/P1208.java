import java.util.*;
import java.io.*;
public class P1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int S  = Integer.parseInt(st.nextToken());
		long  answer = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int half = N/2;
		
		int[] left = Arrays.copyOfRange(arr, 0, half);
		int[] right= Arrays.copyOfRange(arr, half, arr.length);
		
		List<Integer> leftList = new ArrayList<Integer>();
		
		int now=1;
		while(now<Math.pow(2, left.length)) {
			int sum =0;
			for(int i=0;i<left.length;i++) {
				if(((1<<i)&now) != 0) {
					sum += left[i];
				}
			}
			if(sum==S)answer++;
			leftList.add(sum);
			now++;
		}
		
		List<Integer> rightList = new ArrayList<Integer>();
			
			now=1;
			while(now<Math.pow(2, right.length)) {
				int sum =0;
				for(int i=0;i<right.length;i++) {
					if(((1<<i)&now) != 0) {
						sum += right[i];
					}
				}
				if(sum==S)answer++;
				rightList.add(sum);
				now++;
			}
			
		
		Collections.sort(leftList);
		Collections.sort(rightList);
		
		int Lidx = 0;
		int Ridx = rightList.size()-1;
		
		while(Lidx<leftList.size() && Ridx>=0) {
			int sum = leftList.get(Lidx)+rightList.get(Ridx);
			if(sum>S) {
				Ridx--;
			}else if( sum<S) {
				Lidx++;
			}else {
				long lc = 0;
			       int lv = leftList.get(Lidx);
	                while(Lidx<leftList.size() && leftList.get(Lidx) == lv) {
	                    lc++;
	                    Lidx++;
	                }

	                int rv = rightList.get(Ridx);
	                long rc = 0;
	                while(Ridx>=0 && rightList.get(Ridx) == rv) {
	                    rc++;
	                    Ridx--;
	                }
	                answer+=lc*rc;
			}
			
		}

		
		System.out.println(answer);
	}

}
