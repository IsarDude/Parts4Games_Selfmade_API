package data;

public class GPU {
	private String productID;
	private String brand;
	private String model;
	private String chipsetManufacturer;
	private String compatibleSlot;
	private String memoryType;
	private String memorySize;
	private String fotoURL;
	private String price;
	
	public GPU() {
		
	}

	public GPU(String productID, String brand, String model, String chipsetManufacturer, String compatibleSlot,
			String memoryType, String memorySize, String fotoURL, String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.model = model;
		this.chipsetManufacturer = chipsetManufacturer;
		this.compatibleSlot = compatibleSlot;
		this.memoryType = memoryType;
		this.memorySize = memorySize;
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

	public String getChipsetManufacturer() {
		return chipsetManufacturer;
	}

	public void setChipsetManufacturer(String chipsetManufacturer) {
		this.chipsetManufacturer = chipsetManufacturer;
	}

	public String getCompatibleSlot() {
		return compatibleSlot;
	}

	public void setCompatibleSlot(String compatibleSlot) {
		this.compatibleSlot = compatibleSlot;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public String getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
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
