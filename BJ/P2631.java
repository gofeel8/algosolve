import java.io.*;
import java.util.*;

public class P2631 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] lis = new int[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			int num = 0;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i]&&lis[j]>num)num=lis[j];
			}
			lis[i] = num+1;
			if(max<lis[i])max=lis[i];
		}
		System.out.println(N-max);
	}
	

}
