import java.util.Arrays; 

class Solution {
  
public static String solution(String[] participant, String[] completion) {
    String answer = "";
    
    
    Arrays.sort(participant);
    Arrays.sort(completion);
    
    for(int i=0;i<completion.length;i++) {
    if(participant[i].equals(completion[i])==false) {
    answer = participant[i];
                break;
    }
    }
    
    if(answer.equals("")) {
    answer = participant[participant.length-1];
    }
    
    
    
    
                    
            
    
        return answer;
    }

}
