import java.io.*;
import java.util.*;

public class P1789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long sum=0;
		long now=1;
		while(sum<N) {
			sum+=now;
			now++;
		}
		now--;
		if(sum==N) {
			System.out.println(now);
		}else {
			System.out.println(now-1);
		}
		
	}

}
