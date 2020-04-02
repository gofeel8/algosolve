import java.util.Scanner;
public class Solution {
	static int p;
	static long[] mem;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mem = new long[1000000+1];
		p = 1234567891;
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
		int N = sc.nextInt();
		int R = sc.nextInt();
		
        mem[0] = 1;	
        for (int i = 1; i <= N; i++) mem[i] = (mem[i - 1] * i) % p;
        
        System.out.println("#"+tc+" "+(mem[N] * ((compute(mem[N - R],p-2) * compute(mem[R],p-2)) % p)) % p);
		}
	}

	public static long compute(long n,int u) {
		if(u==1)return n;
		long temp =compute(n, u/2);
		if(u%2==0) {
			return (temp*temp)%p;
		}else {
			return (temp*compute(n, u/2+1))%p;
		}
	}
	

}
