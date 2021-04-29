import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int[] score = new int[3];

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int aIdx=0,bIdx=0,cIdx=0;
        for(int i=0;i<answers.length;i++){
            int now = answers[i];
            if(a[aIdx++]==now){
                score[0]++;
            }
            if(b[bIdx++]==now){
                score[1]++;
            }
            if(c[cIdx++]==now){
                score[2]++;
            }

            if(aIdx==a.length)aIdx=0;
            if(bIdx==b.length)bIdx=0;
            if(cIdx==c.length)cIdx=0;

        }
        List<Integer> list = new ArrayList<>();
        int max =-1;

        for(int i=0;i<3;i++){
            if(score[i]>max){
                max = score[i];
                list.clear();
                list.add(i+1);
            }
            else if(score[i]==max){
                list.add(i+1);
            }

        }
        int [] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
