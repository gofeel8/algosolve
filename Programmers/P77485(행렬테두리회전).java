import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        
        int cnt=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=cnt++;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int min= Integer.MAX_VALUE;
            
            int prev=arr[x1+1][y1];
            int memo=0;
            
            for(int j=y1;j<=y2;j++){
                memo=arr[x1][j];
                arr[x1][j]=prev;
                min=Math.min(min,arr[x1][j]);
                prev = memo;
                
            }
            
            for(int j=x1+1;j<=x2;j++){
                memo=arr[j][y2];
                arr[j][y2]=prev;
                min=Math.min(min,arr[j][y2]);
                prev=memo;
            }
            
            for(int j=y2-1;j>=y1;j--){
                memo=arr[x2][j];
                arr[x2][j]=prev;
                min=Math.min(min,arr[x2][j]);
                prev=memo;
            }
            
            
            for(int j=x2-1;j>x1;j--){
                memo=arr[j][y1];
                arr[j][y1]=prev;
                min=Math.min(min,arr[j][y1]);
                prev=memo;
            }

            answer[i]=min;
        }
        
        return answer;
    }
}
