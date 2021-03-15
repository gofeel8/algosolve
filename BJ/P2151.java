import java.io.*;
import java.util.*;

public class P2151 {
	public static int[] dr= {-1,0,1,0};
	public static int[] dc= {0,1,0,-1};
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		String str;
		int[][] doors = new int[2][2];
		int idx =0;
		
		int[][] visited = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<N;j++) {
				char tmp = str.charAt(j);
				map[i][j] = tmp;
				if(tmp =='#') {
					doors[idx][0]=i;
					doors[idx][1]=j;
					idx++;
				}
			}
		}
		Queue<Node> queue = new LinkedList<>();
		for(int d=0;d<4;d++) {
			int nr =doors[0][0]+dr[d];
			int nc =doors[0][1]+dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N)continue;
			queue.add(new Node(doors[0][0], doors[0][1], d));
		}
		map[doors[0][0]][doors[0][1]]='*';
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Node now = queue.poll();  //현재위치 확인
				int dir = now.dir;
				int nr=now.row+dr[dir];
				int nc=now.col+dc[dir];
				while(nr>=0 && nr<N && nc>=0 && nc<N) {
					//주어진 방향으로 쭈욱 가면서
					if(map[nr][nc]=='#') {
						//# 문만나면 게임 끝
						System.out.println(cnt);
						return;
					}else if(map[nr][nc]=='*') {
						//* 벽 만나면 중지
						break;
					}else if(map[nr][nc]=='!') {
						//! 가있는 거울에서  양옆으로 queue 추가  == 거울 설치 하는것
						if(visited[nr][nc]>cnt) {
							queue.add(new Node(nr,nc,(dir+1)%4));
							queue.add(new Node(nr,nc,(dir+3)%4));
							visited[nr][nc]=cnt;
						}
					}
					nr=nr+dr[dir];
					nc=nc+dc[dir];
				}
			}
			cnt ++;
		}
	}
	public static class Node{
		int row;
		int col;
		int dir;
		Node(int r, int c,int d){
			row=r;
			col=c;
			dir=d;
		}
	}

}
