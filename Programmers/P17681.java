class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int tmp = arr1[i]|arr2[i];
            for(int j=n-1;j>=0;j--){
                if((tmp&(1<<j))>0){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
        answer[i] = sb.toString();
        }
        return answer;
    }
}
