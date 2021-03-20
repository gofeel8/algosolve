package Line;

import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Comparator;

public class P4 {

	public static void main(String[] args) {
		String[] data = {"1 BROWN 0", "2 CONY 0", "3 DOLL 1", "4 DOLL 2", "5 LARGE-BROWN 3", "6 SMALL-BROWN 3", "7 BLACK-CONY 4", "8 BROWN-CONY 4"};
		String word = "BROWN";
		String[] answer ; 
		
		List<Node> list = new ArrayList<>();
		list.add(new Node(0, "ºó°Í", -1));
		for(int i=0;i<data.length;i++) {
			StringTokenizer st = new StringTokenizer(data[i]);
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			list.add(new Node(a,b,c));
			if(c!=0) {
				list.get(c).isleaf=false;
			}
		}
		
		PriorityQueue<Node> first = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.id-o2.id;
			}
		});
		
		
		PriorityQueue<Node> second = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				String one=  o1.name;
				String second=  o2.name;
				
				int oneCnt,secondCnd;
				
				int start = 0;
				while(one.ind)
				
				
				
			}
		});
		
		

	}
	
	public static class Node {
		int id;
		String name;
		int parent;
		boolean isleaf;
			Node(int i,String s, int p){{
				id = i;
				name = s;
				parent = p;
				isleaf = true;
			}
		}
	}
}
