import java.util.*;
import java.io.*;
public class P14267 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] score  = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			score[a]+=b;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1;i<=N;i++) {
			if(parent[i]== -1) {
				bw.write("0 ");
			}else {
				score[i] += score[parent[i]];
				bw.write(String.valueOf(score[i])+" ");
			}
		}
		bw.flush();
		bw.close();

	}

}
