import java.io.*;
import java.util.*;
public class P9328 {
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int t =0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] map = new int[r][c];
			String str;
			Queue<int []> queue = new LinkedList<int[]>();
			for(int i=0;i<r;i++) {
				str = br.readLine();
				for(int j=0;j<c;j++) {
					char tmp = str.charAt(j);
					map[i][j] = tmp;
					if(i==0 || i==r-1 || j==0 || j==c-1){
						if(tmp != '*') {
							queue.add(new int[] {i,j});
						}
					}
				}
			}
			
			str = br.readLine();
			boolean[] key = new boolean[26];
			for(int i=0;i<str.length();i++) {
				char tmp = str.charAt(i);
				if(tmp=='0')break;
				key[tmp-'a']=true;
			}
			
			int result = 0;
			
			boolean[][] visited = new boolean[r][c];
			
			while(!queue.isEmpty()) {
				int qsize = queue.size();
				boolean find = false;
				for(int i=0;i<qsize;i++) {
					int[] now =queue.poll();
					if(map[now[0]][now[1]]-'A'>=0 &&map[now[0]][now[1]]-'A'<26) { // 문이라면
						//키있나확인
						if(key[map[now[0]][now[1]]-'A']==false) {
							queue.add(now);  //없으면 다시 대기
							continue;
						}
					}
					
					if(map[now[0]][now[1]]=='$') { //문서 발견
						result++;
						map[now[0]][now[1]]='.';
						find = true;
					}
					
					if(map[now[0]][now[1]]-'a'>=0 &&map[now[0]][now[1]]-'a'<26) { //키 발견
						key[map[now[0]][now[1]]-'a']=true;
						find = true;
					}
					
					for(int d=0;d<4;d++) {
						int nr = now[0]+dr[d];
						int nc = now[1]+dc[d];
						if(nr<0 || nr>=r || nc<0 || nc>=c) {
							continue;
						}
						if(visited[nr][nc]==true) {
							continue;
						}
						
						if(map[nr][nc]=='*') {
							continue;
						}
						
						queue.add(new int[] {nr,nc});
						find = true;
						visited[nr][nc]=true;
						
					}
				}
				if(find==false)break;
			}
			
			
			System.out.println(result);
		}

	}

}
