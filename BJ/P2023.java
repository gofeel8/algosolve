import java.io.*;
import java.util.*;

public class P2023 {
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		
		
		calc(2,1);
		calc(3,1);
		calc(5,1);
		calc(7,1);
		

		
		
	}
	
	private static void calc(int num, int len) {
		if(len==N) {
			System.out.println(num);
			return;
		}
		
		for(int i=1;i<10;i=i+2) {
			if(isPrime(num*10+i)) {
				calc(num*10+i, len+1);
			}
		}
		
		
	}

	public static boolean isPrime(int num) {
		if(num==2 || num==3 || num==5 || num ==7)return true;
		if(num == 1) return false;
		
		if(num%2==0)return false;
		
		for(int i=3;i<=Math.sqrt(num);i=i+2) {
			if(num%i==0)return false;
		}
		
		
		return true;
	}

}
