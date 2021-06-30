class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer=dfs(0,0,numbers,target);
        return answer;
    }
    
    public static int dfs(int idx,int sum,int[] numbers,int target){
        if(idx==numbers.length){
            if(sum==target)return 1;
            
            return 0;
        }
        
        int rt=0;
        rt+=dfs(idx+1,sum+numbers[idx],numbers,target);
        rt+=dfs(idx+1,sum-numbers[idx],numbers,target);

        return rt;
        
    }
}
