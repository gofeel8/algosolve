import java.util.*;
import java.io.*;

public class P1062 {
	public static int result;
	public static String[] words;
	public static boolean[] teach;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str;
		words = new String[N];
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
		}
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		
		teach = new boolean[26];
		
		teach['a'-'a']=true;
		teach['c'-'a']=true;
		teach['i'-'a']=true;
		teach['n'-'a']=true;
		teach['t'-'a']=true;
		
		comb(0,0,K-5);
		
		System.out.println(result);

	}

	private static void comb(int now, int idx, int total) {
		if(idx==total) {
			int cnt=0;
			for(int i=0;i<words.length;i++) {
				String str = words[i];
				boolean tf = true;
				for(int j=0;j<str.length();j++) {
					char alpa = str.charAt(j);
					if(teach[alpa-'a']==false) {
						tf =false;
						break;
					}
				}
				if(tf)cnt++;
			}
			if(cnt>result)result=cnt;
			
			return;
		}
		
		for(int i=now;i<26;i++) {
			if(teach[i])continue;
			
			teach[i]=true;
			comb(i+1,idx+1,total);
			teach[i]=false;
		}
	}

}
