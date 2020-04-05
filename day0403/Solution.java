import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int[][] comp;
    static long[] mem;
    static int x;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            comp = new int[N + 1][3];
             
            for (int i = 2; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                comp[i][0] = Integer.parseInt(st.nextToken());
                comp[i][1] = Integer.parseInt(st.nextToken());
                comp[i][2] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.print("#"+tc);
            for(int i=0;i<M;i++) {
                x = Integer.parseInt(st.nextToken());
                mem = new long[N + 1];
                mem[0]=1;
                System.out.print(" "+compute(N));
            }
            System.out.println();
        }
 
    }
 
    public static long compute(int i) {
        if (i == 1) {
            return x;
        }
        if(mem[i]!=0) {
            return mem[i];
        }
         
        long rt = 0;
        if (comp[i][0] == 1) {
            rt = compute(comp[i][1]) + compute(comp[i][2]);
        } else if (comp[i][0] == 2) {
            rt = comp[i][1] * compute(comp[i][2]);
        } else if (comp[i][0] == 3) {
            rt = compute(comp[i][1]) * compute(comp[i][2]);
        }
 
        rt = rt % 998244353;
        mem[i]=rt;
        return rt;
    }
 
}