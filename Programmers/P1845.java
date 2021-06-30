class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] used = new boolean[200001];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(used[nums[i]]==false){
                used[nums[i]]=true;
                cnt++;
            }
        }
        
        answer = cnt >nums.length/2 ? nums.length/2 : cnt;
        
        return answer;
    }
}
