package business;

import java.util.LinkedList;

import data.Config;
import data.GPU;
import data.Memory;
import data.RAM;

import data.PowerAdaptor;


public class ConfigurationController {
	LinkedList<Config> configList = new LinkedList<>();
	static ConfigurationController instance = new ConfigurationController();
	
	public static ConfigurationController getInstance() {
		return instance;
	}
	
	public int createConfig(Config newConfig) {
		int newID = -1;
		if(configList.size()>0) {
			newID =	configList.getLast().getConfigID() + 1;
		}else {
			newID = 1;
		}
		newConfig.setConfigID(newID);
		configList.add(newConfig);
		return newID;
	}
	
	public Config getConfig(int aConfigId) {
		Config temp = null;
		for(Config conf : configList) {
			if(conf.getConfigID() == aConfigId) {
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
			if(configList.get(i).getConfigID() == configId) {
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
	
	public int setBudget(int configId, float budget) {
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

	public int addMemoryToConfig(int configId, Memory aMemory) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedMemory(aMemory);
		}
		return index;
	}
	
	public int changeMemory(int configId, Memory aMemory) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedMemory(aMemory);
		}
		return index;
	}
	
	public int deleteMemory(int configId) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedMemory(null);
		}
		return index;
	}
	
	public int addPowerAdaptorToConfig(int configId, PowerAdaptor aPowerAdaptor) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedPoweradaptor(aPowerAdaptor);
		}
		return index;
	}
	
	public int changePowerAdaptor(int configId, PowerAdaptor aPowerAdaptor) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedPoweradaptor(aPowerAdaptor);
		}
		return index;
	}
	
	public int deletePowerAdaptor(int configId) {
		int index = getConfigIndex(configId);
		if(index != -1) {
			configList.get(index).setSelectedPoweradaptor(null);
		}
		return index;
	}

}
