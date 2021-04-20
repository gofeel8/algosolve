import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class P1525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] map = new int[9];
		int idx=0;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++)
			map[idx++]=Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(map));
		Set<String> visited = new HashSet<>();
		visited.add(Arrays.toString(map));
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(map);
		int cnt =0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				
				int[] now = queue.poll();
	
				if(now[8]==0) {
					//검사한번 해봐바
					boolean find = true;
					for(int k=1;k<8;k++) {
						if(now[k-1]!=k) {
							find = false;
							break;
						}
					}
					if(find) {
						System.out.println(cnt);
//						System.out.println(Arrays.toString(now));
						return;
					}
				}
				
				
				//0위치 찾기
				int space =0;
				for(int i=0;i<9;i++) {
					if(now[i]==0) {
						space =i;
						break;
					}
				}
				
				//상하좌우 이동 , 원복 , 비짓, 큐삽입
				//상
				if(space>2) {
					int tmp = now[space-3];
					now[space-3]=now[space];
					now[space]=tmp;
					if(!visited.contains(Arrays.toString(now))) {
						int[] cp = Arrays.copyOf(now, 9);
						queue.add(cp);
						visited.add(Arrays.toString(cp));
					}
					now[space]=now[space-3];
					now[space-3]=tmp;
				}
				//하
				if(space<6) {
					int tmp = now[space+3];
					now[space+3]=now[space];
					now[space]=tmp;
					if(!visited.contains(Arrays.toString(now))) {
						int[] cp = Arrays.copyOf(now, 9);
						queue.add(cp);
						visited.add(Arrays.toString(cp));
					}
					now[space]=now[space+3];
					now[space+3]=tmp;
				}
				//좌
				if(space!= 0 && space !=3 && space !=6) {
					int tmp = now[space-1];
					now[space-1]=now[space];
					now[space]=tmp;
					if(!visited.contains(Arrays.toString(now))) {
						int[] cp = Arrays.copyOf(now, 9);
						queue.add(cp);
						visited.add(Arrays.toString(cp));
					}
					now[space]=now[space-1];
					now[space-1]=tmp;
				}
				//우
				if(space!= 2 && space !=5 && space !=8) {
					int tmp = now[space+1];
					now[space+1]=now[space];
					now[space]=tmp;
					if(!visited.contains(Arrays.toString(now))) {
						int[] cp = Arrays.copyOf(now, 9);
						queue.add(cp);
						visited.add(Arrays.toString(cp));
					}
					now[space]=now[space+1];
					now[space+1]=tmp;
				}
			}
			cnt++;
			
		}
		
		
		System.out.println(-1);
	}

}
