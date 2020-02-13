import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution{
    static int size;
    static int start;
    static boolean[] used;
    static int[][] arr ;
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int tc=1;tc<=10;tc++) {
        used = new boolean[101];
        size = sc.nextInt();
        start = sc.nextInt();
        arr = new int[101][101];
        for (int i = 0; i < size / 2; i++) {
            int go = sc.nextInt();
            int end = sc.nextInt();
            arr[go][end]=1;
            }
        int result = dfs(start);
        System.out.println("#"+tc+" " +result);
        }
    }
    public static int dfs(int start) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> findmax = new ArrayList<Integer>();
        queue.add(start);
        used[start]=true;
        while(!queue.isEmpty()) {
            findmax.clear();
            int qsize = queue.size();
            for(int i=0;i<qsize;i++) {
                int tmp = queue.poll();
                findmax.add(tmp);
                for(int j=1;j<101;j++) {
                    if(arr[tmp][j]==1&&!used[j]) {
                        queue.add(j);
                        used[j]=true;
                    }
                }
            }
        }
        for(int i=0;i<findmax.size();i++) {
            if(ans<findmax.get(i)) {
                ans = findmax.get(i);
            }
        }
        return ans;
    }
}