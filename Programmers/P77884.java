class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left ; i<=right;i++){
            double tmp = Math.sqrt(i);
            if(tmp%1 == 0){
                answer -= i;
            }else{
                answer +=i;
            }
        }
        return answer;
    }
}
