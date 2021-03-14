import java.io.*;
import java.util.*;

public class P12852 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[N+1];  // 최소 cnt 저장
		int[] root =new int[N+1];  //앞에 부모 저장
		
		root[1]=-1;

		int plus,two,three;
		for(int i=1;i<=N;i++) {
			plus=i+1;
			two=i*2;
			three =i*3;
			
			if(plus<=N) {
				if(arr[plus]==0 || arr[plus]>arr[i]+1) {
					arr[plus]=arr[i]+1;
					root[plus]=i;
				}
			}
			
			if(two<=N) {
				if(arr[two]==0 || arr[two]>arr[i]+1) {
					arr[two]=arr[i]+1;
					root[two]=i;
				}
			}
			
			if(three<=N) {
				if(arr[three]==0 || arr[three]>arr[i]+1) {
					arr[three]=arr[i]+1;
					root[three]=i;
				}
			}
			
		}
		
//		System.out.println(arr[N]);
		bw.write(arr[N]+"");
		bw.newLine();
		
		int idx = N;
		while(idx != -1) {
			bw.write(idx +" ");
			idx = root[idx];
		}
		
		bw.flush();
		bw.close();

	}

}
