package HW0205;

public class Tv extends Products{
	private int inch;
	private String type;

	public Tv(int serial,String name, int price, int stock,int inch,String type) {
		super(serial, name, price, stock);
		this.inch =inch;
		this.type =type;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "\t인치 : "+inch+"\t디스플레이타입 : "+type;
		return str;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
