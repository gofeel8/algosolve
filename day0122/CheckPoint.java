package homework0122;

import java.util.Scanner;

public class CheckPoint {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(b+100-a>0) {
			System.out.println("비만 수치는"+(b+100-a)+"입니다.");
			System.out.println("당신은 비만이군요");
		}

	}

}
