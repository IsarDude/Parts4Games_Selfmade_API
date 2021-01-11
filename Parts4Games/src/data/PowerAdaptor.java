package data;

public class PowerAdaptor {
	private String company;
	private String model;
	private int tension;
	private int power;
	private float price;
	
	public PowerAdaptor() {}
	public PowerAdaptor(String company, String model, int tension, int power, float price) {
		super();
		this.company = company;
		this.model = model;
		this.tension = tension;
		this.power = power;
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getTension() {
		return tension;
	}
	public void setTension(int tension) {
		this.tension = tension;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
