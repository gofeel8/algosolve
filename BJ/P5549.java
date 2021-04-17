import java.util.*;
import java.io.*;

public class P5549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] I,J,O;
		I = new int[R+1][C+1];
		J = new int[R+1][C+1];
		O = new int[R+1][C+1];
		
		
		
		int N = Integer.parseInt(br.readLine());
		String str;
		for(int i=1;i<=R;i++) {
			str =br.readLine();
			int ic=0,jc=0,oc=0;
			for(int j=0;j<C;j++) {
				char tmp = str.charAt(j);
				switch (tmp) {
				case 'I':
					ic++;
					break;
				case 'J':
					jc++;
					break;
				case 'O':
					oc++;
					break;
				}
				I[i][j+1]=I[i-1][j+1]+ic;
				J[i][j+1]=J[i-1][j+1]+jc;
				O[i][j+1]=O[i-1][j+1]+oc;
			}
		}
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int ic=0,jc=0,oc=0;
			
			//전체 - A - B +C
			
			
			ic=I[c][d] - I[c][b-1]-I[a-1][d]+I[a-1][b-1];
			jc=J[c][d] - J[c][b-1]-J[a-1][d]+J[a-1][b-1];
			oc=O[c][d] - O[c][b-1]-O[a-1][d]+O[a-1][b-1];
			
			
			bw.append(jc+" "+oc+" "+ic);
			bw.newLine();
//			System.out.println(jc+" "+oc+" "+ic);
		}
		bw.flush();
		bw.close();

	}

}
