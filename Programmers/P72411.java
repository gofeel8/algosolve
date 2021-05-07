import java.util.*;
class Solution {
    public static Map<String,Integer>[] map;
    public static int[] maxCnt;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        map = new Map[course.length];
        for(int i=0;i<course.length;i++){
            map[i] = new HashMap<>();
        }
        maxCnt = new int[course.length];
        
        for(int i=0;i<orders.length;i++){
            String now = orders[i];
            char[] arr = now.toCharArray();
            Arrays.sort(arr);
            for(int j=0;j<course.length;j++){
                if(course[j]>arr.length)break;
                char[] selected = new char[course[j]];
                comb(0,0,course[j],arr,selected,j);
            }
        }
        System.out.println(Arrays.toString(maxCnt));
        List<String> ans = new ArrayList<>();
       for(int i=0;i<course.length;i++){
            // System.out.println(map[i].size());
           if(maxCnt[i]==1)continue;
           for(String idx : map[i].keySet()){
               if(map[i].get(idx)==maxCnt[i]){
                   ans.add(idx);
               }
           }
        }
        Collections.sort(ans);
        answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    public static void comb(int now, int idx ,int end, char[] arr,char[] selected, int cIdx){
        if(idx == end){
            String str = new String(selected);
            map[cIdx].put(str,map[cIdx].getOrDefault(str,0)+1);
            if(map[cIdx].get(str)>maxCnt[cIdx]){
                maxCnt[cIdx]=map[cIdx].get(str);
            }
            return;
        }
        for(int i=now;i<arr.length;i++){
            selected[idx]=arr[i];
            comb(i+1,idx+1,end,arr,selected,cIdx);
        }
    }
}
