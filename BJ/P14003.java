package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] parent = new int[N+1];
		List<Integer> lisIdx = new ArrayList<Integer>();
		
		StringTokenizer  st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		
		lisIdx.add(1);
		
		for(int i=2;i<=N;i++) {
			int now = arr[i];
			int left = 0;
			int right = lisIdx.size();
			int idx =0;
			while(left<=right) {
				int mid = (left+right)/2;
				if(mid == lisIdx.size()) {
					break;
				}
				
				if(now>arr[lisIdx.get(mid)]) {
					left = mid+1;
					idx = left;
				}else if(now <arr[lisIdx.get(mid)]) {
					right = mid-1;
				}else {
					break;
				}
			}
			if(idx<lisIdx.size()) {
				lisIdx.remove(idx);
			}
			lisIdx.add(idx,i);
			if(idx-1 >=0) {
				parent[i]=lisIdx.get(idx-1);
			}
		}
		
		bw.write(Integer.toString(lisIdx.size()));
		bw.newLine();
		Stack<Integer> out = new Stack<>();
		int tmp = lisIdx.get(lisIdx.size()-1);
		
		while(tmp!=0) {
			out.push(arr[tmp]);
			tmp = parent[tmp];
		}
		
		while(!out.isEmpty()) {
			bw.write(out.pop()+" ");
		}
		bw.flush();
		bw.close();
	}

}


