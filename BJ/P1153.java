import java.io.*;
import java.util.*;

public class P1153 {

	public static List<Integer> primeList;
	public static int[] selected;
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N<8) {
			System.out.println("-1");
			return;
		}
		
		BufferedWriter bw = new  BufferedWriter(new OutputStreamWriter(System.out));
		if(N%2==0) { //짝수다
			bw.append("2 2 ");
			N-=4;
		}else { // 홀수다
			bw.append("2 3 ");
			N-=5;
		}
		
		int start = N/2;
		for(int i=start;i<N;i++) {
			if(isprime(i)) {
				for(int j=start;j>1;j--) {
					if(i+j==N && isprime(j)) {
						//찾았다
						bw.append(i+" "+j);
						bw.flush();
						bw.close();
						return;
					}
					
					
				}
			}
		}
		

	}

	private static boolean isprime(int num) {
		if(num<2)return false;
		if(num ==2 ) return true;
		if(num%2==0)return false;
		
		for(int i=3;i<num;i=i+2) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}


}
