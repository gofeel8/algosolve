package Hw0206;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		ArrayList<Product> arr =new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("선택 가능한 기능");
			System.out.println("1.상품 입력");
			System.out.println("2.상품 전체 보기");
			System.out.println("3.상품번호로 제품 검색");
			System.out.println("4.상품명으로 제품 검색");
			System.out.println("5.TV리스트 보기");
			System.out.println("6.냉장고 리스트 보기");
			System.out.println("7.상품삭제하기");
			System.out.println("8.전체 재고 상품 금액 보기");
			System.out.println("9.프로그램 종료");
			System.out.print("원하는 기능 입력 : ");
			int bt = Integer.parseInt(sc.nextLine());
			if (bt == 9) {
				break;
			}else {
				switch (bt) {
				case 1:
					arr.add(ProductMgr.addProduct());
					break;
				case 2:
					ProductMgr.findAll(arr);
					break;
				case 3:
					ProductMgr.findSerial(arr);
					break;
				case 4:
					ProductMgr.findName(arr);
					break;
				case 5:
					ProductMgr.TvList(arr);
					break;
				case 6:
					ProductMgr.RefList(arr);
					break;
				case 7:
					ProductMgr.remove(arr);
					break;
				case 8:
					ProductMgr.totalPrice(arr);
					break;
				default:
					System.out.println("잘 못 입력 하였습니다.");
					break;
				}
			}
		}


	}

}
