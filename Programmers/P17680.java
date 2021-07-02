import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return 5*cities.length;
        }
        int answer = 0;
        int[] time = new int[cacheSize];
        String[] name = new String[cacheSize];
        Map<String,Integer>map = new HashMap<>();
        int idx=0;
        for(int i=0;i<cities.length;i++){
            String now = cities[i].toLowerCase();
            if(map.containsKey(now)){       //캐시 히트
                time[map.get(now)]=i;
                answer+=1;
            }else{                      //캐시 미스
                if(idx<cacheSize){
                    time[idx]=i;
                    name[idx]=now;
                    map.put(now,idx);
                    idx++;
                    answer+=5;
                }else{
                    int minIdx=0;
                    int min=time[0];
                    for(int j=1;j<time.length;j++){
                        if(time[j]<min){
                            min=time[j];
                            minIdx=j;
                        }
                    }
                    
                    map.remove(name[minIdx]);
                    name[minIdx]=now;
                    time[minIdx]=i;
                    map.put(now,minIdx);
                    
                    answer+=5;
                }
            }
        }
        return answer;
    }
}
