package data;

public class Ram {
	private String company;
	private String model;
	private int capacity;
	private int frequency;
	private String stickType;
	private String sellType;
	
	public Ram() {
		
	}
	
	public Ram(String company, String model, int capacity, String stickType, String sellType, int frequency) {
		this.company = company;
		this.model = model;
		this.capacity = capacity;
		this.stickType = stickType;
		this.sellType = sellType;
		this.frequency = frequency;
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
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getStickType() {
		return stickType;
	}
	public void setStickType(String stickType) {
		this.stickType = stickType;
	}
	public String getSellType() {
		return sellType;
	}
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}
}
