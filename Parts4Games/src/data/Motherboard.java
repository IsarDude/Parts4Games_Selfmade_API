package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class Motherboard {
	private String company;
	private String model;
	private int socket;
	private int frontsidebus;
	private String formfactor;
	private String chipset;
	private String ddrmemory;
	private float price;
	
	public Motherboard() {}
	public Motherboard(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice) {
		super();
		this.ddrmemory = aDdrMemory;
		this.frontsidebus= aFrontSideBus;
		this.formfactor = aFormfactor;
		this.company = aCompany;
		this.model = aModel;
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
	
	@XmlElement(name="model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@XmlElement(name="socket")
	public int getSocket() {
		return socket;
	}
	public void setSocket(int socket) {
		this.socket = socket;
	}
	
	@XmlElement(name="frontsidebus")
	public int getFronsidebus() {
		return frontsidebus;
	}
	
	public void setFrontsidebus(int aFrontsidebus) {
		this.frontsidebus = aFrontsidebus;
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