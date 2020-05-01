import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Solution {
    private static List<Integer> twolist;
    private static List<Integer> threelist;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= TC; tc++) {
            String two = br.readLine();
            String three = br.readLine();
 
            twolist = twoToTen(two);
            threelist = threeToTen(three);
             
            for (int temp : twolist) {
                if(threelist.contains(temp)) {
                    System.out.println("#"+tc+" "+temp);
                    break;
                }
            }
             
        }
 
    }
 
    public static List<Integer> twoToTen(String num){
        List<Integer> rt = new ArrayList<>();
         
        int now = Integer.parseInt(num,2);
        for(int i=0;i<num.length();i++) {
            if(num.charAt(i)=='0') {
                rt.add(now+(int) Math.pow(2, num.length()-i-1));
            }else {
                rt.add(now-(int) Math.pow(2, num.length()-i-1));
            }
        }
         
        return rt;
    }
     
    public static List<Integer> threeToTen(String num){
        List<Integer> rt = new ArrayList<>();
         
        int now = Integer.parseInt(num,3);
        for(int i=0;i<num.length();i++) {
            if(num.charAt(i)=='0') {
                rt.add(now+(int)Math.pow(3, num.length()-i-1));
                rt.add(now+(int)Math.pow(3, num.length()-i-1)*2);
            }else if(num.charAt(i)=='1') {
                rt.add(now-(int) Math.pow(3, num.length()-i-1));
                rt.add(now+(int) Math.pow(3, num.length()-i-1));
            }else {
                rt.add(now-(int) Math.pow(3, num.length()-i-1));
                rt.add(now-(int) Math.pow(3, num.length()-i-1)*2);
            }
        }
         
        return rt;
    }
 
}