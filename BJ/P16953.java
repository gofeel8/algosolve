import java.util.*;
import java.io.*;

public class P16953 {
	public static Map<Long,Long> Map;
	public static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		Map = new HashMap<Long, Long>();
		result = Long.MAX_VALUE;
		dfs(A,0,B);
		System.out.println(result == Long.MAX_VALUE  ? -1 : result+1);
	}

	private static void dfs(long now,long cnt, long B) {
		if(now==B) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(now>B) {
			return;
		}
		
		long num1 = now*2;
		long num2 = now*10+1;
		
		if(!(Map.containsKey(num1) && cnt>Map.get(num1))) {
			Map.put(num1, cnt);
			dfs(num1,cnt+1,B);
		}
		if(!(Map.containsKey(num2) && cnt>Map.get(num2))) {
			Map.put(num2, cnt);
			dfs(num2,cnt+1,B);
		}
		
		
	}

}
