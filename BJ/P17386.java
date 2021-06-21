import java.io.*;
import java.util.*;

public class P17387 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node N1 = new Node(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Node N2 = new Node(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		
		int a = ccw(N1.x1,N1.x2,N2.x1,N1.y1,N1.y2,N2.y1);  //abc
		int b = ccw(N1.x1,N1.x2,N2.x2,N1.y1,N1.y2,N2.y2);  //abd
		
		int c = ccw(N2.x1,N2.x2,N1.x1,N2.y1,N2.y2,N1.y1);  //cda
		int d = ccw(N2.x1,N2.x2,N1.x2,N2.y1,N2.y2,N1.y2);  //cdb
		
		int ab = a*b;    //abc * abd
		int cd = c*d;    //cda * cdb
		
		if(ab==0&&cd==0) {
			if(N1.x1<=N2.x2&& N2.x1<=N1.x2) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}else {
			if(ab<=0 && cd <=0) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
		
		
		
	}
	public static int ccw(long x1,long x2,long x3, long y1, long y2,long y3) {
		long tmp = (x1*y2)+(x2*y3)+(x3*y1)-(x2*y1)-(x3*y2)-(x1*y3);
		if(tmp > 0 ) {
			return 1; //반시계
		}else if(tmp<0) {
			return -1; //시계
		}else {
			return 0; //일직선
		}
	}
	
	public static class Node{
		long x1;
		long y1;
		long x2;
		long y2;
		Node(long a1,long b1,long a2,long b2){
			if(a1>a2) {
				long tmp = a1;
				a1 = a2;
				a2=tmp;
				tmp = b1;
				b1 =b2;
				b2 = tmp;
			}
			this.x1=a1;
			this.y1=b1;
			this.x2=a2;
			this.y2=b2;
		}
	}
}
