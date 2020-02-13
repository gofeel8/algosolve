package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static int M; // 가로 칸수
	static int N; // 세로 칸수
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> queue = new LinkedList<>();
		int zeroCnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					queue.add(new Node(i, j));
				}else if(arr[i][j]==0){
					zeroCnt++;
				}
			}
		}
		int cnt = 0;
		while (true) {
			boolean changed = false;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				int nr = temp.r;
				int nc = temp.c;
				for (int d = 0; d < 4; d++) {
					if (nr + di[d] >= 0 && nr + di[d] < N && nc + dj[d] >= 0 && nc + dj[d] < M
							&& arr[nr + di[d]][nc + dj[d]] == 0) {
						zeroCnt--;
						arr[nr + di[d]][nc + dj[d]] = 1;
						queue.add(new Node(nr + di[d],nc + dj[d]));
						changed = true;						
					}
				}
			}

			if (changed == false) {
				break;
			} else {
				cnt++;
			}
		}
		
		if(zeroCnt == 0) {
			System.out.println(cnt);
		}else {
			System.out.println("-1");
		}

	}

	public static class Node {
		public int r;
		public int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

}
