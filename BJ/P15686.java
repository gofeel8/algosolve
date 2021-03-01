import java.util.*;
import java.io.*;


public class P15686 {
	public static int N;
	public static int M;
	public static List<int []> chicken;
	public static List<int []> home;
	public static int [] selected;
	public static int result ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		result = Integer.MAX_VALUE;
		selected = new int[M];
		
		for(int i=1;i<=N;i++) {
			st = new  StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num =Integer.parseInt(st.nextToken());
				if(num == 1) {
					home.add(new int[] {i,j});
				}else if(num ==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		comb(0,0);
		System.out.println(result);
		
	}



	private static void comb(int now, int idx) {
		if(idx == M) {
			//거리 계산
//			System.out.println(Arrays.toString(selected));
			int sum = 0;
			for(int i=0;i<home.size();i++) {
				int min=Integer.MAX_VALUE;
				int[] hpos = home.get(i);
				for(int j=0;j<selected.length;j++) {
					int[] cpos = chicken.get(selected[j]);
					int dist = Math.abs(hpos[0]-cpos[0])+Math.abs(hpos[1]-cpos[1]);
					min = Math.min(min, dist);
				}
				sum +=min;
			}
			//기록 갱싱
			if(result>sum)result = sum;
			return;
		}
		
		
		for(int i=now;i<chicken.size();i++) {
			selected[idx]=i;
			comb(i+1,idx+1);
		}
		
	}

}
