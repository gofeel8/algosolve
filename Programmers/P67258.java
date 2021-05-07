import java.util.*;
class Solution {
    public static int[] arr;
    public static List<List<Integer>> list; 
    public static int min, max;
    public int[] solution(String[] gems) {
        max = 200000;
        min = 0;
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        int idx =0;
        for(int i=0;i<gems.length;i++){
            String now = gems[i];
            if(!map.containsKey(now)){
                map.put(now,idx++);
            }
        }
        if(idx ==1){
            answer = new int[] {1,1};
            return answer;
        }else{
            arr = new int[idx];
            int cnt = 0;
            int left = 0;
            int right =-1;
            while(true){
                if(cnt==idx){
                    if(right-left < max - min){
                        max = right;
                        min = left;
                    }
                    arr[map.get(gems[left])]--;
                    if(arr[map.get(gems[left])]==0){
                        cnt--;
                    }
                    left ++;
                    if(left==gems.length)break;
                }else{
                     right++;
                    if(right==gems.length)break;
                     arr[map.get(gems[right])]++;
                    if(arr[map.get(gems[right])]==1){
                        cnt++;
                    }
                }
            }
        }
        // System.out.println("max ="+max +"   min = "+min);
        answer[0] = min+1;
        answer[1] = max+1;
        
        return answer;
    }
    
}
