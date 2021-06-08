import java.io.*;
import java.util.*;

public class P10800 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N =Integer.parseInt(br.readLine());
		List<int []> list = new ArrayList<>();
		
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new int[] {size,color,i});
		}
		
		Collections.sort(list,new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
		});
		
		int[] ans = new int[N];
		int[] sizeArr = new int[2001];
		int[] colorArr = new int[N+1];
		
		int total = 0;
		for(int i=0;i<list.size();i++) {
			int[] now = list.get(i);
			int size = now[0];
			int color = now[1];
			int idx  = now[2];
			
			total+=size;
			colorArr[color]+=size;
			sizeArr[size] += size;
			
			ans[idx] = total -colorArr[color]-sizeArr[size]+size;
			if(i>0 && list.get(i-1)[0]==size && list.get(i-1)[1]==color)ans[idx]=ans[list.get(i-1)[2]]; 	
		}
		
		for(int i=0;i<N;i++) {
			bw.write(String.valueOf(ans[i]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}
	

}
