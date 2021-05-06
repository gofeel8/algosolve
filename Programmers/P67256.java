import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // sb.append
        Map<Integer, int[]>map = new HashMap<>();
        map.put(1,new int[] {0,0});
        map.put(2,new int[] {0,1});
        map.put(3,new int[] {0,2});
        map.put(4,new int[] {1,0});
        map.put(5,new int[] {1,1});
        map.put(6,new int[] {1,2});
        map.put(7,new int[] {2,0});
        map.put(8,new int[] {2,1});
        map.put(9,new int[] {2,2});
        map.put(0,new int[] {3,1});
        
        int[] left =  {3,0};
        int[] right =  {3,2};
        
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num == 1 || num == 4 ||num==7){
                sb.append("L");
                left = map.get(num);
            }else if(num == 3 || num == 6 ||num==9){
                sb.append("R");
                right = map.get(num);
            }else{
                int[] tmp = map.get(num);
                int Ldist = Math.abs(tmp[0]-left[0]) + Math.abs(tmp[1]-left[1]);
                int Rdist = Math.abs(tmp[0]-right[0]) + Math.abs(tmp[1]-right[1]);
                if(Ldist == Rdist){
                    if(hand.equals("right")){
                        sb.append("R");
                        right = tmp;    
                    }else{
                        sb.append("L");
                        left = tmp;
                    }
                }else if(Ldist>Rdist){
                    sb.append("R");
                    right = tmp;
                }else if(Rdist> Ldist){
                    sb.append("L");
                    left = tmp;
                }
                
            }
            
        }
        answer = sb.toString();
        return answer;
    }
}
