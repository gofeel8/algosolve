import java.util.*;
import java.io.*;
public class P6137 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		for(int i=0;i<N;i++) {
			arr[i] =br.readLine().charAt(0);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt =0;
		if(N==1) {
			bw.write(arr[0]);
		}else {
			int left=0;
			int right=N-1;
			
			
			while(left<=right) {
				if(arr[left]<arr[right]) {
					bw.write(arr[left]);
					left++;
					cnt++;
					if(cnt%80==0)bw.newLine();
				}else if(arr[left]>arr[right]) {
					bw.write(arr[right]);
					right--;
					cnt++;
					if(cnt%80==0)bw.newLine();
				}else {
					if(left==right) {
						bw.write(arr[left]);
//						cnt++;
//						if(cnt==80)bw.newLine();
						break;
					}
					int tmpleft=left+1;
					int tmpright=right-1;
					boolean startLeft = false;
					while(tmpleft<tmpright) {
						if(arr[tmpleft]>arr[tmpright]) {
							break;
						}else if(arr[tmpleft]<arr[tmpright]) {
							startLeft=true;
							break;
						}else {
							tmpleft++;
							tmpright--;
						}
					}
					if(startLeft) {
						bw.write(arr[left]);
						left++;
						cnt++;
						if(cnt%80==0)bw.newLine();
					}else {
						bw.write(arr[right]);
						right--;
						cnt++;
						if(cnt%80==0)bw.newLine();
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
		
		

	}

}
