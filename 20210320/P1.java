	package Line;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1 {

	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"JAVA", "JAVASCRIPT"};
		int[] preference = {7,5};
		
		int size =  table.length;
		String[] job = new String[size];
		
	
		Map<String, Integer>[] map = new Map[size];
		
		for(int i=0;i<size;i++) {
			map[i] = new HashMap<>();
		}
		
		for(int i=0;i<size;i++) {
			StringTokenizer st = new StringTokenizer(table[i]);
			job[i] = st.nextToken();
			for(int j=5;j>0;j--) {
				map[i].put(st.nextToken(), j);
			}
		}
		
		int[] sum = new int[size];
		
		
		for(int i=0;i<size;i++) {
			int tmp = 0;
			for(int j=0;j<languages.length;j++) {
				if(map[i].containsKey(languages[j])) {
					tmp+= preference[j]*map[i].get(languages[j]);
				}
			}
			sum[i] = tmp;
		}
		int max = 0;
		int maxIdx = 0;
		for(int i=0;i<sum.length;i++) {
			if(sum[i]==max) {
				if(job[i].compareTo(job[maxIdx])<0) {
					max = sum[i];
					maxIdx=i;
				}
			}
			if(sum[i]>max) {
				max = sum[i];
				maxIdx=i;
			}
		}
		
		System.out.println(job[maxIdx]);
	}

}
