import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		final int Max = 10000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [][] map = new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(map[i],Max);
			map[i][i]=0;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			if(map[s][e]>time) {
				map[s][e]=time;
			}
		}
		for(int a=1;a<=n;a++) {//경유 
			for(int b=1;b<=n;b++) { //출발
				if(a==b)continue;
				for(int c=1;c<=n;c++) {//도착
					if(b==c)continue;
					if(map[b][c]>map[b][a]+map[a][c]) {
						map[b][c]=map[b][a]+map[a][c];
					}
				}
			}
			
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==Max)map[i][j]=0;
				bw.write(String.valueOf(map[i][j])+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}


}
