package data;

public class Motherboard {
	private String productID;
	private String brand;
	private String numberOfMemorySlots;
	private String formFactor;
	private String socketType;
	private String compatibleCpuBrand;
	private String memoryType;
	private String fotoURL;
	private String price;
	
	public Motherboard() {
		
	}

	public Motherboard(String productID, String brand, String numberOfMemorySlots, String formFactor, String socketType,
			String compatibleCpuBrand, String memoryType, String fotoURL, String price) {
		super();
		this.productID = productID;
		this.brand = brand;
		this.numberOfMemorySlots = numberOfMemorySlots;
		this.formFactor = formFactor;
		this.socketType = socketType;
		this.compatibleCpuBrand = compatibleCpuBrand;
		this.memoryType = memoryType;
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

	public String getNumberOfMemorySlots() {
		return numberOfMemorySlots;
	}

	public void setNumberOfMemorySlots(String numberOfMemorySlots) {
		this.numberOfMemorySlots = numberOfMemorySlots;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String getSocketType() {
		return socketType;
	}

	public void setSocketType(String socketType) {
		this.socketType = socketType;
	}

	public String getCompatibleCpuBrand() {
		return compatibleCpuBrand;
	}

	public void setCompatibleCpuBrand(String compatibleCpuBrand) {
		this.compatibleCpuBrand = compatibleCpuBrand;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
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