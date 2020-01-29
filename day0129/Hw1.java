//로봇 이동거리
package day0129;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Hw1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
		int size = sc.nextInt();
		char[][] arr = new char[size][size];
		for(int i =0;i<size;i++) {
			String str = sc.next();
			for(int j=0;j<size;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		int sum = 0;
		int x,y;
		for(int i =0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(arr[i][j]=='A') {
					y=j;
					while(y<size-1 && arr[i][++y]=='S') {
						sum++;
					}
				}else if(arr[i][j]=='B') {
					x=i;
					y=j;
					while( y<size-1 && arr[i][++y]=='S') {
						sum++;
					}
					x=i;
					y=j;
					while(y>0 && arr[i][--y]=='S') {
						sum++;
					}
				}else if(arr[i][j]=='C') {
					x=i;
					y=j;
					while( y<size-1 && arr[i][++y]=='S') {
						sum++;
					}
					x=i;
					y=j;
					while(y>0 && arr[i][--y]=='S') {
						sum++;
					}
					y=j;
					x=i;
					while(x<size-1 && arr[++x][y]=='S') {
						sum++;
					}
					y=j;
					x=i;
					while(x>0 && arr[--x][y]=='S') {
						sum++;
					}					
				}
			}
		}		
		System.out.println("#"+tc+" "+sum);
		
		
		}
	}

}
