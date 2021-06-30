class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] win = new boolean[46];
        int zero = 0;
        for(int i=0;i<6;i++){
            win[win_nums[i]]=true;
        }
        
        int cnt=0;
        for(int i=0;i<6;i++){
            if(win[lottos[i]]){
                cnt++;
            }
            if(lottos[i]==0)zero++;
        }
        
        int[] rank = {6,6,5,4,3,2,1};
        
        answer[0] = cnt+zero <= 6 ? rank[cnt+zero] : 6;
        answer[1] = rank[cnt];
        
        return answer;
        
    }
}
