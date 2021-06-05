import java.util.*;
import java.io.*;
public class P3165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long  n = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		n++;
		for(int i=0;i<(int)Math.log10(n)+1;i++) {
			int ea = count(n);
			if(ea>=k) {
				System.out.println(n);
				return;
			}
			long pos = (long) Math.pow(10, i);
			int now = (int) ((n/pos)%10);
			if(now<5) {
				long tmp =((5-now)*pos);
				n = n+tmp;
			}else if(now ==5) {
				continue;
			}else if(now>5){
				long tmp =((10-now)*pos);
				n = n+tmp;				
				i--;
			}
		}
		
		while(count(n)!=k) {
			n*=10;
			n+=5;
		}
		System.out.println(n);
		
	}
	
	public static int count(long num) {
		String str = Long.toString(num);
		int cnt =0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='5')cnt++;
		}
		return cnt;
	}

}
