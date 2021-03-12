import java.io.*;
import java.util.*;

public class P1747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(true) {
			if(isDrom(N)&&isPrime(N)) {
				System.out.println(N);
				return;
			}
			N=N+1;
			
		}
		
	}
	
	
	public static boolean isDrom(int num) {
		String str = Integer.toString(num);
		
		int start = 0;
		int end =str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start ++;
			end --;
		}
	
		return true;
	}
	
	public static boolean isPrime(int num) {
		if(num==1) return false;
		if(num==2||num==3||num==5||num==7)return true;
		if(num%2==0)return false;
		if(num%3==0)return false;
		
		for(int i=3;i<=Math.sqrt(num);i=i+2) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	

}
