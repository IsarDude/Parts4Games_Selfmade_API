package data;

public class Memory {
	private String productID;
	private String brand;
	private String model;
	private String storageCapacity;
	private String rotationSpeed;
	private String type;
	private String fotoURL;
	private String price;
	
	public Memory() {
		
	}

	public Memory(String productID, String brand, String model, String storageCapacity, String rotationSpeed,
			String type, String fotoURL, String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.model = model;
		this.storageCapacity = storageCapacity;
		this.rotationSpeed = rotationSpeed;
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

	public String getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(String storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public String getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(String rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
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