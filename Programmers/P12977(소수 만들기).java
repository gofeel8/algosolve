class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for(int k=j+1;k<length;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public static boolean isPrime(int num){
        if(num==1)return false;
        if(num==2|| num==3)return true;
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        
        return true;
    }
    
    
    
}
