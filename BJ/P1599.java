import java.io.*;
import java.util.*;

public class P1599 {

	public static Map<Character,Integer> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<Character, Integer>();
		map.put('a', 1);
		map.put('b', 2);
		map.put('k', 3);
		map.put('d', 4);
		map.put('e', 5);
		map.put('g', 6);
		map.put('h', 7);
		map.put('i', 8);
		map.put('l', 9);
		map.put('m', 10);
		map.put('n', 11);
		map.put('c', 12);
		map.put('o', 13);
		map.put('p', 14);
		map.put('r', 15);
		map.put('s', 16);
		map.put('t', 17);
		map.put('u', 18);
		map.put('w', 19);
		map.put('y', 20);
		
		PriorityQueue<MinLang> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			//ng 를 c로 바꿔야함
			String str = br.readLine();
			pq.add(new MinLang(str.replace("ng", "c")));
		}
		
		while(!pq.isEmpty()) {
			String str  = pq.poll().str;
			System.out.println(str.replaceAll("c", "ng"));
		}

	}
	
	public static class MinLang implements Comparable<MinLang>{
		String str;
		public MinLang(String str) {
			this.str = str;
		}
		

		@Override
		public int compareTo(MinLang o) {
			int size1 = this.str.length();
			int size2 = o.str.length();
			int min = (int)Math.min(size1, size2);
			for(int i=0;i<min;i++) {
				if(this.str.charAt(i) != o.str.charAt(i)) {
					return map.get(this.str.charAt(i))-map.get(o.str.charAt(i));
				}
			}
			return size1-size2;
		}
		
	}

}
