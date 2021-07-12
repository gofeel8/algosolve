import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        int prev = -1;
        for(int i=0;i<arr.length;i++){
            int now = arr[i];
            if(now!=prev){
                prev = now;
                list.add(now);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}
