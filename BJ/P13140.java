import java.util.*;
import java.io.*;

public class P13140 {
	public static int N,num1,num2;
	public static boolean odd;
	public static int[] arr;
	public static int[] alpha;
	public static boolean[] used;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		alpha = new int[7];
		used = new boolean[10];
		if(dfs(0)==false) {
			System.out.println("No Answer");
		}

	}

	private static boolean dfs(int idx) {
		if(idx == 7) {
			num1 = alpha[2]*10000 + alpha[1]*1000 + alpha[3]*100+  alpha[3]*10 + alpha[4];
			num2 = alpha[6]*10000 + alpha[4]*1000 + alpha[5]*100+  alpha[3]*10 + alpha[0];
			if(num1+num2==N) {
				System.out.println("  "+num1);
				System.out.println("+ "+num2);
				System.out.println("-------");
				System.out.println(String.format("%7d", num1+num2));
				return true;
			}
			
			return false;
		}
		
		for(int i=0;i<10;i++) {
			if((idx==2 || idx==6) && i==0)continue;
			if(used[i])continue;
			used[i]=true;
			alpha[idx]=i;
			if(dfs(idx+1))return true;
			used[i]=false;
		}
		
		return false;
		
	}

}
