class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n+1];
        
        for(int i=2;i<=n;i++){
            if(prime[i]==false){
                answer++;
            }    
            for(int j=2;j<=n;j++){
                if(i*j>n)break;
                prime[i*j]=true;
            }
        }
        
        return answer;
    }
}
