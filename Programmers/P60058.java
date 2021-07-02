class Solution {
    public String solution(String p) {
        String answer = "";
        return answer = dfs(p);
    }
    public static String dfs(String str){
        if(str.equals(""))return "";
        String u,v;
        int open=0,close=0;
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if(open==close)break;
        }
        u = str.substring(0,open+close);
        v = str.substring(open+close,str.length());
        // System.out.println(u);
        // System.out.println(v);
        if(isRight(u)){
            return u+dfs(v);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            return "("+dfs(v)+")"+sb.toString();
        }
         
    }
    
    public static boolean isRight(String str){
        int openCnt =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                openCnt++;
            }else{
                if(openCnt==0)return false;
                openCnt--;
            }
        }
        return true;
    }
}
