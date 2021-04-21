import java.util.*;
import java.io.*;

public class P1938 {
	public static boolean[][][] visited;
	public static char[][] map;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str;
		int[][] Barr = new int[3][2];
		int[][] Earr = new int[3][2];
		
		map = new char[N][N];
		
		int bidx=0,Eidx=0;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<N;j++) {
				char tmp =str.charAt(j);
				map[i][j]=tmp;
				if(tmp=='B') {
					Barr[bidx][0]=i;
					Barr[bidx][1]=j;
					bidx++;
				}else if(tmp =='E') {
					Earr[Eidx][0]=i;
					Earr[Eidx][1]=j;
					Eidx++;
				}
			}
		}
		
		int Bmode;
		if(Barr[0][1]==Barr[1][1]) {
			Bmode = 1;
		}else {
			Bmode =0;
		}
		
		int Emode;
		if(Earr[0][1]==Earr[1][1]) {
			Emode = 1;
		}else {
			Emode =0;
		}
		
	
		visited = new boolean[2][N][N];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {Barr[1][0],Barr[1][1],Bmode});
		visited[Bmode][Barr[1][0]][Barr[1][1]]=true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				int[] now = queue.poll();
				if(now[0]==Earr[1][0] && now[1]==Earr[1][1] && now[2]==Emode) {
					System.out.println(cnt);
					return;
				}
				
				//상
				if(up(now) && visited[now[2]][now[0]-1][now[1]]==false) {
					queue.add(new int[] {now[0]-1,now[1],now[2]});
					visited[now[2]][now[0]-1][now[1]]=true;
				}
				//하
				if(down(now) && visited[now[2]][now[0]+1][now[1]]==false) {
					queue.add(new int[] {now[0]+1,now[1],now[2]});
					visited[now[2]][now[0]+1][now[1]]=true;
				}
				//좌
				if(left(now) && visited[now[2]][now[0]][now[1]-1]==false) {
					queue.add(new int[] {now[0],now[1]-1,now[2]});
					visited[now[2]][now[0]][now[1]-1]=true;
				}
				//우
				if(right(now) && visited[now[2]][now[0]][now[1]+1]==false) {
					queue.add(new int[] {now[0],now[1]+1,now[2]});
					visited[now[2]][now[0]][now[1]+1]=true;
				}
				//회전
				if(rotate(now) && visited[(now[2]+1)%2][now[0]][now[1]]==false) {
					queue.add(new int[] {now[0],now[1],(now[2]+1)%2});
					visited[(now[2]+1)%2][now[0]][now[1]]=true;
				}
			}
			cnt++;
		}

		System.out.println(0);
	}

	private static boolean up(int[] now) {
		//범위 체크
		if(now[2]==1 && now[0]-1<1) {
			return false;
		}else if(now[2]==0 && now[0]-1<0) {
			return false;
		}
		//나무 체크
		if(now[2]==1 && map[now[0]-2][now[1]]=='1') {
			return false;
		}else if(now[2]==0) {
			for(int d=0;d<3;d++) {
				if(map[now[0]-1][now[1]-1+d]=='1') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean down(int[] now) {
		//범위 체크
		if(now[2]==1 && now[0]+1>=N-1) {
			return false;
		}else if(now[2]==0 && now[0]+1>N-1) {
			return false;
		}
		//나무 체크
		if(now[2]==1 && map[now[0]+2][now[1]]=='1') {
			return false;
		}else if(now[2]==0) {
			for(int d=0;d<3;d++) {
				if(map[now[0]+1][now[1]-1+d]=='1') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean left(int[] now) {
		//범위 체크
		if(now[2]==1 && now[1]==0) {
			return false;
		}else if(now[2]==0 && now[1]-1==0) {
			return false;
		}
		//나무 체크
		if(now[2]==1) {
			for(int d=0;d<3;d++) {
				if(map[now[0]-1+d][now[1]-1]=='1') {
					return false;
				}
			}
		}else if(now[2]==0 && map[now[0]][now[1]-2]=='1') {
			return false;
		}
		
		
		return true;
	}
	
	
	private static boolean right(int[] now) {
		//범위 체크
		if(now[2]==1 && now[1]==N-1) {
			return false;
		}else if(now[2]==0 && now[1]+1==N-1) {
			return false;
		}
		//나무 체크
		if(now[2]==1) {
			for(int d=0;d<3;d++) {
				if(map[now[0]-1+d][now[1]+1]=='1') {
					return false;
				}
			}
		}else if(now[2]==0 && map[now[0]][now[1]+2]=='1') {
			return false;
		}
		return true;
	}
	
	private static boolean rotate(int[] now) {
		//범위 체크
		if(now[0]==0 || now[0]==N-1 || now[1]==0 || now[1]==N-1)return false;
		
		//나무 체크
		if(now[2]==1) {
			if(map[now[0]-1][now[1]-1]=='1' ||map[now[0]][now[1]-1]=='1' || map[now[0]+1][now[1]-1]=='1' ||map[now[0]-1][now[1]+1]=='1' ||map[now[0]][now[1]+1]=='1'  ||map[now[0]+1][now[1]+1]=='1' )return false;
		}else if(now[2]==0) {
			if(map[now[0]-1][now[1]-1]=='1'||map[now[0]-1][now[1]]=='1' || map[now[0]-1][now[1]+1]=='1'||map[now[0]+1][now[1]-1]=='1'||map[now[0]+1][now[1]]=='1'||map[now[0]+1][now[1]+1]=='1')return false;
		}
		return true;
		
	}

}
