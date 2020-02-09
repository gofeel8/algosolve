package gps0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exp1216 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			char[][] arr = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int len = 100;
			while (len>0) {
				boolean tf = false;
				for (int i = 0; i <= 100 - len; i++) {
					tf = false;
					for (int j = 0; j <= 100 - len; j++) {
						tf = false;
						int tmp = len - 1;
						if (j + tmp < 100) {
							for (int k = 0; k < len / 2; k++) {
								if (arr[i][j + k] == arr[i][j + tmp--]) {
									tf = true;
								}else {
									tf = false;
									break;
								}
							}
						}
						if (tf == true) {
							break;
						}
						tmp = len - 1;
						if (i + tmp < 100) {
							for (int k = 0; k < len / 2; k++) {
								if (arr[i + k][j] == arr[i + tmp--][j]) {
									tf = true;
								}
								else {
									tf= false;
									break;
								}
							}

						}
						if (tf == true) {
							break;
						}

					}
					if (tf == true) {
						break;
					}
				}
				if (tf == true) {
					break;
				}

				len--;

			}
			System.out.println("#"+tc+" "+len);
		}
	}
}
