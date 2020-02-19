package homework;

import java.util.ArrayList;

public interface IProductMgr {
	void addProduct(Product item);
	Product[] findAll();
	Product findSerial(String serial);
	ArrayList<Product> findName(String name);
	ArrayList<TV> TVList();
	ArrayList<Refrigerator> RefrigeratorList();
	ArrayList<Refrigerator> findLiter(int liter);
	ArrayList<TV> findInch(int inch);
	boolean changePrice(String serial,int price);
	boolean deleteProduct(String serial);
	int totalPrice();
}
