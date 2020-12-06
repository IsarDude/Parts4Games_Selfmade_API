package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class GPU {
	private int frequency;
	private int memory;
	private String company;
	private String model;
	private String generation;
	private float price;
	
	public GPU(int aFrequency, int aMemory, String aCompany, String aModel, String aGeneration, float aPrice) {
		super();
		this.frequency= aFrequency;
		this.memory = aMemory;
		this.company = aCompany;
		this.model = aModel;
		this.generation= aGeneration;
		this.price=aPrice;
		
	}
	
	@XmlElement(name="frequency")
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	@XmlElement(name="memory")
	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
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
	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
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
		String keywords = "GPU "+ frequency + "Hz " + memory + "Gb" ;
		if(company != null) {
			keywords = keywords +" " + company;
		}
		if(model != null) {
			keywords = keywords+ " " + model;
		}
		if(generation != null) {
			keywords = keywords + " "+ generation;
		}
		return keywords;
	}
	
	
}
