package HW0205;

public class Products {
	private int serial;
	private String name;
	private int price;
	private int stock;
	
	public Products(int serial, String name,int price, int stock) {
		super();
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		String str = "제품 번호 : "+serial+"\t제품 이름 : "+name+"\t제품 가격 : "+price+"원\t수량 : "+stock;
		return str;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
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
