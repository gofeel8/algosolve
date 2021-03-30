import java.util.*;
import java.io.*;
public class P1339_2 {

	public static List<Node> list;
	public static String[] arr;
	public static int[] num;
	public static boolean[] visited;
	public static int Max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		list = new ArrayList<Node>();
		for(int i=0;i<N;i++) {
			String str =br.readLine();
			arr[i]=str;
			int w=1;
			for(int j=str.length()-1;j>=0;j--) {
				char now = str.charAt(j);
				boolean flag = false;
				for(int q=0;q<list.size();q++) {
					if(list.get(q).alpha==now) {
						list.get(q).sum+=w;
						flag=true;
					}
				}
				if(flag == false) {
					list.add(new Node(now, w));
				}
				w*=10;
			}
		}
		
		Collections.sort(list);
			
		int sum=0;
		int num=9;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).sum*num;
			num--;
		}
		
		System.out.println(sum);

	}

	public static class Node implements Comparable<Node>{
		char alpha;
		int sum;
		
		Node(char a,int s){
			alpha=a;
			sum = s;
		}

		@Override
		public int compareTo(Node o) {
			return o.sum-sum;
		}
		
	}
	


}
