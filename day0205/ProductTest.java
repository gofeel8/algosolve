package HW0205;

import java.sql.Ref;

public class ProductTest {

	public static void main(String[] args) {
		Tv tv = new Tv(2211325, "삼성노번티비", 1200000, 132, 52, "OLED");
		Refrigerator refrig = new Refrigerator(125113, "삼성스마트냉장고",1800000, 186, 260);
		System.out.println("===================================제품정보========================================");
		System.out.println(tv);
		System.out.println(refrig);

	}

}
