import java.io.*;
import java.util.*;

public class P16954 {
	public static int[] dr = {-1,-1,0,1,1,1,0,-1,0};
	public static int[] dc = {0,1,1,1,0,-1,-1,-1,0};
	

	public static void main(String[] args) throws IOException {
		boolean[][] wall = new boolean[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int cnt=0;
		for(int i=0;i<8;i++) {
			str =br.readLine();
			for(int j=0;j<8;j++) {
				if(str.charAt(j)=='#') {
					wall[i][j]=true;
					cnt++;
				}
			}
		}
		
		
		Queue<int []>queue = new LinkedList<int[]>();
		queue.add(new int[] {7,0});
		
		for(int i=0;i<8;i++) {  //8판만 참으면된다
			int size = queue.size();
			
			if(size==0) {
				System.out.println(0);
				return;
			}
			
			for(int j=0;j<size;j++) {
				int[] now =queue.poll();
				if(wall[now[0]][now[1]]==true) {
					continue;
				}
				
				if(now[0]==0 && now[1]==7) {
					System.out.println(1);
					return;
				}
				
				
				
				
				for(int d=0;d<9;d++) {
					int nr =now[0]+dr[d];
					int nc =now[1]+dc[d];
					if(nr<0 || nr>= 8 || nc<0 || nc>=8)continue;
					if(wall[nr][nc]==true)continue;
					queue.add(new int[] {nr,nc});
					
				}
				
				
				
			}
			
			
			//벽 내리기
			for(int k=7;k>=0;k--) {
				for(int q=0;q<8;q++) {
					if(k==0) {
						wall[k][q]=false;
						cnt--;
					}else {
						if(wall[k-1][q]==true) {
							wall[k-1][q]=false;
							wall[k][q]=true;
						}
					}
				}
			}
			
			if(cnt==0) {
				System.out.println(1);
				return;
			}
			
		}
		
		if(queue.size()==0) {
			System.out.println(0);
			return;
		}
		System.out.println(1);
		
		

	}

}
