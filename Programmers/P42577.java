import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String>set = new HashSet<>();
        int size = phone_book.length;

        for(int i=0;i<size;i++){
            set.add(phone_book[i]);
        }

        // Arrays.sort(num);

        for(int i=0;i<size;i++){
             String now = phone_book[i];
             for(int j=1;j<now.length();j++){
                if(set.contains(now.substring(0,j))){
                    answer = false;
                    break;
                }
            }
            if(answer==false)break;

        }

        return answer;
    }
}
