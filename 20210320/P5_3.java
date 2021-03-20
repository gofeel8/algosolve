package Line;

import java.util.*;
public class P5_3 {
	public static void main(String[] args) {
//		String program = "line";
//		String[] flag_rules = {"-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"};
//		String[] commands = {"line -n 100 -s hi -e", "line -n 100 -e -num 150"};
		String program = "bank";
		String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
		String[] commands = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};
			
		/**
		 *  flag_rules 를 빠르게 찾기 위해 Map 자료 구조에 저장한다
		 *  alais를 기억하기 위해 Map 자료구조에 저장한다.
		 */
		Map<String, String> flagMap = new HashMap<String, String>();
		Map<String, String> aliasMap = new HashMap<String, String>();
		StringTokenizer flagSt;
		for(int i=0;i<flag_rules.length;i++) {
			flagSt = new StringTokenizer(flag_rules[i]);
			String fName = flagSt.nextToken();
			String fType = flagSt.nextToken();
			if(fType.equals("ALIAS")) {
				String fName2 =flagSt.nextToken();
				aliasMap.put(fName, fName2);
			}else {
				if(!flagMap.containsKey(fName)) {
					flagMap.put(fName, fType);
				}
			}
		}
		
		
		/**
		 *   정답을 저장하기위 한 answer 배열 생성 및 초기화
		 */
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		
		/**
		 *   입력받은 commands 를 하나씩  유효성 검사를 시작한다
		 */
		for(int i=0;i<commands.length;i++) {
            Set<String> used = new HashSet<>();						//사용한 flag를 저장하기 위한 Set 자료구조
			Queue<String> cQueue = new LinkedList<String>();		//입력받은 명령어를 공백기준으로 나눠서 선입선출 구조로 저장할 Queue 자료구조
			StringTokenizer commandSt;
			commandSt = new StringTokenizer(commands[i]);
			while(commandSt.hasMoreTokens()) {
				cQueue.add(commandSt.nextToken());
			}
			
			boolean findError = false;                                //조건을 모두 만족하나 확인하기 위한  boolean 변수 선언
			String getProgram = cQueue.poll();                      //큐에 제일 먼저 저장된 프로그램 이름 확인     
			if(!getProgram.equals(program)) {
				answer[i]=false;
				continue;
			}
			
			while(cQueue.size()>0) {                               //큐 사이즈가 0일때까지 반복
				String flag =cQueue.poll();
				if(flag.charAt(0)!='-') {                          // flag가 - 로 시작 안하는 경우 잘 못된 명령어로 간주한다.
					findError=true;
					break;
				}
				if(cQueue.size()==0)break;
				
				if(aliasMap.containsKey(flag)) {				  //flag 가 Alias로 입력되었을 경우 원래의 flag로 바꿔준다 
					flag = aliasMap.get(flag);
				}
				
				
				if(used.contains(flag)) {                          //이전에 나타났던 플래그를 또 사용하려고 하기 때문에 조건을 만족하지 않는다.
					findError=true;
					break;
				}
				used.add(flag);                                   //처음 사용되는 flag일 경우 set에 추가한다
				
				String type;
				if(flagMap.containsKey(flag)) {                 // 플래그를 저장한 Map 에서 type 속성을 가져온다 
					type = flagMap.get(flag);
				}else {                                         // 지정되지 않은 flag를 입력했을 경우 
					findError=true;
					break;
				}
				
				
				if(type.equals("NULL")) {                        // flag가 NULL일 경우 인자가 따로 필요하지 않다
					if(cQueue.size()==0)break;
					
					String next =cQueue.peek();
					if(next.charAt(0)!='-') {                    //뒤에 인자가 붙은경우 잘못된 명령어로 간주한다
						findError=true;
						break;
					}
				}else if(type.equals("NUMBER")){                 // flag가 NUMBER일 경우 인자가 숫자여야 한다
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					String shouldNum = cQueue.poll();
					try {
						int num  = Integer.parseInt(shouldNum);
					} catch (NumberFormatException e) {                 // 받은 인자가 숫자가 아닌 경우
						findError=true;
						break;
					}
					
				}else if(type.equals("NUMBERS")) {                // flag가 NUMBERS일 경우 인자가 1개이상의 숫자여야 한다
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					
					boolean ureka = false;                                 //1개이상의 인자 중 잘못된 조건을 찾았을 경우 true
					while(cQueue.peek().charAt(0)!='-') {
						String shouldNum = cQueue.poll();
						try {
							int num  = Integer.parseInt(shouldNum);
						} catch (NumberFormatException e) {              // 받은 인자가 숫자가 아닌 경우
							ureka=true;
							break;
						}
					}
					if(ureka) {                           //1개이상의 인자 중 잘못된 조건을 찾았을 경우
						findError=true;
						break;
					}
					
				}else if(type.equals("STRING")){                // flag가 STRING 일 경우 인자가 문자여야 한다
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					String shouldString =  cQueue.poll();
					for(int q=0;q<shouldString.length();q++) {
						if(!Character.isLetter(shouldString.charAt(q))) {   //받은 인자에 문자가 아닌게 포함된 경우
							findError=true;
							break;
						}
					}
				}else if(type.equals("STRINGS")) {              // flag가 STRINGS일 경우 인자가 1개이상의 숫자여야 한다
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					
					boolean ureka = false;                      //1개이상의 인자 중 잘못된 조건을 찾았을 경우 true
					while(cQueue.peek().charAt(0)!='-') {
						String shouldString =  cQueue.poll();
						for(int q=0;q<shouldString.length();q++) {
							if(!Character.isLetter(shouldString.charAt(q))) {   //받은 인자에 문자가 아닌게 포함된 경우
								ureka=true;
								break;
							}
						}
					}
					if(ureka) {          //1개이상의 인자 중 잘못된 조건을 찾았을 경우
						findError=true;
						break;
					}
					
				}
			}
			if(findError) {                                 //조건을 만족하지 못했을 경우 
				answer[i]=false;
			}
		}
	
		System.out.println(Arrays.toString(answer));

	}
}
