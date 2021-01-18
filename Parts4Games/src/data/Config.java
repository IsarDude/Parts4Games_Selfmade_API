package data;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLinks;

public class Config {	
	
	public int configID;
	private float budget;
	private GPU selectedGpu;
	private CPU selectedCpu;
	private RAM selectedRAM;
	private Motherboard selectedMotherboard;
	private Memory selectedMemory;
	private PowerAdaptor selectedPoweradaptor;
	
	@InjectLinks({})
	List<Link> links;
	URI uri;

	public void setLinks(List<Link> links) {
		this.links=links;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	public URI getUri() {
		return uri;
	}
	
	public void checkBudget() {
		
	}

	public int getConfigID() {
		return configID;
	}

	public void setConfigID(int configID) {
		this.configID = configID;
	}
	
	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	public GPU getSelectedGpu() {
		return selectedGpu;
	}

	public void setSelectedGpu(GPU selectedGpu) {
		this.selectedGpu = selectedGpu;
	}

	public CPU getSelectedCpu() {
		return selectedCpu;
	}

	public void setSelectedCpu(CPU selectedCpu) {
		this.selectedCpu = selectedCpu;
	}

	public RAM getSelectedRAM() {
		return selectedRAM;
	}

	public void setSelectedRAM(RAM selectedRAM) {
		this.selectedRAM = selectedRAM;
	}
	
	public Motherboard getSelectedMotherboard() {
		return selectedMotherboard;
	}

	public void setSelectedMotherboard(Motherboard selectedMotherboard) {
		this.selectedMotherboard = selectedMotherboard;
	}
	
	public Memory getSelectedMemory() {
		return selectedMemory;
	}

	public void setSelectedMemory(Memory selectedMemory) {
		this.selectedMemory = selectedMemory;
	}

	public PowerAdaptor getSelectedPoweradaptor() {
		return selectedPoweradaptor;
	}

	public void setSelectedPoweradaptor(PowerAdaptor selectedPoweradaptor) {
		this.selectedPoweradaptor = selectedPoweradaptor;
	}	
	
}
