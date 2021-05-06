import java.util.*;

class Solution {
    public static long[] num;
    public static int[] priority;
    public static List<Integer>[] comList;
    public static boolean[] used;
    public static long answer;
    public long solution(String expression) {
        answer = 0;
        String[] command =  expression.split("[0-9]{1,}");
        String[] tmp =  expression.split("[^0-9]{1,}");
        num = new long[tmp.length];
        for(int i=0;i<tmp.length;i++){
            num[i] = Long.parseLong(tmp[i]);
        }
        
//         System.out.println(Arrays.toString(command));
//         System.out.println(Arrays.toString(num));
        
        comList  = new List[3];        // 0 +   1 -   2 *
        for(int i=0;i<3;i++){
            comList[i] = new ArrayList<>();
        }
        
        for(int i=1;i<command.length;i++){
            switch (command[i]){
                case "+":
                    comList[0].add(i);
                    break;
                case "-":
                    comList[1].add(i);
                    break;
                case "*":
                    comList[2].add(i);
                    break;
            }
        }
    
        int useCnt =0;
        used = new boolean[3];
       
        for(int i=0;i<3;i++){
            if(comList[i].size()!=0){
                useCnt++;
            }else{
                used[i] = true;
            }
        }
        priority = new int[useCnt];
        perm(0,useCnt);
            
        
        return answer;
    }
    
    public static void perm(int idx, int total){
        if(idx==total){
            // System.out.println(Arrays.toString(priority));
            
            long[] number = Arrays.copyOf(num,num.length);
            // System.out.println(Arrays.toString(number));
            boolean[] checked = new boolean[number.length];
            long last = 0;
            for(int i=0;i<priority.length;i++){
                for(int j=0;j<comList[priority[i]].size();j++){
                    int ridx = comList[priority[i]].get(j);
                    int lidx = ridx-1;
                
                  
                    
                    while(checked[ridx]==true){
                        ridx++;
                    }
                    
                   while(checked[lidx]==true){
                        lidx--;
                    }
                        
                  
                    
                    long lnum = number[lidx];
                    long rnum = number[ridx];
                    checked[lidx]=true;
                    
                    if(priority[i]==0){   //+
                        number[ridx] = lnum+rnum;
                    }else if(priority[i]==1){  //-
                        number[ridx] = lnum-rnum;
                    }else if(priority[i]==2){   //*
                        number[ridx] = lnum*rnum;
                    }
                    last = number[ridx];
                    
                }
            }
            // System.out.println(last);
            if(Math.abs(last)> answer) answer =Math.abs(last);
            return;
        }
        for(int i=0;i<3;i++){
            if(used[i])continue;
            used[i]= true;
            priority[idx]=i;
            perm(idx+1,total);
            used[i]=false;
        }
    }
}
