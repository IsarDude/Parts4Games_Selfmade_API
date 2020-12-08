package business;

import data.PowerAdaptor;

public class PowerAdaptorBusinessController {
	ConfigurationController configurationController = ConfigurationController.getInstance();
	
	public void addPowerAdaptor(int configId, PowerAdaptor powerAdaptor) {
		//add Power Adaptor to configuration
		configurationController.addPowerAdaptorToConfig(configId, powerAdaptor);
	}
	
	public void changePowerAdaptor(int configId, PowerAdaptor powerAdaptor) {
		//change Power Adaptor in configuration
		configurationController.addPowerAdaptorToConfig(configId, powerAdaptor);
	}
	
	public void deletePowerAdaptor(int configId) {
		//delete Power Adaptor in configuration
		configurationController.deletePowerAdaptor(configId);
	}
}