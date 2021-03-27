import java.io.*;
import java.util.*;

public class P14890 {
	public static int N,L;
	public static int[][] map;
	public static int MAX;
	public static int[] horizon = {0,1};
	public static int[] vertical = {1,0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		MAX = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		dfs(0,0);
		
		System.out.println(MAX);
		
	}

	private static void dfs(int idx, int cnt) {
		if(idx == 2*N) {
			if(cnt>MAX) {
				MAX = cnt;
			}
			return;
		}
		
		
		int dir = idx/N;
		int[] now = new int[2];
		
		if(dir == 0) {
			now[1]=idx%N; 
		}else {
			now[0]=idx%N;
		}
		
		
		//설치 없이 그냥 길일경우
		
		int prev = map[now[0]][now[1]];
		boolean flag =false;
		int gap =0;
		for(int i=1;i<N;i++) {
			if(prev != map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i]) {
				flag=true;
				gap = Math.max(gap, Math.abs(prev -  map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i]));
			}
			prev = map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i];
		}
		
		if(!flag) {
			dfs(idx+1,cnt+1);
		}else {
			
			
			//설치 될 경우 확인
			if(gap==1) {
				boolean able = true;
				
				boolean[][] cp = new boolean[N][N];
				
				prev = map[now[0]][now[1]];
				for(int i=1;i<N;i++) {
					if(able==false)break;
					if(prev> map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i]) {
						//아래로 경사로를 만들어야함
						if(i+L>N) {
							able=false;
							break;
						}
						for(int j=0;j<L;j++) {
							//모두 평평하고 체크하지 않았을 경우
							if(map[now[0]+vertical[dir]*i+vertical[dir]*j][now[1]+horizon[dir]*i+horizon[dir]*j]!=prev-1) {
								able=false;
								break;
							}
							if(cp[now[0]+vertical[dir]*i+vertical[dir]*j][now[1]+horizon[dir]*i+horizon[dir]*j]==true) {
								able=false;
								break;
							}else {
								cp[now[0]+vertical[dir]*i+vertical[dir]*j][now[1]+horizon[dir]*i+horizon[dir]*j]=true;
							}
						}
						i=i+L-1;
						
					}else if(prev< map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i]) {
						//위로 경사로를 만들어야함
						if(i-L<0) {
							able=false;
							break;
						}
						
						for(int j=1;j<=L;j++) {
							//모두 평평하고 체크하지 않았을 경우
							if(map[now[0]+vertical[dir]*i-vertical[dir]*j][now[1]+horizon[dir]*i-horizon[dir]*j]!=prev) {
								able=false;
								break;
							}
							if(cp[now[0]+vertical[dir]*i-vertical[dir]*j][now[1]+horizon[dir]*i-horizon[dir]*j]==true) {
								able=false;
								break;
							}else {
								cp[now[0]+vertical[dir]*i-vertical[dir]*j][now[1]+horizon[dir]*i-horizon[dir]*j]=true;
							}
						}
						
					}
					prev = map[now[0]+vertical[dir]*i][now[1]+horizon[dir]*i];
				}
				if(able) {
					dfs(idx+1,cnt+1);
				}else {
					dfs(idx+1,cnt);
				}
			}else {
				
				dfs(idx+1,cnt);
			}
			
		}
		
	}

}
