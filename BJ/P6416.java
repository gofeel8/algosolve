import java.util.*;
import java.io.*;

public class P6416 {

	public static void main(String[] args) throws IOException {
		int idx =1;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a=0;
		int b=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean ans = true;
			Set<Integer> set = new HashSet<>();
			Map<Integer,Integer> map = new HashMap<Integer, Integer>();
			while(true) {
				while(true) {
					a= sc.nextInt();
					b=sc.nextInt();
					if(a<=0)break;
					set.add(a);
					set.add(b);
					map.put(b, map.getOrDefault(b, 0)+1);
				}
				if(a==0) {
					if(set.size()==0)break;
					if(set.size() != map.size()+1) {
						ans = false;
						break;
					}
					if(map.size()!=0) {
						for(int tmp : map.keySet()) {
							if(map.get(tmp)>1) {
								ans = false;
								break;
							}
						}
					}
					break;
				}
				if(a<0)break;
			}
			if(a<0)break;
			
			if(ans) {
				bw.write("Case "+idx+++" is a tree.");
				bw.newLine();
			}else {
				bw.write("Case "+idx+++" is not a tree.");
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();

	}

}
