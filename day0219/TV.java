package homework;

public class TV extends Product {
	private int inch;

	

	public TV(String serial, String name, int price, int stock, int inch) {
		super(serial, name, price, stock);
		this.inch = inch;
	}


	@Override
	public String toString() {
		return "Tv [serial=" + super.getSerial() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", stock=" + super.getStock()+", inch="+inch+ "]";
	}


	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	
}
