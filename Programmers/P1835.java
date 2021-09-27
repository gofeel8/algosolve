import java.util.*;
class Solution {
    static int[] position;
    static String[] rules;
    static int answer;
    static Map<Character,Integer> map  = new HashMap<>();

    public int solution(int n, String[] data) {
        position = new int[8];
        Arrays.fill(position, -1);
		answer =0;
        rules = data;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        perm(0);
        return answer;
    }
    
    static public void perm(int idx){
        if(idx==8){
            if(check()){
                answer++;
            };
            return;
        }
        for(int i=0;i<8;i++){
            if(position[i]!=-1)continue;
            position[i]=idx;
            perm(idx+1);
            position[i]=-1;
        }
    }
    
    static public boolean check(){
        for(int i=0;i<rules.length;i++){
            String now = rules[i];
            int a = map.get(now.charAt(0));
            int b = map.get(now.charAt(2));
            int space = Math.abs(position[a]-position[b])-1;
            char cmd = now.charAt(3);
            int num = now.charAt(4)-'0';
            if(cmd=='='){
                if(num!=space)return false;
            }
            else if(cmd=='<'){
                if(space>=num)return false;
            }else if(cmd=='>'){
                if(space<=num)return false;
            }
        }
        
        return true;
    }
}
