package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class CPU {
	private int socket;
	private String brand;
	private int cache;
	private int cores;
	private float price;
	private String fotoUrl;
	private int clockspeed;
	
	public CPU () {
		
	}
	
	public CPU(String afotoUrl, int aclockspeed, int aSocket, int aCores, String aBrand, int aCache, float aPrice) {
		super();
		this.clockspeed = aclockspeed;
		this.fotoUrl = afotoUrl;
		this.cores = aCores;
		this.brand = aBrand;
		this.cache = aCache;
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
	public int getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(int clockspeed) {
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

	@XmlElement(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}