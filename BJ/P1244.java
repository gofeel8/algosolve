import java.io.*;
import java.util.*;
public class P1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			if(Integer.parseInt(st.nextToken())==1) {
				arr[i]=true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				// 남학생 ,  num의 배수들 상태 바꿈
				for(int j=num;j<=N;j=j+num) {
					arr[j]= !arr[j];
				}
			}else {
				// 여학생 ,  num을 기준으로 대칭인 구간 상태 바꿈
				arr[num] = !arr[num];
				for(int j=1;j<=N;j++){
					if(num-j==0 || num+j>N)break;
					if(arr[num-j]==arr[num+j]) {
						arr[num-j] = !arr[num-j];
						arr[num+j] = !arr[num+j];
					}else {
						break;
					}
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1;i<=N;i++) {
			if(arr[i]) {
				bw.write("1");
			}else {
				bw.write("0");
			}
			
			if(i==N) {
				break;
			}else if(i%20==0) {
				bw.newLine();
			}else {
				bw.write(" ");
			}
		}

		bw.flush();
		bw.close();
	}

}
