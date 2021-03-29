import java.util.*;
import java.io.*;

public class P2661 {
	public static int N;
	public static boolean finish;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str="";
		dfs(str,0);
		
	}

	private static void dfs(String str, int idx) {
		if(finish) {
			return;
		}
		if (idx == N) {
			System.out.println(str);
			finish=true;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			String tmp = str+Integer.toString(i);
			if(check(tmp)) {
				dfs(tmp,idx+1);
			}
		}
		
	}

	private static boolean check(String tmp) {
		if(tmp.length()==1)return true;
		int start = tmp.length()-1;
		int end = tmp.length();
		
		
		while(start>=end/2) {
			String str1 = tmp.substring(start,end);
			if(start-(end-start)<0)break;
			String str2 = tmp.substring(start-(end-start),start);
			if(str1.equals(str2)) {
				return false;
			}
			start--;
		}
		return true;
	}

}
