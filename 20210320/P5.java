package Line;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P5 {

	public static void main(String[] args) {
		String program = "line";
//		String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
		String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
//		String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};
		String[] commands = {"line -s 123 -n HI", "line fun"};
		
		/**
		 *  flag_rules �� ������ ã�� ���� Map �ڷ� ������ �����Ѵ�
		 */
		Map<String, String> flagMap = new HashMap<String, String>();
		StringTokenizer flagSt;
		for(int i=0;i<flag_rules.length;i++) {
			flagSt = new StringTokenizer(flag_rules[i]);
			String fName = flagSt.nextToken();
			String fType = flagSt.nextToken();
			if(!flagMap.containsKey(fName)) {
				flagMap.put(fName, fType);
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
            Set<String> used = new HashSet<>();                      //����� flag�� �����ϱ� ���� Set �ڷᱸ��
            
			Queue<String> cQueue = new LinkedList<String>();        //�Է¹��� ��ɾ ����������� ������ ���Լ��� ������ ������ Queue �ڷᱸ��
			StringTokenizer commandSt;
			commandSt = new StringTokenizer(commands[i]);           
			while(commandSt.hasMoreTokens()) {     
				cQueue.add(commandSt.nextToken());                  
			}
			
			boolean findError = false;                              //������ ��� �����ϳ� Ȯ���ϱ� ����  boolean ���� ����
			
			String getProgram = cQueue.poll();                      //ť�� ���� ���� ����� ���α׷� �̸� Ȯ��      
			if(!getProgram.equals(program)) {                 
				answer[i]=false;
				continue;
			}
			
			while(cQueue.size()>0) {                               //ť ����� 0�϶����� �ݺ�
				String flag =cQueue.poll();
				if(used.contains(flag)) {                          //������ ��Ÿ���� �÷��׸� �� ����Ϸ��� �ϱ� ������ ������ �������� �ʴ´�.
					findError=true;
					break;
				}
				
				used.add(flag);                                   //ó�� ���Ǵ� flag�� ��� set�� �߰��Ѵ�
				
				if(flag.charAt(0)!='-') {                         // flag�� - �� ���� ���ϴ� ��� �� ���� ��ɾ�� �����Ѵ�.
					findError=true;
					break;
				}
				
				if(cQueue.size()==0)break;                       // ť�� ����� ��� ���� ���´�
				
				String type;
				if(flagMap.containsKey(flag)) {                  // �÷��׸� ������ Map ���� type �Ӽ��� �����´� 
					type = flagMap.get(flag); 
				}else {                                          // �������� ���� flag�� �Է����� ��� 
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
					} catch (NumberFormatException e) {          // ���� ���ڰ� ���ڰ� �ƴ� ���
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
				}
			}
			if(findError) {                                  //������ �������� ������ ��� 
				answer[i]=false;
			}
		}
		
		System.out.println(Arrays.toString(answer));

	}

}
