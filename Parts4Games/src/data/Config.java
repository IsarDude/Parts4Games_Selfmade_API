package data;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.linking.InjectLink;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class Config {
	
	
	@InjectLink()
	public int configID;
	private float budget;
	private GPU selectedGpu;
	private CPU selectedCpu;
	private RAM selectedRAM;
	private Motherboard selectedMotherboard;
	private Memory selectedMemory;
	private PowerAdaptor selectedPoweradaptor;

	
	
	
	public void checkBudget() {
		
	}
	@XmlElement(name="configID")
	public int getConfigID() {
		return configID;
	}

	public void setConfigID(int configID) {
		this.configID = configID;
	}
	
	@XmlElement(name="budget")
	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	@XmlElement(name="gpu")
	public GPU getSelectedGpu() {
		return selectedGpu;
	}

	public void setSelectedGpu(GPU selectedGpu) {
		this.selectedGpu = selectedGpu;
	}

	@XmlElement(name="cpus")
	public CPU getSelectedCpu() {
		return selectedCpu;
	}

	public void setSelectedCpu(CPU selectedCpu) {
		this.selectedCpu = selectedCpu;
	}
	@XmlElement(name="ram")
	public RAM getSelectedRAM() {
		return selectedRAM;
	}

	public void setSelectedRAM(RAM selectedRAM) {
		this.selectedRAM = selectedRAM;
	}
	
	@XmlElement(name="motherboard")
	public Motherboard getSelectedMotherboard() {
		return selectedMotherboard;
	}

	public void setSelectedMotherboard(Motherboard selectedMotherboard) {
		this.selectedMotherboard = selectedMotherboard;
	}
	
	@XmlElement(name="memory")
	public Memory getSelectedMemory() {
		return selectedMemory;
	}

	public void setSelectedMemory(Memory selectedMemory) {
		this.selectedMemory = selectedMemory;
	}

	@XmlElement(name="powerAdaptor")
	public PowerAdaptor getSelectedPoweradaptor() {
		return selectedPoweradaptor;
	}

	public void setSelectedPoweradaptor(PowerAdaptor selectedPoweradaptor) {
		this.selectedPoweradaptor = selectedPoweradaptor;
	}
	
	
}
