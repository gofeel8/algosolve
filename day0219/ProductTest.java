package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	static Scanner sc = new Scanner(System.in);
	static ProductMgrlmpl manager = ProductMgrlmpl.getInstance();

	public static void main(String[] args) {
		while (true) {
			System.out.println("==========================선택 가능한 기능=========================");
			System.out.println("1.상품 입력");
			System.out.println("2.상품 전체 보기");
			System.out.println("3.상품번호로 제품 검색");
			System.out.println("4.상품명으로 제품 검색(부분검색 가능)");
			System.out.println("5.TV리스트 보기");
			System.out.println("6.냉장고 리스트 보기");
			System.out.println("7.400L이상의 냉장고 보기");
			System.out.println("8.50인치 이상의 TV보기");
			System.out.println("9.상품 가격 변경");
			System.out.println("10.상품 삭제");
			System.out.println("11.재고 전체 금액");
			System.out.println("12.프로그램 종료");
			System.out.print("원하는 기능 입력 : ");
			int bt = Integer.parseInt(sc.nextLine());
			if (bt == 12) {
				break;
			}else {
				switch (bt) {
				case 1:{
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
						break;
					}else if(inch!=-1&&liter!=-1) {
						System.out.println("잘 못 입력하였습니다");
						break;
					}
					else if(inch!=-1) {
						manager.addProduct(new TV(serial, name, price, stock, inch));
					}
					else if(liter!=-1) {
						manager.addProduct(new Refrigerator(serial, name, price, stock, liter));
					}
					break;
				}
				
				case 2:{
					Product[] tmp = manager.findAll();
					if (tmp.length != 0) {
						for (int i = 0; i < tmp.length; i++) {
							System.out.println(tmp[i]);
						}
					}else {
						System.out.println("제품이 아직 없습니다");
					}
					break;
				}
				
				case 3:{
					System.out.print("상품번호 입력 : ");
					String serial = sc.nextLine();
					Product tmp = manager.findSerial(serial);
					if (tmp != null) {
						System.out.println(tmp);
					} else {
						System.out.println("찾는 제품이 없습니다.");
					}
					break;
				}
				
				
				case 4:{
					System.out.print("상품명 입력 : ");
					String name = sc.nextLine();
					ArrayList<Product> tmp = manager.findName(name);
					if(tmp.size()!=0) {
						for(Product p : tmp) {
							System.out.println(p);
						}
					}else {
						System.out.println("해당되는 상품이 없습니다");
					}
					break;
				}
				
				case 5:{
					ArrayList<TV> tmp = manager.TVList();
					if (tmp.size() != 0) {
						for (TV b : tmp) {
							System.out.println(b);
						}
					} else {
						System.out.println("TV가 없습니다.");
					}
					break;
				}
				case 6:{
					ArrayList<Refrigerator> tmp = manager.RefrigeratorList();
					if (tmp.size() != 0) {
						for (Refrigerator b : tmp) {
							System.out.println(b);
						}
					} else {
						System.out.println("냉장고가 없습니다.");
					}
					break;
				}
				case 7:{
					ArrayList<Refrigerator> tmp = manager.findLiter(400);
					if (tmp.size() != 0) {
						for (Refrigerator b : tmp) {
							System.out.println(b);
						}
					} else {
						System.out.println("해당하는 냉장고가 없습니다.");
					}
					break;
				}
				case 8:{
					ArrayList<TV> tmp = manager.findInch(50);
					if (tmp.size() != 0) {
						for (TV b : tmp) {
							System.out.println(b);
						}
					} else {
						System.out.println("해당하는 티비가 없습니다.");
					}
					break;
				}
				case 9:{
					System.out.print("시리얼 입력 : ");
					String serial =sc.nextLine();
					System.out.print("가격 입력 : ");
					int price =Integer.parseInt(sc.nextLine());
					if(manager.changePrice(serial, price)) {
						System.out.println("제품 가격 변경완료");
					}else {
						System.out.println("변경하고자 하는 제품이 없습니다.");
					}
					break;
				}
				case 10:{
					System.out.print("시리얼 입력 : ");
					String serial =sc.nextLine();
					if(manager.deleteProduct(serial)) {
						System.out.println("제품 삭제 완료");
					}else {
						System.out.println("삭제하고자 하는 제품이 없습니다.");
					}
					break;
				}
				case 11:{
					System.out.println("재고 금액 합계 : " + manager.totalPrice());
					break;
				}
				default:
					System.out.println("잘 못 입력 하였습니다.");
					break;
				}
			}
		}

	}

}
