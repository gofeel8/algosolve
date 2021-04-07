import java.io.*;
import java.util.*;

public class P1022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0;
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
			 max =Math.max(max, calc(i,j));
			}
		}
		int size = (int)Math.log10(max)+1;
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
			 int now = calc(i,j);
			 for(int k=(int)Math.log10(now)+1;k<size;k++) {
				 bw.append(" ");
			 }
			 bw.write(String.valueOf(now)+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}

	private static int calc(int r, int c) {
		int gap = Math.max(Math.abs(r), Math.abs(c));
		
		int num = (int) Math.pow((2*gap)+1, 2);
		if(r==gap) {
			return num - (gap-c);
		}
		num = num - (2*gap);
		if(c==gap*-1) {
			return num - (gap-r);
		}
		num = num - (2*gap);
		if(r==-1*gap) {
			return num - (gap+c);
		}
		num = num - (2*gap);
		
		return num -(gap+r);
	}

}
	
