import java.io.*;
import java.util.*;

public class P1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x1 = Integer.parseInt(st.nextToken());
			double y1 = Integer.parseInt(st.nextToken());
			double r1 = Integer.parseInt(st.nextToken());
			double x2 = Integer.parseInt(st.nextToken());
			double y2 = Integer.parseInt(st.nextToken());
			double r2 = Integer.parseInt(st.nextToken());
			
			//두 점사이 거리 구하기
			double gap = Math.sqrt((Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)));
//			System.out.println(gap);
			
			if(Double.compare(x1, x2)==0 &&Double.compare(y1, y2)==0 ) {
				System.out.println(Double.compare(r1, r2) == 0 ? -1 : 0);
			}else if(Double.compare(gap, r1)>0 && Double.compare(gap, r2)>0) {
				if(Double.compare(r1+r2, gap)==0) {
					System.out.println(1);
				}else if(Double.compare(r1+r2, gap)>0) {
					System.out.println(2);
				}else {
					System.out.println(0);
				}
			}else {
				Double less = Double.min(r1, r2);
				Double more = Double.max(r1, r2);
				if(Double.compare(less+gap, more)==0) {
					System.out.println(1);
				}else if(Double.compare(less+gap, more)>0) {
					System.out.println(2);
				}else {
					System.out.println(0);
				}
			}
			
		}

	}

}
