import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC= sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int N = sc.nextInt();
			long sum = 0;
			for(long i=1;i<=N;i++) {
				sum += pow(i,i);
			}
			System.out.println("#"+tc+" "+sum%1000000007);
			
		}

	}
	
	static long pow(long n,long e) {
		if(e==1)
			return n;
		
		if(e%2 == 0) {
			long half =pow(n,e/2);
			return (half%1000000007*half%1000000007)%1000000007;
		}else {
			long half =pow(n,e/2);
			return (half%1000000007*half%1000000007*n)%1000000007;
		}
	}

}