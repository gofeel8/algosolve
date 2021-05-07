import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer =0;
        int maxValue = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]>maxValue)maxValue = stones[i];
        }
        int left = 1;
        int right = maxValue;
        while(left<=right){
            int mid = (left+right)/2;
            //mid 명이 건널 수 있겠는가
            int cnt =0;
            int max =0;
            for(int i=0;i<stones.length;i++){
                if(stones[i]<mid){
                    cnt++;
                    if(cnt>max){
                        max = cnt;
                        if(max>=k)break;
                    }
                }else{
                    cnt =0;
                }
            }
            if(max>=k){
                right = mid-1;
            }else{
                answer = mid;
                left = mid+1;
            }
        }

        return answer;
    }
}
