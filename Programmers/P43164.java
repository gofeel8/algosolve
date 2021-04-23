import java.util.*;
class Solution {
    public static String[] answer;
    public static boolean find;
    public static Map<String,List<String>> map;
    public static Map<String,Integer> num;
    public static int[][] visited;

    public String[] solution(String[][] tickets) {
      
        
        map = new HashMap<>();
        num = new HashMap<>();
        map.put("ICN",new ArrayList<>());
        
        
        for(int i=0;i<tickets.length;i++){
            String a = tickets[i][0];
            String b = tickets[i][1];
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<>());
            }
            
            map.get(a).add(b);
            
        }
        int idx=0;
        
        visited = new int[10000][10000];
        
        for(String tmp : map.keySet()){
            num.put(tmp,idx++);
            Collections.sort(map.get(tmp));
        }
        
        
        for(String tmp : map.keySet()){
            int a = num.get(tmp);
            for(int i=0;i<map.get(tmp).size();i++){
                visited[a][num.get(map.get(tmp).get(i))]++;
            }
        }
        
        
        answer = new String[tickets.length+1];
        answer[0]="ICN";
        
        dfs("ICN",1,tickets.length+1);
        
        
        return answer;
    }
    
    public static void dfs(String city,int idx,int end){
        if(idx ==end){
           find = true;
            return;
        }
        
        int a = num.get(city);
        // List now = map.get(city);
        for(int i=0; i<map.get(city).size();i++){
            int b = num.get(map.get(city).get(i));
            if(visited[a][b]==0)continue;
            answer[idx]=map.get(city).get(i);
            visited[a][b]--;
            dfs(map.get(city).get(i),idx+1,end);
            visited[a][b]++;
            if(find)return;
        }
    }
}
