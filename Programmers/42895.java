import java.util.*;

class Solution {
    public int solution(int N, int number) {
     
        Set<Integer>[] set  = new Set[9];
        for(int i=0;i<9;i++){
            set[i] = new HashSet<Integer>();
        }
        
        set[1].add(N);
      
        
        for(int i=2;i<9;i++){
            
            int tmp =0;
            for(int j=0;j<i;j++){
                tmp += N*(Math.pow(10,j));
            }
            set[i].add(tmp);
          
               for(int j=1;j<i;j++){
                Iterator<Integer> it = set[j].iterator();
                while(it.hasNext()){
                    int now = it.next();
                    Iterator<Integer> it2 = set[i-j].iterator();
                    while(it2.hasNext()){
                        int now2 = it2.next();
                        int num = now+now2;
                        set[i].add(num);
                        
                        num = now-now2;
                        set[i].add(num);
                        
                        num = now*now2;
                        set[i].add(num);
                        
                        if(now2!=0){
                         
                        num = now/now2;
                        set[i].add(num);   
                        }
                        
                    }
                }
            }
        
         
        }
        
        for(int i=1;i<9;i++){
            if(set[i].contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}
