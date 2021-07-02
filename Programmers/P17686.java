import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // String[] answer = {};
        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                String head1,head2;
                int num1,num2;
                int idx= firstnum(str1);
                head1 = str1.substring(0,idx).toLowerCase();
                num1 =  Integer.parseInt(str1.substring(idx,lastnum(str1,idx)));
                idx = firstnum(str2);
                head2 = str2.substring(0,idx).toLowerCase();
                num2 =  Integer.parseInt(str2.substring(idx,lastnum(str2,idx)));
                if(head1.equals(head2)){
                    if(num1==num2){
                        return 0;
                    }else{
                        return num1-num2;
                    }
                }else{
                    return head1.compareTo(head2);
                }
                
            }
        });
        return files;
    }
    public static int firstnum(String str){
         for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                    return i;
                }
        }
        
        return 0;
    }
    
    public static int lastnum(String str,int idx){
        int rt=idx;
        int cnt=0;
        while(rt<str.length()&&Character.isDigit(str.charAt(rt))){
            rt++;
            cnt++;
            if(cnt==5)break;
        }
        return rt;
        
    }
}
