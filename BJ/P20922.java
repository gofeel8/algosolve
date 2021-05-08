import java.util.*;
import java.io.*;

public class P20922 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		map.put(arr[0], 1);
		int answer =0;
		int left = 0;
		for(int i=1;i<N;i++) {
			int num = arr[i];
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				if(map.get(num)==K) {
					while(arr[left]!=num) {
						map.put(arr[left],map.get(arr[left])-1);
						left++;
					}
					map.put(arr[left],map.get(arr[left])-1);
					left++;
				}
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			answer = Math.max(answer, i-left+1);
		}
		System.out.println(answer);

	}

}
