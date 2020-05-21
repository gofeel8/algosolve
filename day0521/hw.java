import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] alpa;
	private static int N;
	private static int K;
	private static String[] words;
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
		}
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		alpa=new boolean[27];
		alpa['a'-'a']=true;
		alpa['n'-'a']=true;
		alpa['t'-'a']=true;
		alpa['i'-'a']=true;
		alpa['c'-'a']=true;
		
		comb(alpa,5,0);
		System.out.println(result);

	}
	private static void comb(boolean[] alpa, int i,int now) {
		if(i==K) {
			// 문자 카운
			int cnt = match(alpa);
			if(cnt>result)result=cnt;
			return;
		}else if(now>25) {
			return;
		}
		
		if(alpa[now]==true) {
			comb(alpa,i,now+1);
		}else {
			alpa[now]=true;
			comb(alpa,i+1,now+1);
			alpa[now]=false;
			comb(alpa,i,now+1);
		}
		
		
		
	}
	private static int match(boolean[] alpa) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			boolean ck = true;
			for(int j=0;j<words[i].length();j++) {
				if(alpa[words[i].charAt(j)-'a']==false){
					ck = false;
					break;
				}
			}
			if(ck) {
				cnt++;
			}
			
		}
		return cnt;
	}

}
