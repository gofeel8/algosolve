package gps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exp1873 {
	static char[][] field;
	static int nRow, nCol;
	static int H, W;
	static char status;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = str.charAt(j);
					if (field[i][j] == '<' | field[i][j] == '^' | field[i][j] == '>' | field[i][j] == 'v') {
						nRow = i;
						nCol = j;
						status = field[i][j];
					}
				}
			}
			int cNum = Integer.parseInt(br.readLine());
			char cmd;
			String com = br.readLine();
			for (int i = 0; i < cNum; i++) {
				cmd = com.charAt(i);
				move(cmd);
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static void move(char cmd) {
		switch (cmd) {
		case 'U':
			status = '^';
			if (nRow - 1 < 0 || field[nRow - 1][nCol] != '.') {
				field[nRow][nCol] = status;
			} else {
				field[nRow][nCol] = '.';
				field[nRow][nCol] = status;
			}
			break;
		case 'D':
			status = 'v';
			if (nRow + 1 == H || field[nRow + 1][nCol] != '.') {
				field[nRow][nCol] = status;
			} else {
				field[nRow][nCol] = '.';
				nRow++;
				field[nRow][nCol] = status;
			}
			break;
		case 'L':
			status = '<';
			if (nCol - 1 < 0 || field[nRow][nCol - 1] != '.') {
				field[nRow][nCol] = status;
			} else {
				field[nRow][nCol] = '.';
				nCol--;
				field[nRow][nCol] = status;
			}
			break;
		case 'R':
			status = '>';
			if (nCol + 1 == W || field[nRow][nCol + 1] != '.') {
				field[nRow][nCol] = status;
			} else {
				field[nRow][nCol] = '.';
				nCol++;
				field[nRow][nCol] = status;
			}
			break;
		case 'S':
			int tRow = nRow;
			int tCol = nCol;
			switch (status) {
			case '^':
				while (tRow >= 0) {
					if (field[tRow][tCol] == '*') { // 벽돌
						field[tRow][tCol] = '.';
						break;
					}
					if (field[tRow][tCol] == '#') { // 강철
						break;
					}
					tRow--;
				}
				break;
			case 'v':
				while (tRow < H) {
					if (field[tRow][tCol] == '*') { // 벽돌
						field[tRow][tCol] = '.';
						break;
					}
					if (field[tRow][tCol] == '#') { // 강철
						break;
					}
					tRow++;
				}
				break;
			case '<':
				while (tCol >= 0) {
					if (field[tRow][tCol] == '*') { // 벽돌
						field[tRow][tCol] = '.';
						break;
					}
					if (field[tRow][tCol] == '#') { // 강철
						break;
					}
					tCol--;
				}
				break;
			case '>':
				while (tCol < W) {
					if (field[tRow][tCol] == '*') { // 벽돌
						field[tRow][tCol] = '.';
						break;
					}
					if (field[tRow][tCol] == '#') { // 강철
						break;
					}
					tCol++;
				}
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

}
