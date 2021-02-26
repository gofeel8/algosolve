import java.io.*;
import java.lang.*;
import java.util.*;

public class P2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A =  Integer.parseInt(st.nextToken());
		int B =  Integer.parseInt(st.nextToken());
		int V =  Integer.parseInt(st.nextToken());
		
		int result = (V-A)/(A-B)+1;
		if((V-A)%(A-B)!=0) {
			result++;
		}
		
		
		System.out.println(result);
		
	}

}
