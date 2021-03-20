package Line;

import java.util.*;

public class P2 {

	public static boolean[] type = new boolean[4];
	public static Map<Character, Integer> count = new HashMap<Character, Integer>(); 
	public static char backChar;
	public static int sameCnt;
	public static boolean sameFlag = false;
	
	public static void main(String[] args) {
		
		String inp_str= "UUUUU";
		
		List<Integer> list = new ArrayList<>();
		if(Check1(inp_str)==false) {
			list.add(1);
		}
		if(Check2(inp_str)==false) {
			list.add(2);
		}
		if(Check3(inp_str)==false) {
			list.add(3);
		}
		if(Check4(inp_str)==false) {
			list.add(4);
		}
		if(Check5(inp_str)==false) {
			list.add(5);
		}
		int listSize = list.size();
		int[] answer;
		if(listSize==0) {
			answer = new int[1];
			return answer;
		}else {
			answer = new int[listSize];
			for(int i=0;i<listSize;i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}
	
	
	public static boolean Check1(String str) {  //������ �����Ϲ� true
		if(str.length()>=8 && str.length()<=15) {
			return true;
		}
		return false;
	}
	
	public static boolean Check2(String str) {  //������ �����Ϲ� true
//		password�� �Ʒ� 4 ������ ���� �׷��� ������, �ٸ� � ���ڵ� �����ؼ��� �ȵ˴ϴ�.
//		[0] ���ĺ� �빮��(A~Z)
//		[1] ���ĺ� �ҹ���(a~z)
//		[2] ����(0~9)
//		[3] Ư������(~!@#$%^&*)
		boolean flag = true;
		for(int i=0;i<str.length();i++) {
			char now = str.charAt(i);
			if(i==0) {
				backChar=now;
				int sameCnt =1;
			}else {
				if(now==backChar) {
					sameCnt++;
					if(sameCnt==4) {
						sameFlag = true;
					}
				}else {
					backChar = now;
					sameCnt=1;
				}
				
			}
			
			
			if(Character.isUpperCase(now)) {
				type[0]=true;
				count.put(now, count. getOrDefault(now, 0)+1);
			}else if(Character.isLowerCase(now)) {
				type[1]=true;
				count.put(now, count. getOrDefault(now, 0)+1);
			}else if(Character.isDigit(now)) {
				type[2]=true;
				count.put(now, count. getOrDefault(now, 0)+1);
			}else if(now=='~' ||now=='!' ||now=='@' || now=='#' || now=='$' || now=='%' || now=='^' || now=='&' ||now=='*') {
				type[3]=true;
				count.put(now, count. getOrDefault(now, 0)+1);
			}else {
				count.put(now, count. getOrDefault(now, 0)+1);
				flag = false;
			}
		}
		return flag;
	}
	
	public static boolean Check3(String str) {  //������ �����Ϲ� true
		int cnt =0;
		for(int i=0;i<4;i++) {
			if(type[i])cnt++;
		}
		if(cnt<3) {
			return false;
		}
		
		return true;
	}
	
	public static boolean Check4(String str) {  //������ �����Ϲ� true
		//password�� ���� ���ڰ� 4�� �̻� ���ӵ� �� �����ϴ�.
		if(sameFlag) {
			return false;
		}
		return true;
	}
	
	
	public static boolean Check5(String str) {  //������ �����Ϲ� true
		//password�� ���� ���ڰ� 5�� �̻� ���Ե� �� �����ϴ�.
		  Iterator<Character> keys = count.keySet().iterator();
	        while( keys.hasNext() ){
	            Character key = keys.next();
	            int now = count.get(key);
	            if(now>=5) {
	            	return false;
	            }
	        }
		return true;
	}
	
	
}
