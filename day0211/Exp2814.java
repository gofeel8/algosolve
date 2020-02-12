import java.util.Scanner;
 
public class Solution {
    static int N;
    static int M;
    static boolean[][] arr;
    static boolean[] visited;
    static int max;
    static int cnt;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new boolean[N+1][N+1];
            visited = new boolean[N+1];
            max=1;
             
            for (int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                arr[r][c] = true;
                arr[c][r] = true;
                 
            }
            for(int i=1;i<=N;i++) {
                cnt=1;
                visited[i]=true;
                search(i);
                visited[i]=false;
            }
            System.out.println("#"+tc+" "+max);
        }
    }
 
    public static void search(int start) {
         
        for(int i=1;i<=N;i++) {
            if(arr[start][i]==true) {
                if(visited[i]==false) {
                    visited[i]=true;
                    cnt++;
                    if(max<cnt) {
                        max=cnt;
                    }
                    search(i);
                    visited[i]=false;
                    cnt--;
                }
            }
        }
 
    }
 
}