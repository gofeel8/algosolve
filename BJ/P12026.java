import java.io.*;
import java.util.*;

public class P12026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] energy = new int[N];
		Arrays.fill(energy, Integer.MAX_VALUE);
		energy[0]=0;
		for(int i=0;i<N;i++) {
			if (energy[i]==Integer.MAX_VALUE) continue;
			for(int j=i+1;j<N;j++) {
				if(str.charAt(i) == 'B' && str.charAt(j)=='O' ||str.charAt(i) == 'O' && str.charAt(j)=='J' ||  str.charAt(i) == 'J' && str.charAt(j)=='B' ) {
					int tmp =energy[i]+(int)Math.pow(j-i, 2);
					if(energy[j]==0 || energy[j]>tmp) {
						energy[j]=tmp;
					}
				}
				
			}
		}
		System.out.println(energy[N-1]==Integer.MAX_VALUE ? -1 : energy[N-1]);
		
		
	}

}
