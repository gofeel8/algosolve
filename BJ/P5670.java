import java.util.*;
import java.io.*;
public class P5670 {
	public static double sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		while(str!=null) {
//			if(str.equals("0"))break;
			int num = Integer.parseInt(str);
			Root root = new Root();
			root.root=true;
			for(int i=0;i<num;i++) {
				String input = br.readLine();
				root.insert(input.toCharArray(), 0);
			}
			sum =0;
			root.print(0);
			sum = sum/num;
			sum *= 100;
			sum = Math.round(sum);
			sum /= 100;
			String tmp = String.format("%.2f", sum);
			bw.append(tmp);
			bw.newLine();
//			System.out.println(tmp);
			str = br.readLine();
		}
		bw.flush();
		bw.close();


	}
	
	public static class Root{
		boolean end;
		int status;    //0~25 값이면 인덱스, -1 이면 다중 값이므로 for 문돌기  -2 이면 끝
		Root[] arr;
		boolean start;
		boolean root;
		Root(){
			end=false;
			status = -2;
			arr = new Root[26];
			start = false;
			root = false;
		}
		
		public void insert(char[] str,int idx) {
			if(arr[str[idx]-'a']==null) {
				arr[str[idx]-'a']=new Root();
				if(root)arr[str[idx]-'a'].start=true;
				if(status == -2 ) {
					status = str[idx]-'a'; 
				}else {
					if(status>=0) {
						arr[status].start=true;
					}
					arr[str[idx]-'a'].start=true;
					status = -1;
				}
				
				if(idx != str.length-1) {
					arr[str[idx]-'a'].insert(str, idx+1);
				}else {
					arr[str[idx]-'a'].end = true;
				}
			}else {
				if(idx != str.length-1) {
					arr[str[idx]-'a'].insert(str, idx+1);
				}else {
					arr[str[idx]-'a'].end = true;
				}
			}
		}
		
		public void print(int cnt) {
			if( start) {
				cnt++;
			}
			
			if(end) {
				sum+=cnt;				
				if(status>=0)cnt++;

			}
			
			
			if(status == -2) {           //끝
				return;
			}else if(status == -1) {      //다중 자식
				for(int i=0;i<26;i++) {
					if(arr[i] != null) {
						arr[i].print(cnt);
					}
				}
			}else {                       //외동
				arr[status].print(cnt);
			}
		}
	}

}
