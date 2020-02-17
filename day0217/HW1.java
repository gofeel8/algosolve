package day0217;

import java.util.Arrays;

public class HW1 {
	static int[] arr = { 1, 2, 3 };
	static int[] result = new int[3];

	public static void main(String[] args) {
		perm(arr.length, 0);
//		perm_my(0);
	}
	public static void perm(int n, int k) {
		if (k == n) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = k; i < arr.length; i++) {
				swap(k, i);
				perm(n, k + 1);
				swap(k, i);
			}
		}
	}

	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static boolean[] used = new boolean[arr.length];

	
	public static void perm_my(int idx) {
		if (idx == arr.length) {
			System.out.println(Arrays.toString(result));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (used[i] == false) {
					used[i] = true;
					result[idx] = arr[i];
					perm_my(idx + 1);
					used[i] = false;
				}

			}
		}
	}
}
