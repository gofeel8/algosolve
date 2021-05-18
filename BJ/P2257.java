import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class P2257 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		
		for(int i=0;i<str.length();i++) {
			char now  =str.charAt(i);
			
			if(Character.isAlphabetic(now)) {
					left.push(now);
			}else if(Character.isDigit(now)) {
				char tmp = left.pop();
				int num = now-'0';
				for(int h=0;h<num;h++) {
					left.push(tmp);
				}
				
			}else {    // 괄호 처리
				if(now=='(') {
					left.push(now);
				}else if(now ==')') {
					//뒤에 숫자인지
					if(i+1<str.length()&& Character.isDigit(str.charAt(i+1))) {
						//숫자이면 앞에 괄호 만날때까지의 알파벳들 숫자 만큼 곱해줘야함
						while(left.peek() != '(') {
							right.push(left.pop());
						}
						left.pop();
						
						int num = str.charAt(i+1)-'0';
						
						while(!right.isEmpty()) {
							char tmp = right.pop();
							for(int j=0;j<num;j++) {
								left.push(tmp);
							}
						}
						
						i++;
					}else {
						//
						while(left.peek() != '(') {
							right.push(left.pop());
						}
						left.pop();
						
						while(!right.isEmpty()) {
							char tmp = right.pop();
							left.push(tmp);
						}
					}
				}
			}
			
		}
		
		int ans = 0;
		while(!left.isEmpty()) {
			char now = left.pop();
			switch (now) {
			case 'O':
				ans+=16;
				break;
			case 'H':
				ans+=1;
				break;
			case 'C':
				ans+=12;
				break;

			default:
				break;
			}
		}
		System.out.println(ans);

	}

}
