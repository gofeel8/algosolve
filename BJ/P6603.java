import java.util.*;
import java.io.*;

public class P6603 {

	static int[] arr;
	static int[] selected;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int num = Integer.parseInt(st.nextToken());
			if(num ==0)break;
			arr = new int[num];
			selected = new int[6];
			
			for(int i=0;i<num;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			
			comb(0,0);
			System.out.println();
		}
		bw.close();
	}
	
	public static void comb(int now,int idx) throws IOException {
		if(idx==6) {
//			System.out.println(Arrays.toString(selected));
			for(int i=0;i<6;i++) {
				bw.write(selected[i]+" ");
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		for(int i=now;i<arr.length;i++) {
			selected[idx]=arr[i];
			comb(i+1,idx+1);
		}
	}

}
