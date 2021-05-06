class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        if(len == 1)return 1;
        
        for(int i=1;i<=len/2;i++){
            int total = 0;
            int cnt = 1;
            String prev = s.substring(0,i);
 
            for(int j=i;j<=len;j=j+i){
                if(j+i>len){
                    total += len-j;
                    break;
                }
                
                String now=s.substring(j,j+i);
                if(now.equals(prev)){
                    cnt++;
                }else{
                    if(cnt ==1 ){
                        total += i;
                    }else if(cnt >1){
                        total += i+(Math.log10(cnt))+1;
                    }
                    prev = now;
                    cnt =1;
                }
            }
              if(cnt ==1 ){
                total += i;
            }else if(cnt >1){
                total += i+(Math.log10(cnt))+1;
            }
            if(total < answer)answer =total;        
        }
        return answer;
    }
}
