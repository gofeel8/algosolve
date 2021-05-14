package ProgrammersChallengeS2;

import java.util.Arrays;

public class D2_P2_2 {
	
	public static void main(String[] args) {
		long[] numbers = {2,7};
		
	 	long[] answer = new long[numbers.length];
		
			for(int t=0;t<numbers.length;t++) {
				long now = numbers[t];
				for(int idx = 0;(1<<idx)<=now+1;idx++) {
					if((now&(1l<<idx))==0) {
						if(idx==0) {
							answer[t] = now+1;
							break;
						}else {
							answer[t] = now + (1l<<idx) - (1l<<(idx-1));
							break;
						}
					}
				}
			}
		System.out.println(Arrays.toString(answer));
	}

}
