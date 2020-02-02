//expert 1926 369게임
package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hw4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);
        for(int i=1;i<=num;i++) {
            char[] arr = Integer.toString(i).toCharArray();
            boolean tf = false;
            for(int j=0;j<arr.length;j++) {
                if(arr[j]=='3'||arr[j]=='6'||arr[j]=='9') {
                    System.out.print("-");
                    tf =true;
                }
            }
            if(!tf) {
                System.out.print(i);                
            }
            System.out.print(" ");
        }
    }
}