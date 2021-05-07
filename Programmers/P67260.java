import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> lock = new HashSet<>();
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<path.length;i++){
            int[] now = path[i];
            adj[now[0]].add(now[1]);
            adj[now[1]].add(now[0]);
        }
        
        //visited 필수
        
        for(int i=0;i<order.length;i++){
            int[] now = order[i];
            int a = now[0];
            int b = now[1];
            lock.add(b);
            map.put(a,b);
        }
        
        if(lock.contains(0)){
            return false;
        }
        
        boolean[] visited = new boolean[n];
        Set<Integer> wait = new HashSet<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        
        if(map.containsKey(0)){
            lock.remove(map.get(0));
        }
        
        //map , lock ,wait visited
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<adj[now].size();i++){
                int can = adj[now].get(i);
                if(visited[can])continue;
                visited[can]=true;
                if(lock.contains(can)){
                    wait.add(can);
                    continue;
                }
                queue.add(can);
                visited[can]=true;
                if(map.containsKey(can)){
                    int tmp = map.get(can);
                    lock.remove(tmp);
                    if(wait.contains(tmp)){
                        queue.add(tmp);
                    }
                }
            }
        }
        if(lock.size()!=0){
            return false;
        }else{
            return true;
        }
        
    }
}   
