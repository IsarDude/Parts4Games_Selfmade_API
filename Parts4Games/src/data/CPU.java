package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
@Entity
public class CPU {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private int frequency;
	private int socket;
	private String company;
	private String model;
	private int generation;
	private int cores;
	private float price;
	

	public CPU() {
		super();
	}

	public CPU(int aSocket, int aFrequency, int aCores, String aCompany, String aModel, int aGeneration, float aPrice) {
		super();
		this.frequency= aFrequency;
		this.cores = aCores;
		this.company = aCompany;
		this.model = aModel;
		this.generation= aGeneration;
		this.socket = aSocket;
		this.price=aPrice;
		
	}
	
	@XmlElement(name="socket")
	public int getSocket() {
		return socket;
	}

	public void setSocket(int socket) {
		this.socket = socket;
	}
	
	@XmlElement(name="frequency")
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	@XmlElement(name="cores")
	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	@XmlElement(name="company")
	public String getCompany() {
		return company;
	}
	
	
	public void setCompany(String company) {
		this.company = company;
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