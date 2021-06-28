package GPS;
import java.io.*;
import java.util.*;

public class Heap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		minHeap heap = new minHeap(10);
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				System.out.println(heap.poll());
			}else {
				heap.add(num);
			}
		}
		
	}
	
	public static class minHeap{
		int idx;
		int[] arr;
		
		public minHeap(int size) {
			arr = new int[size];
			idx=1;
		}
		
		public void add(int num) {
			if(idx == arr.length) {
				int[] newArr  = new int[arr.length*2];
				for(int i=0;i<arr.length;i++) {
					newArr[i]=arr[i];
				}
				arr = newArr;
			}
			arr[idx]=num;
			int tmpIdx=idx;
			while(tmpIdx>=2) {
				if(arr[tmpIdx/2]>arr[tmpIdx]) {  //부모가 더 크다 
					int tmp = arr[tmpIdx/2];
					arr[tmpIdx/2] = arr[tmpIdx];
					arr[tmpIdx] = tmp;
					tmpIdx=tmpIdx/2;
				}else {
					break;
				}
			}
			idx++;
		}
		
		public int poll() {
			if(idx==1) {
				return 0;
			}
			
			int rt = arr[1];
			
			idx--;
			arr[1] = arr[idx];
			
			int tmpIdx=1;
			while(tmpIdx*2<idx) {
				if(tmpIdx*2+1<idx && arr[tmpIdx*2+1]<arr[tmpIdx*2]) {
					if(arr[tmpIdx*2+1]<arr[tmpIdx]) {
						int tmp = arr[tmpIdx];
						arr[tmpIdx]=arr[tmpIdx*2+1];
						arr[tmpIdx*2+1]=tmp;
						tmpIdx = tmpIdx*2+1;							
					}else {
						break;
					}
				}else {
					if(arr[tmpIdx*2]<arr[tmpIdx]) {
						int tmp = arr[tmpIdx];
						arr[tmpIdx]=arr[tmpIdx*2];
						arr[tmpIdx*2]=tmp;
						tmpIdx = tmpIdx*2;
					}else{
						break;
					}
					
				}
			}
			
			
			return rt;
		}
	}

}
