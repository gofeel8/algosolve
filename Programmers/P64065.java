import java.util.*;
class Solution {
    public int[] solution(String s) {
 
        String str = s.substring(2,s.length()-2);
        String[] arr =str.split("\\},\\{");

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1 ,List<Integer> o2){
                return o1.size()-o2.size();
            }
        });
            
        for(int i=0;i<arr.length;i++){
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(arr[i],",");
             while (st.hasMoreTokens()) {
                 list.add(Integer.parseInt(st.nextToken()));
             }
            pq.add(list);
            System.out.println();
        }
        
        List<Integer>answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while(!pq.isEmpty()){
            List<Integer> now = pq.poll();
            for(int i=0;i<now.size();i++){
                if(!set.contains(now.get(i))){
                    answer.add(now.get(i));
                    set.add(now.get(i));
                }
            }
        }
        int[] rt = new int[answer.size()];
        
        for(int i=0;i<answer.size();i++){
            rt[i] = answer.get(i);    
        }
        return rt;
    }
}
