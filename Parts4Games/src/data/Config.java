package data;

import java.io.Serializable;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.Binding;

import rest.ConfigService;


@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
@Entity
public class Config implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5989583149926908655L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int configID;
	
	@Column
	private float budget;
	@OneToOne(cascade = CascadeType.ALL)
	private GPU selectedGpu;
	@OneToOne(cascade = CascadeType.ALL)
	private CPU selectedCpu;
	@OneToOne(cascade = CascadeType.ALL)
	private RAM selectedRAM;
	@OneToOne(cascade = CascadeType.ALL)
	private Motherboard selectedMotherboard;
	@OneToOne(cascade = CascadeType.ALL)
	private Memory selectedMemory;
	@OneToOne(cascade = CascadeType.ALL)
	private PowerAdaptor selectedPoweradaptor;
	
	/*
	  @InjectLink(resource = ConfigService.getConfig, value="/stuff", rel="create", style = Style.ABSOLUTE),
				@InjectLink( value="config/{configId}", rel="self", style=Style.ABSOLUTE,
				bindings= @Binding(name= "configId", value="${instance.configID}"))
	  */
	
	@InjectLinks({})
	List<Link> links;
	URI uri;
	/*
	@InjectLink(resource=ConfigService.class, style=Style.ABSOLUTE)
	private URI uri;
	*/
	@XmlElement(name="links")
	public void setLinks(List<Link> links) {
		this.links=links;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	@XmlElement(name="uri")
	public void setUri(URI uri) {
		this.uri = uri;
	}

	public URI getUri() {
		return uri;
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

	@XmlElement(name="powerAdaptor")
	public PowerAdaptor getSelectedPoweradaptor() {
		return selectedPoweradaptor;
	}

	public void setSelectedPoweradaptor(PowerAdaptor selectedPoweradaptor) {
		this.selectedPoweradaptor = selectedPoweradaptor;
	}
	
	
}