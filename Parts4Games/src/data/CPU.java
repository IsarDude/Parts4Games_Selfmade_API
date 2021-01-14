package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class CPU {
	private String productIdEAN;
	private String socket;
	private String brand;
	private String cache;
	private String cores;
	private float price;
	private String photoUrl;
	private String clockspeed;
	
	public CPU () {
		
	}
	
	public CPU(String photoUrl, String aproductIdEAN, String aclockspeed, String aSocket, String aCores, String aBrand, String aCache, float aPrice) {
		super();
		this.productIdEAN = aproductIdEAN;
		this.clockspeed = aclockspeed;
		this.cores = aCores;
		this.brand = aBrand;
		this.cache = aCache;
		this.socket = aSocket;
		this.price=aPrice;
		this.photoUrl = aphotoUrl;
		
	}
	
	@XmlElement(name="cache")
	public int getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}
	
	@XmlElement(name="clockspeed")
	public String getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(String clockspeed) {
		this.clockspeed = clockspeed;
	}
	
	@XmlElement(name="socket")
	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	@XmlElement(name="cores")
	public String getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}
	
	@XmlElement(name="productIdEAN")
	public String getProductIdEAN() {
		return productIdEAN;
	}
	
	
	public void setProductIdEAN(String productIdEAN) {
		this.productIdEAN = productIdEAN;
	}

	@XmlElement(name="brand")
	public String getBrand() {
		return brand;
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@XmlElement(name="photoUrl")
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@XmlElement(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}