import java.io.*;
import java.util.*;
public class P9081 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		for(int t=0;t<T;t++) {
			str =br.readLine();
			char[] arr = str.toCharArray();
			//꼭대기 찾고
			int i = str.length()-1;
			
			while(i>0 && arr[i-1]>=arr[i])i--;
			
			if(i==0) {
				System.out.println(str);
				continue;
			}
			//뒤에서 바꿀놈 찾고
			int now = arr[i-1];
			
			int l =str.length()-1;
			while(l>0 && arr[l]<=now)l--;
			
			//바꾸고
			char tmp = arr[i-1];
			arr[i-1]=arr[l];
			arr[l]=tmp;
			
			l=str.length()-1;
			
			//정렬하고
			while(i<l) {
				tmp = arr[i];
				arr[i]=arr[l];
				arr[l]=tmp;
				i++;
				l--;
			}
			System.out.println(String.copyValueOf(arr));
		}
	}

}
