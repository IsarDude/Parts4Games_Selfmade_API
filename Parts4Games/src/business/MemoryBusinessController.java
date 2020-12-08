package business;

public class MemoryBusinessController {
	ConfigurationController configurationController = ConfigurationController.getInstance();
	
	public void addMemory(int configId, Memory memory) {
		//add Memory to configuration
		configurationController.addMemoryToConfig(configId, memory);
	}
	
	public void changeMemory(int configId, Memory memory) {
		//change Memory in configuration
		configurationController.addMemoryToConfig(configId, memory);
	}
	
	public void deleteMemory(int configId) {
		//delete Memory in configuration
		configurationController.deleteMemory(configId);
	}
}
