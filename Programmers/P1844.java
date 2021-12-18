import java.util.*;
class Solution {
    public static int[] dr ={-1,0,1,0};
    public static int[] dc ={0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        queue.add(new int[] {0,0});
        visited[0][0]=true;
        boolean find = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer++;
            for(int i=0;i<size;i++){
                int[] now = queue.poll();
                if(now[0]==maps.length-1 && now[1]==maps[0].length-1){
                    find = true;
                    break;
                }
                for(int j=0;j<4;j++){
                    if(now[0]+dr[j]<0 || now[0]+dr[j]==maps.length||now[1]+dc[j]<0 || now[1]+dc[j]==maps[0].length)continue;
                    if(maps[now[0]+dr[j]][now[1]+dc[j]]==0)continue;
                    if(visited[now[0]+dr[j]][now[1]+dc[j]])continue;
                    
                    visited[now[0]+dr[j]][now[1]+dc[j]]=true;
                    queue.add(new int[] {now[0]+dr[j],now[1]+dc[j]});
                }
                if(find)break;
            }
            if(find)break;
        }
        return find?answer:-1;
    }
}
