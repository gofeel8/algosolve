import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left =0;
        int right = distance;
        
        int[] newRocks = new int[rocks.length+2];
        for(int i=0;i<rocks.length;i++){
            newRocks[i+1]=rocks[i];
        }
        newRocks[rocks.length+1]=distance;
        
        Arrays.sort(newRocks);
        while(left<=right){
            int mid = (left+right)/2;
            int cnt=0;
            //최소거리 mid 가능한지
            int prev =0;
            for(int i=1;i<newRocks.length;i++){
                if(newRocks[i]-newRocks[prev]<mid){
                    cnt++;
                }else{
                    prev = i;
                }
               
            }
            
              
            if(cnt>n){
                right = mid-1;
            }else if(cnt <= n){
                answer = Math.max(answer,mid);
                left = mid+1;
            }
        }
        return answer;
    }
}
