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
		 *  flag_rules �� ������ ã�� ���� Map �ڷ� ������ �����Ѵ�
		 *  alais�� ����ϱ� ���� Map �ڷᱸ���� �����Ѵ�.
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
		 *   ������ �����ϱ��� �� answer �迭 ���� �� �ʱ�ȭ
		 */
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		
		/**
		 *   �Է¹��� commands �� �ϳ���  ��ȿ�� �˻縦 �����Ѵ�
		 */
		for(int i=0;i<commands.length;i++) {
            Set<String> used = new HashSet<>();						//����� flag�� �����ϱ� ���� Set �ڷᱸ��
			Queue<String> cQueue = new LinkedList<String>();		//�Է¹��� ��ɾ ����������� ������ ���Լ��� ������ ������ Queue �ڷᱸ��
			StringTokenizer commandSt;
			commandSt = new StringTokenizer(commands[i]);
			while(commandSt.hasMoreTokens()) {
				cQueue.add(commandSt.nextToken());
			}
			
			boolean findError = false;                                //������ ��� �����ϳ� Ȯ���ϱ� ����  boolean ���� ����
			String getProgram = cQueue.poll();                      //ť�� ���� ���� ����� ���α׷� �̸� Ȯ��     
			if(!getProgram.equals(program)) {
				answer[i]=false;
				continue;
			}
			
			while(cQueue.size()>0) {                               //ť ����� 0�϶����� �ݺ�
				String flag =cQueue.poll();
				if(flag.charAt(0)!='-') {                          // flag�� - �� ���� ���ϴ� ��� �� ���� ��ɾ�� �����Ѵ�.
					findError=true;
					break;
				}
				if(cQueue.size()==0)break;
				
				if(aliasMap.containsKey(flag)) {				  //flag �� Alias�� �ԷµǾ��� ��� ������ flag�� �ٲ��ش� 
					flag = aliasMap.get(flag);
				}
				
				
				if(used.contains(flag)) {                          //������ ��Ÿ���� �÷��׸� �� ����Ϸ��� �ϱ� ������ ������ �������� �ʴ´�.
					findError=true;
					break;
				}
				used.add(flag);                                   //ó�� ���Ǵ� flag�� ��� set�� �߰��Ѵ�
				
				String type;
				if(flagMap.containsKey(flag)) {                 // �÷��׸� ������ Map ���� type �Ӽ��� �����´� 
					type = flagMap.get(flag);
				}else {                                         // �������� ���� flag�� �Է����� ��� 
					findError=true;
					break;
				}
				
				
				if(type.equals("NULL")) {                        // flag�� NULL�� ��� ���ڰ� ���� �ʿ����� �ʴ�
					if(cQueue.size()==0)break;
					
					String next =cQueue.peek();
					if(next.charAt(0)!='-') {                    //�ڿ� ���ڰ� ������� �߸��� ��ɾ�� �����Ѵ�
						findError=true;
						break;
					}
				}else if(type.equals("NUMBER")){                 // flag�� NUMBER�� ��� ���ڰ� ���ڿ��� �Ѵ�
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					String shouldNum = cQueue.poll();
					try {
						int num  = Integer.parseInt(shouldNum);
					} catch (NumberFormatException e) {                 // ���� ���ڰ� ���ڰ� �ƴ� ���
						findError=true;
						break;
					}
					
				}else if(type.equals("NUMBERS")) {                // flag�� NUMBERS�� ��� ���ڰ� 1���̻��� ���ڿ��� �Ѵ�
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					
					boolean ureka = false;                                 //1���̻��� ���� �� �߸��� ������ ã���� ��� true
					while(cQueue.peek().charAt(0)!='-') {
						String shouldNum = cQueue.poll();
						try {
							int num  = Integer.parseInt(shouldNum);
						} catch (NumberFormatException e) {              // ���� ���ڰ� ���ڰ� �ƴ� ���
							ureka=true;
							break;
						}
					}
					if(ureka) {                           //1���̻��� ���� �� �߸��� ������ ã���� ���
						findError=true;
						break;
					}
					
				}else if(type.equals("STRING")){                // flag�� STRING �� ��� ���ڰ� ���ڿ��� �Ѵ�
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					String shouldString =  cQueue.poll();
					for(int q=0;q<shouldString.length();q++) {
						if(!Character.isLetter(shouldString.charAt(q))) {   //���� ���ڿ� ���ڰ� �ƴѰ� ���Ե� ���
							findError=true;
							break;
						}
					}
				}else if(type.equals("STRINGS")) {              // flag�� STRINGS�� ��� ���ڰ� 1���̻��� ���ڿ��� �Ѵ�
					if(cQueue.size()==0) {
						findError=true;
						break;
					}
					
					boolean ureka = false;                      //1���̻��� ���� �� �߸��� ������ ã���� ��� true
					while(cQueue.peek().charAt(0)!='-') {
						String shouldString =  cQueue.poll();
						for(int q=0;q<shouldString.length();q++) {
							if(!Character.isLetter(shouldString.charAt(q))) {   //���� ���ڿ� ���ڰ� �ƴѰ� ���Ե� ���
								ureka=true;
								break;
							}
						}
					}
					if(ureka) {          //1���̻��� ���� �� �߸��� ������ ã���� ���
						findError=true;
						break;
					}
					
				}
			}
			if(findError) {                                 //������ �������� ������ ��� 
				answer[i]=false;
			}
		}
	
		System.out.println(Arrays.toString(answer));

	}
}
