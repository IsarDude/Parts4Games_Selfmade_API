package data;

public class Memory {
	private String company;
	private String model;
	private int capacity;
	private int speed;
	private String version;
	
	public Memory() {
		
	}
	
	public Memory(String company, String model, int capacity, String version, int speed) {
		this.company = company;
		this.model = model;
		this.capacity = capacity;
		this.version = version;
		this.speed = speed;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}