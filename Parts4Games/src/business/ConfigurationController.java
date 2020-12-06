package business;

import java.util.LinkedList;

import model.Config;
import model.GPU;

public class ConfigurationController {
	LinkedList<Config> configList = new LinkedList<>();
	static ConfigurationController instance = new ConfigurationController();
	
	public static ConfigurationController getInstance() {
		return instance;
	}
	
	public int createConfig(Config newConfig) {
		int newID = configList.getLast().configID +1;
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
		Config temp = null;
		for(Config conf : configList) {
			if(conf.configID == aConfigId) {
				temp = conf;
			}
			
		}
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
	
	public GPU addGpuToConfig(int configId, GPU aGpu) {
		int index = -1;
		for(int i = 0; i< configList.size();i++) {
			if(configList.get(i).configID == configId) {
				index = i;
			}
			
		}
		if(index != -1) {
			configList.get(index).setSelectedGpu(aGpu);
		}
		return aGpu;
	}
	
	public void changeGPU(int configId, GPU aGPU) {
		int index = -1;
		for(int i = 0; i< configList.size();i++) {
			if(configList.get(i).configID == configId) {
				index = i;
			}
			
		}
		if(index != -1) {
			configList.get(index).setSelectedGpu(aGPU);
		}
	}
	
	public void deleteGPU(int configId) {
		int index = -1;
		for(int i = 0; i< configList.size();i++) {
			if(configList.get(i).configID == configId) {
				index = i;
			}
			
		}
		if(index != -1) {
			configList.get(index).setSelectedGpu(null);
		}
	}
	
	public float createBudget(int configId, float budget) {
		int index = getConfigIndex(configId);
		configList.get(index).setBudget(budget);
		
		return budget;
	}
	
	public float getBudget(int configId) {
		Config temp = getConfig(configId);
		return temp.getBudget();
	}
	
	public void changeBudget(int configId, float budget) {
		int index = getConfigIndex(configId);
		configList.get(index).setBudget(budget);
	}
	
}
