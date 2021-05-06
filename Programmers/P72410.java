class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        StringBuffer sb = new StringBuffer();
        //1
        System.out.println(new_id);
        for(int i=0;i<new_id.length();i++){
            if(Character.isUpperCase(new_id.charAt(i))){
                sb.append(Character.toLowerCase(new_id.charAt(i)));
            }else{
                sb.append(new_id.charAt(i));
            }
        }
        System.out.println("1 : "+sb.toString());
        
        //2 
        for(int i=0;i<sb.length();i++){
            char now =sb.charAt(i);
            if(Character.isAlphabetic(now) || Character.isDigit(now) || 
               now == '.' || now == '-' || now =='_'){
               continue; 
            }else{
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        System.out.println("2 : "+sb.toString());
         //3
        for(int i=0;i<sb.length()-1;i++){
            char now =sb.charAt(i);
            if(now == '.' && sb.charAt(i+1) =='.'){
                 sb.deleteCharAt(i);
                i--;
            }
           
        }
            System.out.println("3 : "+sb.toString());
        
        //4 
        if(sb.length()>0&& sb.charAt(0)=='.'){
             sb.deleteCharAt(0);
        }
        if(sb.length()>0&& sb.charAt(sb.length()-1)=='.'){
             sb.deleteCharAt(sb.length()-1);
        }
        
            System.out.println("4 : "+sb.toString());
        
        //5 , 6 , 7
        
      if(sb.length()==0){
            sb.append('a');     
             System.out.println("5 : "+sb.toString());
        }
        
        if(sb.length()>15){
            sb= new StringBuffer(sb.substring(0,15));
            while(sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
              System.out.println("6 : "+answer);
        }
        
      
        

         while(sb.length() <3){
            sb.append(sb.charAt(sb.length()-1));
        }
         System.out.println("7 : "+sb.toString());
        answer = sb.toString();
        
        
        
        return answer;
    }
}
