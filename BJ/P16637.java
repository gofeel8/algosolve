import java.util.*;
import java.io.*;

public class P16637 {
//나누기 0 처리
	public static List<Integer> num;
	public static List<Character> command;
	public static boolean[] selected;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		String str = br.readLine();
		answer =Integer.MIN_VALUE;
		num = new ArrayList<Integer>();
		command  = new ArrayList<Character>();

		for(int i=0;i<str.length();i++) {
			if((i+1)%2==1) {
				num.add(str.charAt(i)-'0');
			}else {
				command.add(str.charAt(i));
			}
		}
		
		selected = new boolean[command.size()];
		
		
		sub(0);
		System.out.println(answer);
	}
	private static void sub(int idx) {
		if(idx == command.size()) {
			int [] tmp = new int[command.size()];
			for(int i=0;i<selected.length;i++) {
				if(selected[i]) { // 먼저 연산 처리
					tmp[i]=calc(command.get(i),num.get(i),num.get(i+1));
				}
			}
			int result = num.get(0);
			for(int i=0;i<selected.length;i++) {
				if(i+1<selected.length&&selected[i+1]==false) {
					result= calc(command.get(i),result,num.get(i+1));
				}else if(i+1<selected.length&&selected[i+1]==true) {
					result= calc(command.get(i),result,tmp[i+1]);
					i++;
				}else {
					result= calc(command.get(i),result,num.get(i+1));					
				}
			}
			answer = Math.max(answer, result);
			return;
		}
			if(idx==0 || selected[idx-1]==false) {
				selected[idx]=true;
				sub(idx+1);
			}
			selected[idx]=false;
			sub(idx+1);
	}
	
	private static int calc(char c,int a,int b) {
		switch (c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return -1;
	}

}
