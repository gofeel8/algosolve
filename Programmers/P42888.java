import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = new String[record.length];
        
        Map<String,String> map = new HashMap<>();
        Queue<String[]> queue = new LinkedList<>();
        for(int i=0;i<record.length;i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                map.put(arr[1],arr[2]);
                queue.add(new String[] {arr[1],"님이 들어왔습니다."});
            }else if(arr[0].equals("Leave")){
                queue.add(new String[] {arr[1],"님이 나갔습니다."});                
            }else if(arr[0].equals("Change")){
                map.put(arr[1],arr[2]);
            }
        }
        
        answer = new String[queue.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=map.get(queue.peek()[0])+queue.poll()[1];
        }
        return answer;
    }
}
