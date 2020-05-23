package exp3234_준환이의양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[] chu;
	private static boolean[] used;
	private static int N;
	private static int[] arr;
	private static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			used = new boolean[N];
			arr = new int[N];
			result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);

			System.out.println("#" + tc + " " + result);
		}

	}

	private static void perm(int idx) {
		if (idx == N) {
			int[] left = new int[N];
			int[] right = new int[N];
			pick(0, left, right,0,0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (used[i] == false) {
				used[i] = true;
				arr[idx] = i;
				perm(idx + 1);
				used[i] = false;
			}
		}

	}

	private static void pick(int idx, int[] left, int[] right,int lsum,int rsum) {
		if (idx == N) {
			result++;
			return;
		}
		left[idx] = chu[arr[idx]];
		pick(idx + 1, left, right,lsum+chu[arr[idx]],rsum);
		left[idx] = 0;
		if(lsum>=rsum+chu[arr[idx]]) {
		right[idx] = chu[arr[idx]];
		pick(idx + 1, left, right,lsum,rsum+chu[arr[idx]]);
		right[idx] = 0;
		}

	}


}
