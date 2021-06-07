import java.io.*;
import java.util.*;
public class P2143 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] brr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Long,Long> amap  =new HashMap<Long, Long>();
		for(int i=0;i<N;i++) {
			long now = arr[i];
			amap.put(now, amap.getOrDefault(now, (long) 0)+1);
			long sum = now;
			for(int j=i+1;j<N;j++) {
				sum += arr[j];
				amap.put(sum, amap.getOrDefault(sum, (long) 0)+1);
			}
		}
		
		Map<Long,Long> bmap  =new HashMap<Long, Long>();
		for(int i=0;i<M;i++) {
			long now = brr[i];
			bmap.put(now, bmap.getOrDefault(now, (long) 0)+1);
			long sum = now;
			for(int j=i+1;j<M;j++) {
				sum += brr[j];
				bmap.put(sum, bmap.getOrDefault(sum, (long) 0)+1);
			}
		}
		
		long ans = 0;
		for(long now : amap.keySet()) {
			long tmp =T - now;
			if(bmap.containsKey(tmp)) {
				ans += (amap.get(now)*bmap.get(tmp));
			}
		}
		System.out.println(ans);
		
	}

}
