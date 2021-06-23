import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer>list = new ArrayList<>();
        Queue<int []> queue = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            queue.add(new int[] {progresses[i],speeds[i]});
        }
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int cnt =1;
            int day;
            if((100-now[0])%now[1]==0){
                day =(100-now[0])/now[1];
            }else{
                day =(100-now[0])/now[1]+1;
            }
            
            while(!queue.isEmpty()&& (queue.peek()[0]+queue.peek()[1]*day)>=100){
                queue.poll();
                cnt++;
            }
            
            list.add(cnt);
        }

        answer =new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
