import java.util.*;
import java.io.*;

public class P12869 {
	public static boolean[][][] used;
	public static int[] selected;
	public static boolean[] visited;
	public static int[] now;
	public static Queue<int []>queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		used = new boolean[61][61][61];
		selected = new int[3];
		visited = new boolean[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] start = new int[N];
		for(int i=0;i<N;i++) {
			start[i]=Integer.parseInt(st.nextToken());
		}
		queue = new LinkedList<int[]>();
		int a =0,b=0,c=0;
		if(N==1) {
			a = start[0];
		}
		if(N==2) {
			a = start[0];
			b = start[1];
		}
		if(N==3){
			a = start[0];
			b = start[1];
			c = start[2];
			
		}

		
		used[a][b][c]=true;
		queue.add(new int[] {a,b,c});
		int cnt =0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for(int i=0;i<qsize;i++) {
				now = queue.poll();
				if(now[0]==0 && now[1]==0 && now[2]==0 ) {
					System.out.println(cnt);
					return;
				}
				perm(0);
			}
			cnt++;
		}
	}
	
	public static void perm(int idx) {
		if (idx ==3) {
			int[] cp = Arrays.copyOf(now, 3);
			cp[selected[0]]-= 9;  // -9
			cp[selected[1]]-=3;  // -3
			cp[selected[2]]-=1;  // -1
			for(int i=0;i<3;i++) {
				if(cp[i]<0)cp[i] =0;
			}
			if(used[cp[0]][cp[1]][cp[2]]==false) {
				queue.add(new int[] {cp[0],cp[1],cp[2]});
				used[cp[0]][cp[1]][cp[2]]=true;
			}
			return;
		}
		
		for(int i=0;i<3;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				selected[idx]=i;
				perm(idx+1);
				visited[i]=false;
			}
		}
	}

}
