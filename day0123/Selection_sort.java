//선택 정렬 
package day0127;

public class Selection_sort {

	public static void main(String[] args) {
		int[] arr = {16,34,31,21,74,85,42,93,22,100};
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		selectionSort(arr);
		System.out.println("선택정렬 결과 :");
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	
	
	public static void selectionSort(int a[]) {
		for (int i =0;i<a.length-1;i++) {
			int min = i;
			int temp = 0;
			for(int k=i+1;k<a.length;k++) {
				if(a[min]>a[k]) {
					min =k;
				}
			}
			temp = a[min];
			a[min]=a[i];
			a[i]=temp;				
			
		}
	}

}
