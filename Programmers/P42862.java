import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        
        for(int i=0;i<lost.length;i++){
            arr[lost[i]]--;
        }
        
        for(int i=0;i<reserve.length;i++){
            arr[reserve[i]]++;
        }
        
        for(int i=1;i<=n;i++){
            if(arr[i]==0){
                if(i-1 != 0 && arr[i-1]==2){
                  answer++;
                }else if(i+1 !=n+1 && arr[i+1]==2){
                    answer++;
                    arr[i+1]=1;
                }
                
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}
