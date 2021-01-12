package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class CPU {
	private int socket;
	private String brand;
	private int cache;
	private int cores;
	private float price;
	private String fotoUrl;
	private int clockspeed;
	
	
	public CPU () {}
	public CPU(String afotoUrl, int aclockspeed, int aSocket, int aCores, String aBrand, int aCache, float aPrice) {
		super();
		this.clockspeed = aclockspeed;
		this.fotoUrl = afotoUrl;
		this.cores = aCores;
		this.company = aBrand;
		this.cache = aCache;
		this.generation= aGeneration;
		this.socket = aSocket;
		this.price=aPrice;
		
	}
	@XmlElement(name="cache")
	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}
	
	@XmlElement(name="clockspeed")
	public int getSocket() {
		return clockspeed;
	}

	public void setSocket(int clockspeed) {
		this.clockspeed = clockspeed;
	}
	
	@XmlElement(name="socket")
	public int getSocket() {
		return socket;
	}

	public void setSocket(int socket) {
		this.socket = socket;
	}
	
	@XmlElement(name="cores")
	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}
	
	@XmlElement(name="fotoUrl")
	public String getFotoUrl() {
		return fotoUrl;
	}
	
	
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	@XmlElement(name="brand")
	public String getBrand() {
		return brand;
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@XmlElement(name="model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement(name="generation")
	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}
	
	@XmlElement(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getKeywordString() {
		String keywords = "CPU "+ frequency + "Hz ";
		if(company != null) {
			keywords = keywords +" " + company;
		}
		if(model != null) {
			keywords = keywords+ " " + model;
		}
		return keywords;
	}
	
	
}