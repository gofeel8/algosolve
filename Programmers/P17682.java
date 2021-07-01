class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();
        int[] arr = new int[len];
        int top = -1;
        for(int i=0;i<len;i++){
            char now = dartResult.charAt(i);
            if(Character.isDigit(now)){
                // System.out.println("숫자");
                if(i+1<len&&dartResult.charAt(i+1)=='0'){
                    arr[++top]=10;
                    i++;
                }else{
                    arr[++top]=now-'0';   
                }
            }else if(Character.isAlphabetic(now)){
                // System.out.println("알파벳");
                int tmp = arr[top--];
                if(now=='S'){
                    arr[++top]=tmp;
                }else if(now=='D'){
                    arr[++top]=(int)Math.pow(tmp,2);
                }else if(now =='T'){
                    arr[++top]=(int)Math.pow(tmp,3);
                }
            }else{
                // System.out.println("특수문자");
                if(now=='*'){
                    if(top>0){
                        int num1 = arr[top--]*2;
                        int num2 = arr[top--]*2;
                        arr[++top]=num2;
                        arr[++top]=num1;
                    }else{
                        int num1=arr[top--]*2;
                        arr[++top]= num1;
                    }
                }else if(now=='#'){
                    int num = arr[top--]*-1;
                    arr[++top]=num;
                }
            }
        }
        while(top>=0){
            answer+=arr[top--];
        
        }
        return answer;
    }
    
}
