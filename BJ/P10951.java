import java.io.*;
import java.util.*;

public class P10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		while(str!=null) {
			StringTokenizer st  =new StringTokenizer(str);
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(a+b));
			bw.newLine();
			str = br.readLine();
		}
		bw.flush();
		bw.close();

	}

}
