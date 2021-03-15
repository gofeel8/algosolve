import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1527 {
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		
		DFS(0,A,B);
		System.out.println(result);

	}

	private static void DFS(long now, int A, int B) {
		if(now>=A && B>=now) {
			result++;
		}
		
		if(now>B)return;
		
		DFS(now*10+4,A,B);
		DFS(now*10+7,A,B);
		
		
	}

}
