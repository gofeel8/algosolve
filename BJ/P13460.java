import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13460 {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][]map;

	public static void main(String[] args) throws IOException {
		int[] pos = new int[4]; // 0 :Rr 1 :Rc, 2:Br, 3:Bc
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='R') {
					pos[0]=i;
					pos[1]=j;
				}else if(map[i][j]=='B') {
					pos[2]=i;
					pos[3]=j;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(pos);
		
		int result=-1;

		int flag = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			result++;
			if(result > 10) break;
//			System.out.println(result+"��° �õ�");
			for(int i=0;i<size;i++) {
				int[] temp = queue.poll();
//				System.out.println("���� ť : "+Arrays.toString(temp));
				if(temp[0]==0 && temp[2]==0  ) {
					flag = 1;
					break;
				}else if(temp[0]==0) {
					flag = 2;
					break;
				}else if(temp[2]==0) {
					flag = 3;
					break;
				}
				
				for(int j=0;j<4;j++) {
					
					int[] rt = rotate(temp,j);
					if(!Arrays.equals(rt, temp)) {
						if(rt[2]!=0) {
							queue.add(rt);
//							System.out.println("�߰��� ť : "+Arrays.toString(rt));
						}
					}

				}
			
			}
			if(flag == 2) {
				break;
			}
		}
		
		if(flag==2) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
		
		
		

	}

	private static int[] rotate(int[] temp, int j) {
		int[] rt = new int[4];
		rt[0]=temp[0];
		rt[1]=temp[1];
		rt[2]=temp[2];
		rt[3]=temp[3];
		switch (j) {
		case 0: //��
			if(rt[0]>rt[2]) { //B �� �������� B���� ���
				while(map[rt[2]-1][rt[3]]!='#') {
					rt[2]--;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
				while(map[rt[0]-1][rt[1]]!='#' &&  !(rt[0]-1 == rt[2] && rt[1] == rt[3]) ) {
					rt[0]--;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
			}else {
				while(map[rt[0]-1][rt[1]]!='#' ) {
					rt[0]--;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
				while(map[rt[2]-1][rt[3]]!='#'  &&  !(rt[2]-1 == rt[0] && rt[1] == rt[3]) ) {
					rt[2]--;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
			}
			break;
		case 1: //��
			if(rt[1]>rt[3]) {  // R�� �� �����ʿ� ����, R���� ���
				while(map[rt[0]][rt[1]+1]!='#' ) {
					rt[1]++;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
				while(map[rt[2]][rt[3]+1]!='#'  &&  !(rt[3]+1 == rt[1] && rt[0] == rt[2])) {
					rt[3]++;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
			}else {
				while(map[rt[2]][rt[3]+1]!='#') {
					rt[3]++;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
				while(map[rt[0]][rt[1]+1]!='#'   &&  !(rt[1]+1 == rt[3]&& rt[0] == rt[2])) {
					rt[1]++;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
			}
			
			break;
		case 2: //��
			if(rt[0]>rt[2]) { //R�� �� �Ʒ����� R���� ���
				while(map[rt[0]+1][rt[1]]!='#' ) {
					rt[0]++;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
				while(map[rt[2]+1][rt[3]]!='#' &&  !(rt[2]+1 == rt[0] && rt[1] == rt[3])) {
					rt[2]++;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
			}else {
				while(map[rt[2]+1][rt[3]]!='#' ) {
					rt[2]++;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
				while(map[rt[0]+1][rt[1]]!='#' &&  !(rt[0]+1 == rt[2] && rt[1] == rt[3])) {
					rt[0]++;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
			}
			
			
			break;
		case 3: //��
			if(rt[1]>rt[3]) { //B���� ���
				while(map[rt[2]][rt[3]-1]!='#') {
					rt[3]--;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
				while(map[rt[0]][rt[1]-1]!='#' &&  !(rt[1]-1 == rt[3] && rt[0] == rt[2])) {
					rt[1]--;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
			}else {
				while(map[rt[0]][rt[1]-1]!='#') {
					rt[1]--;
					if(map[rt[0]][rt[1]]=='O') {
						rt[0]=0;
						rt[1]=0;
						break;
					}
				}
				while(map[rt[2]][rt[3]-1]!='#' &&  !(rt[3]-1 == rt[1] && rt[0] == rt[2] )) {
					rt[3]--;
					if(map[rt[2]][rt[3]]=='O') {
						rt[2]=0;
						rt[3]=0;
						break;
					}
				}
			}
			
			break;
		default:
			break;
		}
		

		return rt;
	}

}
