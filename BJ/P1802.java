import java.io.*;
import java.util.*;

public class P1802 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t= 0; t<TC;t++) {
			String str = br.readLine();
			if(search(str)) {
				bw.write("YES");
			}else {
				bw.write("NO");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	
		
	}

	private static boolean search(String str) {
		if(str.length()==1) {
			return true;
		}
		
		int half = str.length()/2;
		
		for(int i=0;i<half;i++) {
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		
		
		return search(str.substring(0,half));
	}
}
