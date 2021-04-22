import java.util.*;
import java.io.*;

public class P1644 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> prime = new ArrayList();
		
		boolean[] nonPrime = new boolean[N+1];
		for(int i=2;i<=N;i++) {
			if(nonPrime[i]==true) {
				continue;
			}
			prime.add(i);
			for(int j=i+i;j<=N;j=j+i) {
				nonPrime[j]=true;
			}
		}
		
		int Lidx = 0;
		int Ridx = 0;
		if(prime.size()==0) {
			System.out.println(0);
			return;
		}
		int sum = prime.get(Lidx);
		
		int answer = 0;
		while(Lidx<=Ridx) {
			if(sum == N) {
				answer++;
				sum-=prime.get(Lidx);
				Lidx++;
			}else if(sum<N) {
				Ridx++;
				if(Ridx==prime.size())break;
				sum+=prime.get(Ridx);
			}else if(sum>N) {
				sum-=prime.get(Lidx);
				Lidx++;
			}
		}
		System.out.println(answer);
	
	}

}
