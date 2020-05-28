package EXP1953_탈주범검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static boolean[][] visited;
	private static int[][] map;
	private static int R;
	private static int C;
	private static int L;
	private static int N;
	private static int M;
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };
	private static boolean[][][] enable;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

	
			enable = new boolean[8][4][8];
			enable[1][0][2] = enable[1][0][5] = enable[1][0][6] = enable[1][0][1] =true;
			enable[1][1][3] = enable[1][1][6] = enable[1][1][7] = enable[1][1][1] = true;
			enable[1][2][2] = enable[1][2][4] = enable[1][2][7] = enable[1][2][1] = true;
			enable[1][3][3] = enable[1][3][4] = enable[1][3][5] = enable[1][3][1] = true;
			enable[2][0][1] = enable[2][0][5] = enable[2][0][6] =enable[2][0][2] = true;
			enable[2][2][1] = enable[2][2][4] = enable[2][2][7] =enable[2][2][2] = true;
			enable[3][1][1] = enable[3][1][6] = enable[3][1][7] =enable[3][1][3] =  true;
			enable[3][3][1] = enable[3][3][4] = enable[3][3][5] =enable[3][3][3] =  true;
			enable[4][0][1] = enable[4][0][2] = enable[4][0][5] = enable[4][0][6] = true;
			enable[4][1][1] = enable[4][1][3] = enable[4][1][6] = enable[4][1][7] = true;
			enable[5][1][1] = enable[5][1][3] = enable[5][1][6] = enable[5][1][7] = true;
			enable[5][2][1] = enable[5][2][2] = enable[5][2][4] = enable[5][2][7] = true;
			enable[6][2][1] = enable[6][2][2] = enable[6][2][4] = enable[6][2][7] = true;
			enable[6][3][1] = enable[6][3][3] = enable[6][3][4] = enable[6][3][5] = true;
			enable[7][0][1] = enable[7][0][2] = enable[7][0][5] = enable[7][0][6] = true;
			enable[7][3][1] = enable[7][3][3] = enable[7][3][4] = enable[7][3][5] = true;

			bfs();

			System.out.println("#" + tc + " " + result);
		}

	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(R, C, map[R][C]));
		visited[R][C] = true;
		result++;

		int time = 0;
		while (!queue.isEmpty()) {
			time++;
			if (time == L) {
				break;
			}

			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				Node temp = queue.poll();
				int type = temp.t;
				for (int j = 0; j < 4; j++) {
						int nr = temp.r + dr[j];
						int nc = temp.c + dc[j];
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							continue;
						}
						if (visited[nr][nc] == true) {
							continue;
						}
						if (map[nr][nc] == 0) {
							continue;
						}
						if (enable[type][j][map[nr][nc]]) {
							queue.add(new Node(nr, nc, map[nr][nc]));
							visited[nr][nc] = true;
							result++;
						}
				}
			}
		}

	}

	public static class Node {
		int r;
		int c;
		int t;

		public Node(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

	}

}
