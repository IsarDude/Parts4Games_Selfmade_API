package data;

public class PowerAdaptor {
	private String productID;
	private String brand;
	private String maximumPower;
	private String formFactor;
	private String fotoURL;
	private String price;
	
	public PowerAdaptor() {
		
	}

	public PowerAdaptor(String productID, String brand, String maximumPower, String formFactor, String fotoURL,
			String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.maximumPower = maximumPower;
		this.formFactor = formFactor;
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

	public String getMaximumPower() {
		return maximumPower;
	}

	public void setMaximumPower(String maximumPower) {
		this.maximumPower = maximumPower;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
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
