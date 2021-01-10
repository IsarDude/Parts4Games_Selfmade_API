package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class GPU {
	private String productIdEAN;
	private String compatibleSlot;
	private String chipsetManufacturer;
	private String brand;
	private String chipsetGPUModel;
	private String fotoURL;
	private float price;
	
	public GPU() {}
	
	
	
	
	
	public GPU(String productIdEAN, String compatibleSlot, String chipsetManufacturer, String brand,
			String chipsetGPUModel, String fotoURL, float price) {
		super();
		this.productIdEAN = productIdEAN;
		this.compatibleSlot = compatibleSlot;
		this.chipsetManufacturer = chipsetManufacturer;
		this.brand = brand;
		this.chipsetGPUModel = chipsetGPUModel;
		this.fotoURL = fotoURL;
		this.price = price;
	}





	@XmlElement(name="fotoURL")
	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	@XmlElement(name="ProductIdEAN")
	public String getProductIdEAN() {
		return productIdEAN;
	}

	public void setProductIdEAN(String productIdEAN) {
		this.productIdEAN = productIdEAN;
	}

	@XmlElement(name="compatibleSlot")
	public String getCompatibleSlot() {
		return compatibleSlot;
	}

	public void setCompatibleSlot(String compatibleSlot) {
		this.compatibleSlot = compatibleSlot;
	}

	@XmlElement(name="chipsetManufacturer")
	public String getChipsetManufacturer() {
		return chipsetManufacturer;
	}
	
	public void setChipsetManufacturer(String chipsetManufacturer) {
		this.chipsetManufacturer = chipsetManufacturer;
	}
	
	@XmlElement(name="Brand")

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	@XmlElement(name="chipsetGPUModel")
	
	public String getChipsetGPUModel() {
		return chipsetGPUModel;
	}

	public void setChipsetGPUModel(String chipsetGPUModel) {
		this.chipsetGPUModel = chipsetGPUModel;
	}
	
	@XmlElement(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public String getKeywordString() {
		String keywords = "GPU " + "Hz " + "Gb" ;
		if(chipsetGPUModel != null) {
			keywords = keywords +" " + chipsetGPUModel;
		}
		if(brand != null) {
			keywords = keywords+ " " + brand;
		}
		return keywords;
	}





	
	
	
}
