import java.util.*;
import java.io.*;


public class P9663 {

	static int N;
	static int result;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		queen(0);
		System.out.println(result);
	}

	private static void queen(int floor) {
		if(floor==N) {
			result ++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[floor]=i;
			if(isOK(floor,i)) {
				queen(floor+1);
			}
		}
		
	}

	private static boolean isOK(int floor, int idx) {
		if(floor>0) {
			for(int i=0;i<floor;i++) {
				if(arr[i]==arr[floor])return false;
				if(Math.abs(i-floor)==Math.abs(arr[i]-arr[floor])) return false;
			}
		}
		return true;
	}

	

}
