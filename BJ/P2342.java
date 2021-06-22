import java.io.*;
import java.util.*;
public class P2342 {
	public static List<Integer> list;
	public static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<Integer>();
		dp = new int[100001][5][5];
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0)break;
			list.add(num);
		}
		for(int i=0;i<100001;i++) {
			for(int j=0;j<5;j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		int ans = dfs(0,0,0);
		System.out.println(ans);
	}
	
	
	private static int dfs(int step, int left, int right) {
		if(step==list.size())return 0;
		if(dp[step][left][right]!=-1)return dp[step][left][right]; 
		int next = list.get(step);
		
		int leftTmp = dfs(step+1,next,right)+score(left,next);
		int rightTmp = dfs(step+1,left,next)+score(right,next);
		
		return dp[step][left][right] = Math.min(leftTmp, rightTmp);
	}


	public static int score(int oldPos,int newPos) {
		if(oldPos==0) {
			return 2;
		}
		int tmp = Math.abs(newPos-oldPos);
		if(tmp ==0) {
			return 1;
		}else if(tmp == 1 || tmp==3) {
			return 3;
		}else {
			return 4;
		}
	}

}
