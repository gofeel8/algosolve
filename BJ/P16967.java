import java.io.*;
import java.util.*;

public class P16967 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int R = H+X;
		int C = W+Y;
		int[][] arr =new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = new int[H][W];
		
		for(int i=0;i<H;i++) {
			
			for(int j=0;j<W;j++) {
				if(i-X>=0 && j-Y>=0) {
					ans[i][j] = arr[i][j]-ans[i-X][j-Y];
				}else {
					ans[i][j] = arr[i][j];
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				bw.write(String.valueOf(ans[i][j]+" "));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
