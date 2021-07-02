import java.util.*;
class Solution {
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0&&visited[i][j]==false){
                    numberOfArea++;
                    int cnt=1;
                    visited[i][j]=true;
                    Queue<int []> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    
                    //bfs
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int d=0;d<4;d++){
                            int nr = now[0]+dr[d];
                            int nc = now[1]+dc[d];
                            if(nr<0||nr>=m||nc<0||nc>=n)continue;
                            if(visited[nr][nc])continue;
                            if(picture[nr][nc]==picture[now[0]][now[1]]){
                                cnt++;
                                queue.add(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    
                    if(maxSizeOfOneArea<cnt)maxSizeOfOneArea=cnt;
                    
                    
                }
            }
        }
        
        
        
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
