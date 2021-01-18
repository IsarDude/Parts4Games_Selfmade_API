package data;

public class RAM {	
	private String productID;
	private String brand;
	private String model;
	private String totalcapacity;
	private String busSpeed;
	private String type;
	private String fotoURL;
	private String price;
	
	public RAM() {
		
	}

	public RAM(String productID, String brand, String model, String totalcapacity, String busSpeed, String type,
			String fotoURL, String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.model = model;
		this.totalcapacity = totalcapacity;
		this.busSpeed = busSpeed;
		this.type = type;
		this.fotoURL = fotoURL;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTotalcapacity() {
		return totalcapacity;
	}

	public void setTotalcapacity(String totalcapacity) {
		this.totalcapacity = totalcapacity;
	}

	public String getBusSpeed() {
		return busSpeed;
	}

	public void setBusSpeed(String busSpeed) {
		this.busSpeed = busSpeed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
