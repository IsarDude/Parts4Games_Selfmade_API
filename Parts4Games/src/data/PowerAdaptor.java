package data;

public class PowerAdaptor {
	private String productIdEAN;
	private String brand;
	private String maximumPower;
	private String formfactor;
	private String photoURL;
	private float price;
	
	public PowerAdaptor() {
		
	}
	
	public PowerAdaptor(String productIdEAN, String brand, String maximumPower, String formfactor, String photoURL, float price) {
		this.productIdEAN = productIdEAN;
		this.brand = brand;
		this.maximumPower = maximumPower;
		this.formfactor = formfactor;
		this.photoURL = photoURL;
		this.price = price;
	}

	public String getProductIdEAN() {
		return productIdEAN;
	}

	public void setProductIdEAN(String productIdEAN) {
		this.productIdEAN = productIdEAN;
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

	public String getFormfactor() {
		return formfactor;
	}

	public void setFormfactor(String formfactor) {
		this.formfactor = formfactor;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
