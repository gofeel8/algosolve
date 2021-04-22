import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // int[] answer = {};
        // return answer;
        Map<Integer,Integer> cnt = new HashMap<>();
        PriorityQueue<Integer> upPq = new PriorityQueue<>();
        PriorityQueue<Integer> downPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<operations.length;i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if(op == 'I'){
                cnt.put(num,cnt.getOrDefault(num,0)+1);
                upPq.add(num);
                downPq.add(num);
            }else{
                if(num == -1){
                    while(upPq.size()>0&&cnt.get(upPq.peek())==0){
                        upPq.poll();
                    }
                    if(upPq.size()==0)continue;
                    int tmp =  upPq.poll();
               
                    cnt.put(tmp,cnt.get(tmp)-1);
                }else{  
                    while(downPq.size()>0&&cnt.get(downPq.peek())==0){
                        downPq.poll();
                    }
                    if(downPq.size()==0)continue;
                    int tmp =  downPq.poll();
                    cnt.put(tmp,cnt.get(tmp)-1);
                }
            }
        }
            int[] rt = new int[2];
            while(upPq.size()>0&&cnt.get(upPq.peek())==0){
                     upPq.poll();
            }
            while(downPq.size()>0&&cnt.get(downPq.peek())==0){
                        downPq.poll();
            }
            
            if(downPq.size()==0){
                return rt;
            }
            rt[0]=downPq.poll();
            rt[1]=upPq.poll();
            return rt;
        }
    
}
