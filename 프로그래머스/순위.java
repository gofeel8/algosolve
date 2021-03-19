package Programmers;

import java.util.Arrays;

public class 순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i=0;i<results.length;i++) {
			int win = results[i][0];
			int lose = results[i][1];
			graph[win][lose]=1;
		}
		
		for(int i=1;i<=n;i++) {      //경유
			for(int j=1;j<=n;j++) {   //출발
				if(i==j)continue;
				for(int q=1;q<=n;q++) {   //끝
					if(i==q || j==q) continue;
					if(graph[j][i]==1 && graph[i][q]==1) {
						graph[j][q]=1;
					}
				}	
			}	
		}
		int result = 0;
		
		for(int i=1;i<=n;i++) {
			int cnt =0;
			for(int j=1;j<=n;j++) {
				if(graph[i][j]==1 || graph[j][i]==1)cnt++;
			}
			if(cnt == n-1)result++;
		}
		
//		return result;
		System.out.println(result);
	}
		
		
}
