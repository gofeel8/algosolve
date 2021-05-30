import java.io.*;
import java.util.*;

public class P1717 {
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			 st = new StringTokenizer(br.readLine());
			 int c = Integer.parseInt(st.nextToken());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 if(c==0) {                   // 합치는 연산
				 if(a==b)continue;
				 int pa = findParent(a);
				 int pb = findParent(b);
				 if(pa==pb)continue;
				 parent[pa]=pb;
			 }else if(c==1) {            // 같은집합인지 yes no
				 int pa = findParent(a);
				 int pb = findParent(b);

				 if(pa==pb)bw.write("YES");
				 else bw.write("NO");
				 bw.newLine();
			 }
		}
		
		bw.flush();
		bw.close();
		

	}
	
	public static int findParent(int num) {
		if(parent[num]==num) {
			return num;
		}
		return parent[num] = findParent(parent[num]);
	}

}
