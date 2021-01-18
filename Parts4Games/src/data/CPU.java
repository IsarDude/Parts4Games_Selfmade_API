package data;

public class CPU {
	private String productID;
	private String brand;
	private String processorType;
	private String socketType;
	private String numberOfCores;
	private String clockspeed;
	private String fotoUrl;
	private String price;
	
	public CPU () {
		
	}

	public CPU(String productID, String brand, String processorType, String socketType, String numberOfCores,
			String clockspeed, String fotoUrl, String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.processorType = processorType;
		this.socketType = socketType;
		this.numberOfCores = numberOfCores;
		this.clockspeed = clockspeed;
		this.fotoUrl = fotoUrl;
		this.price = price;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public String getSocketType() {
		return socketType;
	}

	public void setSocketType(String socketType) {
		this.socketType = socketType;
	}

	public String getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(String numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public String getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(String clockspeed) {
		this.clockspeed = clockspeed;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}