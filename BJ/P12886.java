package BJ;
import java.util.*;
import java.io.*;
public class P12886 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =  new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		
		
		if((arr[0]+arr[1]+arr[2])%3!=0) {
			System.out.println(0);
			return ;
		}
		
		int goal = (arr[0]+arr[1]+arr[2])/3;
		boolean[][] checked = new boolean[1500][1500];
		
		Queue<int []>  queue = new LinkedList<>();
		queue.add(new int[] {arr[0],arr[1],arr[2]});
	
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0]==goal && now[1]==goal  && now[2]==goal) {
				System.out.println(1);
				return;
			}
			if(checked[now[0]][now[1]]) {
				continue;
			}
			checked[now[0]][now[1]]=true;
			for(int i=0;i<2;i++) {
				for(int j=i+1;j<3;j++) {
					int a = now[i];
					int b = now[j];
					if(a==b)continue;
					int [] tmp =Arrays.copyOf(now,3);
					if(a<b) {
						tmp[i] = a+a;
						tmp[j]=b-a;						
					}else {
						tmp[i]=a-b;
						tmp[j]= b+b;
					}
					queue.add(tmp);
				}
			}
			
		}
		System.out.println(0);
		

	}

}
