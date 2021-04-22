class Solution {
    public int solution(int[][] triangle) {
    
        
        int size = triangle.length;
        if(size == 1){
            return triangle[0][0];
        }
        
        int[] before = triangle[0];
      
        for(int i=1;i<size;i++){
            int[] now = triangle[i];
            //처리
            for(int j=0;j<now.length;j++){
                int a=-1;
                int b=-1;
                if(j!=0){
                    a=before[j-1];
                }
                if(j!=now.length-1){
                    b=before[j];
                }
                now[j] = Math.max(a,b)+now[j];
            }
            
            before = now;
        }
        int max =0;
        for(int i=0;i<before.length;i++){
            max = Math.max(max,before[i]);
        }
        return max;
    }
}
