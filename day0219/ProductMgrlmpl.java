package homework;

import java.util.ArrayList;

public class ProductMgrlmpl implements IProductMgr{
	private static ProductMgrlmpl instance = new ProductMgrlmpl();
	

	public static ProductMgrlmpl getInstance() {
		return instance;
	}
	
	private ArrayList<Product> list = new ArrayList<>();
	
	@Override
	public void addProduct(Product item) {
		list.add(item);
	}

	@Override
	public Product[] findAll() {
		int size = list.size();
		Product[] rt = new Product[size];
		for (int i = 0; i < rt.length; i++) {
			rt[i] = list.get(i);
		}
		return rt;
	}

	@Override
	public Product findSerial(String serial) {
		for (Product b : list) {
			if (b.getSerial().equals(serial)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> findName(String name) {
		ArrayList<Product> rt = new ArrayList<>();
		for (Product b : list) {
			if (b.getName().indexOf(name) != -1 ) {
				rt.add(b);
			}
		}
		return rt;
	}

	@Override
	public ArrayList<TV> TVList() {
		ArrayList<TV> rt = new ArrayList<>();
		for (Product b : list) {
			if (b instanceof TV) {
				rt.add((TV)b);
			}
		}
		return rt;
	}

	@Override
	public ArrayList<Refrigerator> RefrigeratorList() {
		ArrayList<Refrigerator> rt = new ArrayList<>();
		for (Product b : list) {
			if (b instanceof Refrigerator) {
				rt.add((Refrigerator)b);
			}
		}
		return rt;
	}

	@Override
	public ArrayList<Refrigerator> findLiter(int liter) {
		ArrayList<Refrigerator> rt = new ArrayList<>();
		for (Product b : list) {
			if (b instanceof Refrigerator) {
				if(((Refrigerator)b).getLiter()>=liter) {
					rt.add((Refrigerator)b);
				}
			}
		}
		return rt;
	}

	@Override
	public ArrayList<TV> findInch(int inch) {
		ArrayList<TV> rt = new ArrayList<>();
		for (Product b : list) {
			if (b instanceof TV) {
				if(((TV)b).getInch()>=inch) {
					rt.add((TV)b);
				}
			}
		}
		return rt;
	}

	@Override
	public boolean changePrice(String serial, int price) {
		for (Product b : list) {
			if (b.getSerial().equals(serial)) {
				b.setPrice(price);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String serial) {
		for (Product b : list) {
			if (b.getSerial().equals(serial)) {
				list.remove(b);
				return true;
			}
		}
		return false;
	}

	@Override
	public int totalPrice() {
		int sum = 0;
		for (Product b : list) {
			sum += b.getPrice()*b.getStock();
		}
		return sum;
	}

}
