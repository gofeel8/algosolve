import java.util.*;
import java.io.*;
public class P2174 {
	public static int [] dr = {-1,0,1,0};
	public static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[A+1][B+1];
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int []> robot = new ArrayList<int[]>();
		robot.add(new int[] {-1,-1,-1});
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			char tmp = st.nextToken().charAt(0);
			int d=0;
			switch (tmp) {
			case 'W':
				d=0;
				break;
			case 'N':
				d=1;
				break;
			case 'E':
				d=2;
				break;
			case 'S':
				d=3;
				break;
			}
			
			map[r][c]=i+1;
			robot.add( new int[] {r,c,d});
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int idx =Integer.parseInt(st.nextToken());
			char com = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			
			if(com != 'F') {
				cnt = cnt %4;
				if(com =='L') {
					robot.get(idx)[2] = (robot.get(idx)[2]+(4-cnt))%4; 
				}else if(com=='R') {
					robot.get(idx)[2] = (robot.get(idx)[2]+(cnt))%4;
				}
			}else { // idx 로봇을 cnt 만큼 움직여 보자
				int[] now = robot.get(idx);
				for(int j=1;j<=cnt;j++) {
					int nr =now[0]+dr[now[2]]*j;
					int nc =now[1]+dc[now[2]]*j;
					
					if(nr<=0 || nr>A || nc<=0 || nc>B) {
						System.out.println("Robot "+idx+" crashes into the wall");
						return;
					}
					
					if(map[nr][nc] != idx && map[nr][nc]!=0) {
						System.out.println("Robot "+idx+" crashes into robot "+map[nr][nc]);
						return;
					}
					
					if(j==cnt) {
						map[now[0]][now[1]]=0;
						map[nr][nc]=idx;
						robot.get(idx)[0]=nr;
						robot.get(idx)[1]=nc;
						
					}
					
				}
			}
			
			
			
		}
		System.out.println("OK");
		
	}


}
