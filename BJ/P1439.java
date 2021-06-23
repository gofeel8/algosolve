import java.io.*;
import java.util.*;

public class P1439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] cnt = new int[2];
		
		char now =  str.charAt(0);
		cnt[0]++;
		
		int idx=0;
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)!=now) {
				now = str.charAt(i);
				idx = (idx+1)%2;
				cnt[idx]++;
			}
		}
		System.out.println(cnt[1]);

	}

}
