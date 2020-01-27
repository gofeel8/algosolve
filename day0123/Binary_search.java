//�����˻�
package day0127;

import java.util.Arrays;

public class Binary_search {

	public static void main(String[] args) {
		int[] arr = {16,34,31,21,74,85,42,93,22,100};
		System.out.println("���� ��:");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		int key = 74;
		System.out.println(key+"�� �ε��� : " + binarySearch(arr, key));
	}
	
	public static int binarySearch(int a[],int key) {
		Arrays.sort(a);
		System.out.println("���� ��:");

		for(int num:a) {
			System.out.print(num+" ");
		}
		System.out.println();
		int start = 0;
		int end = a.length-1;
		int middle = 0;
		while(start<=end) {
			middle=(start+end)/2;
			if(a[middle]==key) {
				return middle;
			}else if(a[middle]>key) {
				end = middle-1;
			}else {
				start = middle+1;
			}
		}
		return -1;
	}

}
