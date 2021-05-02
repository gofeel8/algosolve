import java.io.*;
import java.util.*;

public class P14570 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long K = Long.parseLong(br.readLine());
		
		int start = 1;
		while(true) {
			//양갈래길 찾기
				//양갈래길 찾았을 경우
			if(arr[start][0] != -1 && arr[start][1] != -1) {
				//홀수 개는 왼쪽  짝수개는 오른쪽 
				if(K%2==0) {
					start = arr[start][1];
					K = K/2;
				}else {
					start = arr[start][0];
					K = (K+1)/2;
				}
			}
			
			//외길일 경우 그냥 내려가
			else if(arr[start][0] != -1) {
				start =arr[start][0];
			}
			
			else if(arr[start][1] != -1) {
				start =arr[start][1];
			}
			
			   //막다른길일경우 거기가 답
			else if(arr[start][0] == -1 && arr[start][1] == -1) {
				System.out.println(start);
				return;
			}
			
			
		}
	}

}
