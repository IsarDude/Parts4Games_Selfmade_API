package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class Motherboard {
	private String company;
	private String brand;
	private int socket;
	private String ports;
	private String formfactor;
	private String chipset;
	private String ddrmemory;
	private float price;
	
	public Motherboard() {}
	public Motherboard(int aSocket, String aPorts, String aFormfactor, String aCompany, String aBrand, String aChipset, String aDdrMemory, float aPrice) {
		super();
		this.ddrmemory = aDdrMemory;
		this.ports= aPorts;
		this.formfactor = aFormfactor;
		this.company = aCompany;
		this.brand = aBrand;
		this.chipset = aChipset;
		this.socket = aSocket;
		this.price=aPrice;
		
	}
	
	@XmlElement(name="company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@XmlElement(name="formfactor")
	public String getFormFactor() {
		return formfactor;
	}
	public void setFormFactor(String formfactor) {
		this.formfactor = formfactor;
	}
	
	@XmlElement(name="brand")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@XmlElement(name="socket")
	public int getSocket() {
		return socket;
	}
	public void setSocket(int socket) {
		this.socket = socket;
	}
	
	@XmlElement(name="ports")
	public String getPorts() {
		return ports;
	}
	
	public void setPorts(int aPorts) {
		this.ports = aPorts;
	}
	
	@XmlElement(name="ddrmemory")
	public String getddrmemory() {
		return ddrmemory;
	}
	public void setDDRmemory(String ddrmemory) {
		this.ddrmemory = ddrmemory;
	}
	
	@XmlElement(name="chipset")
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	
	@XmlElement(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getKeywordString() {
		String keywords = "CPU " + ddrmemory + "gb";
		if(company != null) {
			keywords = keywords +" " + company;
		}
		if(model != null) {
			keywords = keywords+ " " + model;
		}
		return keywords;
	}
	
}