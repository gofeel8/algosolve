import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int size1=0,size2=0;
        Map<String,Integer> map1,map2;
        map1=new HashMap<>();
        map2=new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String now =str1.substring(i,i+2).toLowerCase();
            if(now.matches("[a-zA-Z]{2}")){
                map1.put(now,map1.getOrDefault(now,0)+1);
                size1++;
            }
        }
        
        for(int i=0;i<str2.length()-1;i++){
            String now =str2.substring(i,i+2).toLowerCase();
            if(now.matches("[a-zA-Z]{2}")){
                map2.put(now,map2.getOrDefault(now,0)+1);
                size2++;
            }
        }
        
        //교집합 크기 구하기
        int cnt=0;
        for(String now : map1.keySet()){
            if(map2.containsKey(now)){
                cnt+=Math.min(map1.get(now),map2.get(now));
            }
        }
        int union = size1+size2-cnt;
        if(union==0){
            return 65536;
        }else{
            double similar = (double)cnt/union*65536;
            return (int)similar;
        }
        
        
    }
}
