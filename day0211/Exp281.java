import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution {
    static Set<Integer> set = new HashSet<>();
    static int[][] arr = new int[4][4];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            set.clear();
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
             
             
             
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                find(0, 0, i, j);
            }
        }
         
         
         
         
        System.out.println("#"+tc+" "+set.size());
        }
 
    }
 
    public static void find(int cnt, int result, int row, int col) {
        if (cnt == 7) {
            set.add(result);
            return;
        }
 
        if (row < 0 || row >= 4 || col < 0 || col >= 4) {
            return;
        } else {
            result = result*10+arr[row][col];
            cnt++;
        }
 
        find(cnt, result, row - 1, col);
        find(cnt, result, row, col + 1);
        find(cnt, result, row + 1, col);
        find(cnt, result, row, col - 1);
    }
}