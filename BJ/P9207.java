import java.io.*;
import java.util.*;


public class P9207 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static int MIN,MOVE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			char[][] map = new char[5][9];
			String str;
			int total= 0;
			for(int i=0;i<5;i++) {
				str = br.readLine();
				for(int j=0;j<9;j++) {
					char tmp = str.charAt(j);
					map[i][j] = tmp;
					if(tmp == 'o') total++;
				}
			}
			if(t!=T-1) {
				br.readLine();
			}
//			System.out.println(total);
			MIN =Integer.MAX_VALUE;
			MOVE = 0;
			
			Queue<char[][]> queue = new LinkedList<char[][]>();
			queue.add(map);
			int cnt = 0;
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				
				for(int s=0;s<size;s++) {
					
					char[][] now = queue.poll();
					//사방탐색해서 갈수있을 경우 queue 추가
					boolean flag = false;
					
					for(int i=0;i<5;i++) {
						for(int j=0;j<9;j++) {
							if(now[i][j]=='o') {
								
								for(int d=0;d<4;d++) {
									int nr1 = i+dr[d];
									int nr2 = i+dr[d]*2;
									int nc1 = j+dc[d];
									int nc2 = j+dc[d]*2;
									
									if(nr2<0 || nr2>=5 || nc2<0 || nc2>=9) {
										continue;
									}
									if(now[nr1][nc1]=='o' && now[nr2][nc2]=='.' ) {
										
										char[][] cp = new char[5][9];
										for(int q=0;q<5;q++) {
											cp[q]=Arrays.copyOf(now[q],9);
										}
										
										cp[i][j]='.';
										cp[nr1][nc1]='.';
										cp[nr2][nc2]='o';
										queue.add(cp);
										
										flag=true;
									}
									
								}
								
							}
						}
					}
					
					
					//더이상 못갈경우 정산하기
					if(flag==false) {
						int pin=0;
						for(int a=0;a<5;a++) {
							for(int b=0;b<9;b++) {
								if(now[a][b]=='o') {
									pin++;
								}
							}
						}
						
						if(MIN>pin) {
							MIN = pin;
							MOVE = cnt;
						}
						
					}
					
				}
				
				cnt++;
			}
			
			System.out.println(MIN+" "+MOVE);
		}
		
		
		
		
		

	}

}
