package day0203;

import java.util.ArrayList;
import java.util.Scanner;

public class Password_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			ArrayList<Integer> al = new ArrayList<>();

			int size = sc.nextInt();
			for (int i = 0; i < size; i++) {
				al.add(sc.nextInt());
			}
			int com = sc.nextInt();
			for (int i = 0; i < com; i++) {
				char ins = sc.next().charAt(0);
				if (ins == 'I') {
					int pos = sc.nextInt();
					int iNum = sc.nextInt();
					for (int j = 0; j < iNum; j++) {
						al.add(pos++, sc.nextInt());
					}
				} else if (ins == 'D') {
					int pos = sc.nextInt();
					int dNum = sc.nextInt();
					for (int j = 0; j < dNum; j++) {
						al.remove(pos);
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(al.get(i) + " ");
			}
			System.out.println();
		}
	}

}
