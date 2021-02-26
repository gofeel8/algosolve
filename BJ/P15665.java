import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * 중복순열인데 중복된 결과만제거
 *
 */
public class P15665 {

	static int[] arr;
	static int N;
	static int[] input;
	static Set<String> set;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		arr = new int[M];

		set = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		perm(0,M);
		
		bw.flush();
		bw.close();
	}

	private static void perm(int now, int end) throws IOException {
		if(now == end) {
			String str = Arrays.toString(arr);
			if(set.contains(str)) {
				return;
			}
			set.add(str);
			for(int i=0;i<arr.length;i++){
				bw.write(arr[i]+" ");
			}
			bw.newLine();
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[now]=input[i];
			perm(now+1,end);
		}
		
		
		return;
		
	}
	

}
