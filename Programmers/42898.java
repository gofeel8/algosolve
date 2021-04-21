import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] puddle = new boolean[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            int[] now = puddles[i];
            puddle[now[1]][now[0]]=true;
        }
        
        // int[][] dp = new int[n+1][m+1];
        // dp[0][1]=1;

        int[] dp = new int[m+1];
        
        for(int i=1;i<=m;i++){
            if(puddle[1][i]==false){
                dp[i]=1;
            }else{
                break;
            }
        }
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(puddle[i][j]==false){
                    dp[j]=(dp[j]+dp[j-1])%1000000007;
                }else{
                    dp[j]=0;
                }
            }
        }
       
        // answer = dp[n][m];
        answer =dp[m];
        return answer%1000000007;
    }
}
