import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        while(!pq.isEmpty()&&pq.peek()<K){
            if(pq.size()==1){
                answer=-1;
                break;
            }
            int tmp = pq.poll()+pq.poll()*2;
            pq.add(tmp);
            answer++;
        }
        return answer;
    }
}
