import java.util.*;
import java.io.*;

public class P5052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			trie root = new trie();
			boolean find =true;
			boolean answer =true;
			for(int i=0;i<N;i++) {
				String num = br.readLine();
				
				num = num.replaceAll(" ", "");
				find = root.insert(num, 0);
				if(find ==false) {
					answer = false;
				}
			}
			if(answer) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static class trie{
		boolean pass;
		boolean finish;
		trie[] childred;
		trie(){
			finish=false;
			pass = false;
			childred=new trie[10];
		}
		
		public boolean insert(String str,int idx) {
			if(finish)return false;
			if(idx == str.length()) {
				finish=true;
				if(pass)return false;
				return true;
			}
			
			int now = str.charAt(idx)-'0';
			if(childred[now]==null) {
				childred[now]=new trie();
				pass=true;
			}
			return childred[now].insert(str, idx+1);
		}
	}

}
