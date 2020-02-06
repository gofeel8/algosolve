package Hw0206;

public class Product {
	private String serial;
	private String name;
	private int price;
	private int stock;
	
	public Product(String serial, String name, int price, int stock) {
		super();
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [serial=" + serial + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	



	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
