package Hw0206;

import java.util.ArrayList;
import java.util.Scanner;

import work0206.Book;

public class ProductMgr {
	
	public static Product addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.print("시리얼 입력 : ");
		String serial =sc.nextLine();
		System.out.print("제품이름 입력 : ");
		String name =sc.nextLine();
		System.out.print("가격 입력 : ");
		int price =Integer.parseInt(sc.nextLine());
		System.out.print("재고 입력 : ");
		int stock =Integer.parseInt(sc.nextLine());
		System.out.print("(TV일경우) 인치 입력 : ");
		String str = sc.nextLine();
		int inch = -1;
		if (str.length() > 1) {
			inch = Integer.parseInt(str);
		}
		System.out.print("(냉장고일경우) 리터 입력 : ");
		str = sc.nextLine();
		int liter = -1;
		if (str.length() > 1) {
			liter = Integer.parseInt(str);
		}
		
		if(inch==-1&&liter==-1) {
			System.out.println("잘 못 입력하였습니다");
			return null;
		}else if(inch!=-1&&liter!=-1) {
			System.out.println("잘 못 입력하였습니다");
			return null;
		}
		else if(inch!=-1) {
			return new Tv(serial, name, price, stock, inch);
		}
		else if(liter!=-1) {
			return new Refrigerator(serial, name, price, stock, liter);
		}else {
			return null;
		}
	}
	
	public static void findAll(ArrayList<Product> arr) {
		System.out.println("**************모든 제품 출력**************");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("******************************************");
	}
	
	public static void findSerial(ArrayList<Product> arr) {
		System.out.print("상품번호 입력:");
		Scanner sc = new Scanner(System.in);
		String serial =sc.nextLine();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getSerial().equals(serial)) {
				System.out.println(arr.get(i));
				return;
			}
		}
	}
	
	public static void findName(ArrayList<Product> arr) {
		System.out.print("상품명 입력:");
		Scanner sc = new Scanner(System.in);
		String name =sc.nextLine();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getName().indexOf(name) != -1) {
				System.out.println(arr.get(i));
			}
		}
	}
	
	public static void RefList(ArrayList<Product> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) instanceof Refrigerator) {
				System.out.println(arr.get(i));
			}
		}
	}
	
	public static void TvList(ArrayList<Product> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) instanceof Tv) {
				System.out.println(arr.get(i));
			}
		}
	}
	
	public static void remove (ArrayList<Product> arr) {
		System.out.print("삭제할 품목의 제품번호 입력: ");
		Scanner sc = new Scanner(System.in);
		String serial = sc.nextLine();
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getSerial().equals(serial)) {
				arr.remove(i);
				return;
			}
		}
	}
	
	

	public static int totalPrice(ArrayList<Product> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i).getStock()*arr.get(i).getPrice();
		}
		System.out.println("전체 재고 상품 금액 : "+sum+"원");
		return sum;
	}
}
