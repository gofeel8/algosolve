import java.util.*;
import java.io.*;

public class P1484 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		

		int y =1;
		int x =1;
		boolean find = false;
		while(y<=x) {
			
			int x2= x*x;
			int y2= y*y;
			
			if(x2-y2==G) {
				System.out.println(x);
				y++;
				find = true;
			}else if(x2-y2<G) {
				x++;
			}else if(x2-y2>G) {
				if(x-y==1)break;
				y++;
			}
		}
		
		if(find==false) {
			System.out.println(-1);
		}
	}

}
