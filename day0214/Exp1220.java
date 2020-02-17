import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++) {
            int size = Integer.parseInt(br.readLine());
            char[][] arr =new char[size][size];
            for(int i=0;i<size;i++) {
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j=0;j<size;j++) {
                    arr[i][j]=st.nextToken().charAt(0);
                }
            }
            int cnt =0;
            for(int col=0;col<size;col++) {
                int rIdx=100;
                int bIdx=100;
                for(int row=0;row<size;row++) {
                    if(arr[row][col]=='1') {
                        rIdx=row;
                    }
                    else if(arr[row][col]=='2') {
                        bIdx=row;
                        if(rIdx<bIdx) {
                            cnt++;
                            rIdx=100;
                        }
                    }   
                }
            }
            System.out.println("#"+tc+" "+cnt);
        }
    }
}