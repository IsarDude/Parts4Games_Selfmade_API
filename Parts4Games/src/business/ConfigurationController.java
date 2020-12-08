package business;

import java.util.LinkedList;

import data.Config;
import data.GPU;
import data.RAM;
import data.Ram;

public class ConfigurationController {
	LinkedList<Config> configList = new LinkedList<>();
	static ConfigurationController instance = new ConfigurationController();
	
	public static ConfigurationController getInstance() {
		return instance;
	}
	
	public int createConfig(Config newConfig) {
		int newID = -1;
		if(configList.size()>0) {
			newID =	configList.getLast().configID +1;
		}else {
			newID= 1;
		}
			
		newConfig.configID = newID;
		configList.add(newConfig);
		return newID;
	}
	
	public Config getConfig(int aConfigId) {
		Config temp = null;
		for(Config conf : configList) {
			if(conf.configID == aConfigId) {
				temp = conf;
			}
			
		}
		return temp;
	}
	
	public int deleteConfig(int aConfigId) {
		Config temp = getConfig(aConfigId);
		if(temp != null) {
			configList.remove(temp);
			return 1;
		}else {
			return -1;
		}
		

	}
	
	public int getConfigIndex(int configId) {
		int index = -1;
		for(int i = 0; i< configList.size();i++) {
			if(configList.get(i).configID == configId) {
				index = i;
			}
			
		}
		return index;
	}
	
	public int addGpuToConfig(int configId, GPU aGpu) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedGpu(aGpu);
		}
		return index;
	}
	
	public int changeGPU(int configId, GPU aGPU) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedGpu(aGPU);
		}
		return index;
	}
	
	public int deleteGPU(int configId) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedGpu(null);
		}
		return index;
	}
	
	public int createBudget(int configId, float budget) {
		int index = getConfigIndex(configId);
		configList.get(index).setBudget(budget);
		
		return index;
	}
	
	public float getBudget(int configId) {
		Config temp = getConfig(configId);
		return temp.getBudget();
	}
	
	public int changeBudget(int configId, float budget) {
		int index = getConfigIndex(configId);
		configList.get(index).setBudget(budget);
		return index;
	}
	
	//Andre
	//#####################
	//Motherboard
	public int addMotherboardToConfig(int configId, Motherboard aMotherboard) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedMotherboard(aMotherboard);
		}
		return index;
	}
	
	public int changeMotherboard(int configId, Motherboard aMotherboard) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedMotherboard(aMotherboard);
		}
		return index;
	}
	
	public int deleteMotherboard(int configId) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedMotherboard(null);  //verstehe nicht, warum "null" nicht akzeptiert wird bei den anderen Datenobjekten gehts auch 
		}
		return index;
	}
	
	//RAM
	public int addRAMToConfig(int configId, RAM aRam) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedRAM(aRam);
		}
		return index;
	}
	
	public int changeRAM(int configId, RAM aRam) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedRAM(aRam);
		}
		return index;
	}
	
	public int deleteRAM(int configId) {
		int index = getConfigIndex(configId);
			
		
		if(index != -1) {
			configList.get(index).setSelectedRAM(null);
		}
		return index;
	}
	//#####################
}
