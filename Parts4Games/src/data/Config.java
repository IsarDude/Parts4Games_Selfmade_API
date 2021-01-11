package data;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
@Entity
public class Config implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5989583149926908655L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int configID;
	
	@Column
	private float budget;
	@Column
	private GPU selectedGpu;
	@Column
	private CPU selectedCpu;
	@Column
	private RAM selectedRAM;
	@Column
	private Motherboard selectedMotherboard;
	@Column
	private Memory selectedMemory;
	@Column
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
