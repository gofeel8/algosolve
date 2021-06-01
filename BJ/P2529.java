import java.util.*;
import java.io.*;
public class P2529 {

	public static boolean[] cmd;
	public static boolean[] used;
	public static String MAX,MIN;
	public static int[] arr;
	public static boolean find;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		cmd = new boolean[N]; // < true   ,  > false
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			if(st.nextToken().charAt(0)=='<') {
				cmd[i] = true;
			}
		}
		MIN="";
		MAX="";
		
		//최소값 찾기
		find = false;
		for(int i=0;i<10;i++) {
			used = new boolean[10];
			arr = new int[N+1];
			arr[0]=i;
			used[i]= true;
			search(1,true);
		}
		
		
		//최댓값찾기
		find = false;
		for(int i=9;i>=0;i--) {
			used = new boolean[10];
			arr = new int[N+1];
			arr[0]=i;
			used[i]= true;
			search(1,false);
		}
		
		System.out.println(MAX);
		System.out.println(MIN);

	}
	private static void search(int idx,boolean flag) {
		if(idx ==arr.length) {
			if(flag) {  //최솟값
				for(int i=0;i<arr.length;i++) {
					MIN += arr[i];
				}
				find = true;
			}else {   //최댓값
				for(int i=0;i<arr.length;i++) {
					MAX += arr[i];
				}
				find = true;
			}
			return;
		}
		
		if(flag) {
			for(int i=0;i<10;i++) {
				if(find)break;
				if(used[i])continue;
				if(cmd[idx-1]) { // < 전에거보다 커야함
					if(arr[idx-1]>i) continue;
				}else {    // >   전에거보다 작아야함
					if(arr[idx-1]<i)continue;
				}
				used[i]= true;
				arr[idx]=i;
				search(idx+1,flag);
				used[i]=false;
			}
		}else {
			for(int i=9;i>=0;i--) {
				if(find)break;
				if(used[i])continue;
				if(cmd[idx-1]) { // < 전에거보다 커야함
					if(arr[idx-1]>i) continue;
				}else {    // >   전에거보다 작아야함
					if(arr[idx-1]<i)continue;
				}
				used[i]= true;
				arr[idx]=i;
				search(idx+1,flag);
				used[i]=false;
			}
		}
		
	}

}
