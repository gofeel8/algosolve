import java.util.*;

class Solution {
    public int[] dr ={-1,0,1,0};
    public int[] dc ={0,1,0,-1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int[][] min0 = new int[len][len];
        int[][] min1 = new int[len][len];
        
        
        for(int i=0;i<len;i++){
            Arrays.fill(min0[i],Integer.MAX_VALUE);
            Arrays.fill(min1[i],Integer.MAX_VALUE);
        }
        
        min0[0][0] = 0;
        min1[0][0] = 0;
        
        Queue<int []> queue =  new LinkedList<>();
        if(board[0][1]==0){
            queue.add(new int[] {0,1,0});    
            min0[0][1] = 100;
        }
        
        if(board[1][0]==0){
         queue.add(new int[] {1,0,1});
         min1[1][0]=100;
        }
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0;d<4;d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr<0 || nr>=len || nc<0 || nc>=len)continue;
                if(board[nr][nc]==1)continue;
                int nprice =0;
                if(now[2]==1){
                    if(d== 0 || d ==2){
                        nprice = min1[now[0]][now[1]]+100;
                        if(nprice<min1[nr][nc]){
                            min1[nr][nc] = nprice;                    
                            queue.add(new int[] {nr,nc,1});
                        }
                    }else if( d== 1 || d== 3){
                        nprice = min1[now[0]][now[1]]+600;
                        if(nprice<min0[nr][nc]){
                            min0[nr][nc] = nprice;                    
                            queue.add(new int[] {nr,nc,0});
                        }
                    }
                }else if(now[2]==0){
                    if(d== 0 || d ==2){
                        nprice = min0[now[0]][now[1]]+600;
                        if(nprice<min1[nr][nc]){
                            min1[nr][nc] = nprice;                    
                            queue.add(new int[] {nr,nc,1});
                        }
                    }else if( d== 1 || d== 3){
                        nprice = min0[now[0]][now[1]]+100;
                        if(nprice<min0[nr][nc]){
                            min0[nr][nc] = nprice;                    
                            queue.add(new int[] {nr,nc,0});
                        }
                    }
                }
            }
        }
        
        answer = Math.min(min0[len-1][len-1],min1[len-1][len-1]);
        
        
        
        return answer;
    }
}
