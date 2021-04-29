import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String[] now = clothes[i];
            map.put(now[1],map.getOrDefault(now[1],1)+1);
        }
        int sum=1;
        for(String tmp : map.keySet()){
            sum*=map.get(tmp);
        }
        return answer =sum-1;
    }
}
