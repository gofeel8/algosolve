import java.util.*;
import java.io.*;

public class P14600 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] one = new int[2][2];
		Arrays.fill(one[0], 1);
		Arrays.fill(one[1], 1);
		
		int xlevel = x/2;
		int ylevel = y/2;
		
		one[1-(y%2)][x%2]=-1;
		
		if(K==1) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					bw.write(String.valueOf(one[i][j])+ " ");
				}
				bw.newLine();
			}
		}else {
			int pos = 0;
			if(xlevel==0 && ylevel==0)pos =0;
			else if(xlevel==0 && ylevel==1)pos =3;
			else if(xlevel==1 && ylevel==0) pos =1;
			else pos =2;
			
			int[][] three = {{2,2,3,3},{2,4,4,3},{0,0,4,5},{0,0,5,5}};
			for(int i=0;i<pos;i++) {
				three = rotate(three);
			}
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(three[i][j]==0) {
						three[i][j] = one[0][0];
						three[i][j+1] = one[0][1];
						three[i+1][j] = one[1][0];
						three[i+1][j+1] = one[1][1];
						break;
					}
				}
			}
			
			for(int i=0;i<4;i++) {
					for(int j=0;j<4;j++) {
						bw.write(String.valueOf(three[i][j])+ " ");
					}
					bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		

	}

	private static int[][] rotate(int[][] three) {
		int[][] rt = new int[4][4];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				rt[i][j] = three[j][3-i];
			}
		}
		
		return rt;
	}

}
