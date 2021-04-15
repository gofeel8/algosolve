import java.io.*;
import java.util.*;

public class P1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] checked = new boolean[(int) (max-min+1)];
	
		for(long i=2;i*i<=max;i++) {
			long db = i*i;
			long x =min/db;
			if(x*db!=min)x++;
			for(long j=x;(j*db)<=max;j++) {
				long num = (j*db)-min;
				checked[(int)(num)]=true;
			}
		}
		int answer = 0;
		for(int i=0;i<checked.length;i++) {
			if(!checked[i])answer++;
		}
		System.out.println(answer);
	}
}
