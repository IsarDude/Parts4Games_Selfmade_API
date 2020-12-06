package model;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class Config {
	public int configID;
	private float budget;
	private GPU selectedGpu;
	private CPU selectedCpu;
	private RAM selectedRAM;
	private Motherboard selectedMotherboard;
	private Memory selectedMemory;
	private PowerAdapter selectedPoweradapter;

	
	public void getConfig() {
		LinkedList<Object> list = new LinkedList<>();
		list.addAll(configID, budget,selectedGpu, selectedCpu, selectedRAM, selectedMotherboard, selectedMemory, selectedPoweradapter );
		return list;
	}
	
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

	@XmlElement(name="powerAdapter")
	public PowerAdapter getSelectedPoweradapter() {
		return selectedPoweradapter;
	}

	public void setSelectedPoweradapter(PowerAdapter selectedPoweradapter) {
		this.selectedPoweradapter = selectedPoweradapter;
	}
	
	
}
