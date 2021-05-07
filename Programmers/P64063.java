import java.util.*;
class Solution {
    public static Map<Long,Long> memo;
    public static Set<Long> used;
    public long[] solution(long k, long[] room_number) {
        long[] answer ;
        memo = new HashMap<>();
        answer = new long[room_number.length];
        used = new HashSet<>();
        for(int i=0;i<room_number.length;i++){
            long now = room_number[i];
            if(used.contains(now)){
                long pos = find(memo.get(now));
                // long pos =0;
                used.add(pos);
                memo.put(now,pos);
                answer[i]=pos;
            }else{
                used.add(now);
                answer[i] = now;
                memo.put(now,now+1);
            }
        }
        return answer;
    }
    
    public static long find(long idx){
        if(!used.contains(idx)){
            memo.put(idx,idx+1);
            return idx;
        }
        memo.put(idx,find(memo.get(idx)));
        return memo.get(idx);
    }
}
