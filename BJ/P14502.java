import java.util.*;
import java.io.*;

public class P14502 {
	
	static int N;
	static int M;
	static int[][] map;
	static List<int[]> list;
	static int blank;
	
	static int MAX;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	static Queue<int[]> queue ;
	static int[][] copy ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		queue = new LinkedList<int[]>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		MAX=0;
		
		map = new int[N][M];
		
		list = new ArrayList<>();
		blank=0;
		
		copy= new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j]=tmp;
				if(tmp==2) {
					list.add(new int[] {i,j});
				}else if(tmp == 0) {
					blank++;
				}
			}
		}
		
		func();
		System.out.println(MAX);

	}
	
	static public void func() {
		int tot = N*M;
		for(int i=0;i<tot;i++) {
			int ir = i/M;
			int ic = i%M;
			if(map[ir][ic]!=0)continue;
			
			
			for(int j=i+1;j<tot;j++) {
				int jr = j/M;
				int jc = j%M;
				if(map[jr][jc]!=0)continue;

				
				for(int k=j+1;k<tot;k++) {
//					System.out.println(i+","+j+","+k);
					int kr = k/M;
					int kc = k%M;
					if(map[kr][kc]!=0)continue;
					
//					int[][] copy = new int[N][M];
					copyMap(copy);
//					for(int q=0;q<N;q++) {
//						copy[q]=Arrays.copyOf(map[q],M);
//					}
					
					copy[ir][ic]=1;
					copy[jr][jc]=1;
					copy[kr][kc]=1;
					int tmpBlank=blank-3;
					
//					queue = new LinkedList<>();
					queue.clear();
					for(int z=0;z<list.size();z++) {
						queue.add(list.get(z));
					}
					while(!queue.isEmpty()) {
						int[] tmp = queue.poll();
						
						int r =tmp[0];
						int c =tmp[1];
						
						for(int d=0;d<4;d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
							
							if(copy[nr][nc]==0) {
								copy[nr][nc]=2;
								queue.add(new int[] {nr,nc});
								tmpBlank--;
							}
							
							
						}
						
					}
					
					if(tmpBlank>MAX) {
						MAX=tmpBlank;
//						for(int q=0;q<N;q++) {
//							System.out.println(Arrays.toString(copy[q]));
//						}
//						System.out.println("==========================");
						
					}
					
				}
			}
		}
	}
	
	static void copyMap(int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

}
