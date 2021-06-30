import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt = new int[N+2];
        for(int i=0;i<stages.length;i++){
            cnt[stages[i]]++;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        double unChecked =stages.length;

        for(int i=1;i<=N;i++){
            int now = cnt[i];
            double fail = unChecked>0 ? now/unChecked : 0;
            pq.add(new Node(i,fail));
            unChecked-=now;
        }
        
        for(int i=0;i<N;i++){
            answer[i] = pq.poll().stage;
        }
        return answer;
    }
    public static class Node implements Comparable<Node>{
        int stage;
        double fail;
        public Node (int stage,double fail){
            this.stage=stage;
            this.fail=fail;
        }
        
        @Override
        public int compareTo(Node o){
            if(fail==o.fail){
                return stage-o.stage;
            }else{
                return Double.compare(o.fail,fail);
            }
        }
    }
}
