package homework;

public class Refrigerator extends Product  {
	private int liter;


	public Refrigerator(String serial, String name, int price, int stock, int liter) {
		super(serial, name, price, stock);
		this.liter = liter;
	}


	@Override
	public String toString() {
		return "Refrigerator [serial=" + super.getSerial() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", stock=" + super.getStock()+", liter="+liter+ "]";
	}


	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	
	
}
