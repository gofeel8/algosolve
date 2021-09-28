import java.io.*;
import java.util.*;

public class P7490 {
	public static PriorityQueue<String> pq; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=0;i<TC;i++) {
			pq  = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			search(1,N,"1");
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
			System.out.println();
		}
	}
	
	
	private static void search(int now, int N,String str) {
		if(now==N) {
			if(check(str)) {
				pq.add(str);
			}
			return;
		}
		//+
		search(now+1, N, str+"+"+(now+1));
		//-
		search(now+1, N, str+"-"+(now+1));
		//공백
		search(now+1, N, str+" "+(now+1));		
	}
	private static boolean check(String str) {
		int sum=0;
		int num=0;
		char prev='+';
		for(int i=0;i<str.length();i++) {
			char now =str.charAt(i);
			if(Character.isDigit(now)) {
				num = num*10+(str.charAt(i)-'0');
			}else {
				if(now ==' ')continue;
				if(prev =='+') {
					sum+=num;
				}else if(prev =='-') {
					sum-=num;
				}
				num=0;
				prev=now;
			}
		}
		if(prev =='+') {
			sum+=num;
		}else if(prev =='-') {
			sum-=num;
		}
		if(sum==0) {
			return true;
		}else {
			return false;
		}
	}

}
