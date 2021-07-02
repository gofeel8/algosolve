import java.io.*;
import java.util.*;
public class P2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		String N =st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int ans =0;
		int idx=0;
		
		for(int i=N.length()-1;i>=0;i--) {
			int now =0;
			if(Character.isAlphabetic(N.charAt(i))) {
				now = N.charAt(i)-'A'+10;
			}else {
				now = N.charAt(i)-'0';
			}
			ans+=(int)Math.pow(B, idx++)*now;
		}
		System.out.println(ans);
		
		
	}

}
