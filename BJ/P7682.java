import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class P7682 {
	static int[][] check = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str =br.readLine();
			char[] arr = str.toCharArray();
			if(str.equals("end"))break;
			List<Integer> xlist = new ArrayList<Integer>();
			List<Integer> olist = new ArrayList<Integer>();
			for(int i=0;i<9;i++) {
				if(str.charAt(i)=='O'){
					olist.add(i);
				}else if(str.charAt(i)=='X') {
					xlist.add(i);
				}
			}
			
			if(xlist.size()==olist.size()) {
				//꽉차기 전에  O 를 놓고서 게임이 끝난 상태
				int cnt =0;
				for(int i=0;i<8;i++) {
					if(str.charAt(check[i][0])==str.charAt(check[i][1])&&str.charAt(check[i][1])==str.charAt(check[i][2])) {
						if(str.charAt(check[i][0])=='X') {
							cnt = 0;
							break;
						}else if(str.charAt(check[i][0])=='O') {
							
							cnt++;
						}
					}
				}
				if(cnt != 1) {
					System.out.println("invalid");
				}else {
					System.out.println("valid");
				}
			}else if(xlist.size()==olist.size()+1) {
				//꽉찬 상태
				if(xlist.size()==5) {
					boolean find = true;
					for(int i=0;i<xlist.size();i++) {
						int tmp = xlist.get(i);
						arr[tmp]='.';
						find = true;
						for(int j=0;j<8;j++) {
							if(arr[check[j][0]]==arr[check[j][1]]&& arr[check[j][1]]==arr[check[j][2]] ) {
								find=false;
								break;
							}
						}
						if(find) {
							break;
						}
						arr[tmp]='X';
					}
					if(find) {
						System.out.println("valid");						
					}else {
						System.out.println("invalid");
					}
					
				}else {
					//꽉차기 전에  X 를 놓고서 게임이 끝난 상태
					int cnt =0;
					for(int i=0;i<8;i++) {
						if(str.charAt(check[i][0])==str.charAt(check[i][1])&&str.charAt(check[i][1])==str.charAt(check[i][2])) {
							if(str.charAt(check[i][0])=='O') {
								cnt = 0;
								break;
							}else if(str.charAt(check[i][0])=='X') {
								cnt++;
							}
						}
					}
					if(cnt != 1) {
						System.out.println("invalid");
					}else {
						System.out.println("valid");
					}
				}
			}else {
				System.out.println("invalid");
			}
			
		}

	}

}
