package HW0205;

public class Refrigerator extends Products {
	private int liter;
	
	public Refrigerator(int serial,String name, int price, int stock,int liter) {
		super(serial, name, price, stock);
		this.liter=liter;
	}
	
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "\t리터 : "+liter;
		return str;
	}


	public int getLiter() {
		return liter;
	}


	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	

}
