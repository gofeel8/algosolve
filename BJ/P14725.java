import java.util.*;
import java.io.*;

public class P14725 {
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		Node first = new Node("first");
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String[] get = new String[num];
			for(int j=0;j<num;j++) {
				get[j] = st.nextToken();
			}
			first.insert(get, 0);
		}
		
		first.print(0);
		 
		
		
		
		bw.flush();
		bw.close();

	}
	
	
	public static class Node{
		String value;
		List<Node> list;
		Node(String v){
			value = v;
			list = new ArrayList<>();
		}
		
		public void insert(String[] arr,int idx) {
			if(idx==arr.length) {
				return;
			}
			
			String now = arr[idx];
			
			for(int i=0;i<list.size();i++) {
				Node tmp = list.get(i);
				if(tmp.value.equals(now)) {
					tmp.insert(arr, idx+1);
					return;
				}
			}
			
			list.add(new Node(now));
			list.get(list.size()-1).insert(arr, idx+1);
			
		}
		
		public void print(int depth) throws IOException {
			Collections.sort(list,new Comparator<Node>() {
				@Override
				public int compare(Node n1,Node n2) {
					return n1.value.compareTo(n2.value);
				}
			});
			
			for(int i=0;i<list.size();i++) {
				Node tmp = list.get(i);
				for(int j=0;j<depth;j++) {
					bw.append("--");
				}
				bw.append(tmp.value);
				bw.newLine();
				list.get(i).print(depth+1);
			}
			
		}
		
	}

}
