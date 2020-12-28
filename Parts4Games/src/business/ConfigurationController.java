package business;

import java.io.IOException;
import java.util.LinkedList;

import data.Config;
import data.GPU;
import data.Memory;
import data.RAM;
import data.CPU;
import data.Motherboard;

import data.PowerAdaptor;


public class ConfigurationController {
	LinkedList<Config> configList = new LinkedList<>();
	static ConfigurationController instance = new ConfigurationController();
	
	public static ConfigurationController getInstance() {
		return instance;
	}
	
	public int createConfig() {
		int newID;
		Config newConfig = new Config();
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
	
	public boolean deleteConfig(int aConfigId) {
		Config temp = getConfig(aConfigId);
		if(temp != null) {
			configList.remove(temp);
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public CPU addCpuToConfig(int configId,CPU aCpu) throws IOException {
		Config config = getConfig(configId);
		if(config != null) {
			config.setSelectedCpu(aCpu);
			return config.getSelectedCpu();
		}else {
			throw new IOException();
		}
			
		
		
	}
	
	public CPU changeCPU(int configId, CPU aCPU) throws IOException{
		Config config = getConfig(configId);
		if(config != null) {
			config.setSelectedCpu(aCPU);
			return config.getSelectedCpu();
		}else {
			throw new IOException();
		}
		
		
	}
	
	
	public void deleteCPU(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedCpu(null);
			
		}else {
			throw new IOException();
		}
			
		
	}
	
	public GPU addGpuToConfig(int configId, GPU aGpu) throws IOException{
		Config config = getConfig(configId);
		if(config != null) {
			config.setSelectedGpu(aGpu);
			return config.getSelectedGpu();
		}else {
			throw new IOException();
		}
	}
	
	public GPU changeGPU(int configId, GPU aGPU) throws IOException {
		Config config = getConfig(configId);
		if(config != null) {
			config.setSelectedGpu(aGPU);
			return config.getSelectedGpu();
		}else {
			throw new IOException();
		}
	}
	
	public void deleteGPU(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedGpu(null);
			
		}else {
			throw new IOException();
		}
	}
	
	public float setBudget(int configId, float budget) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setBudget(budget);
			return conf.getBudget();
		}else {
			throw new IOException();
		}
	}
	
	public float getBudget(int configId) throws IOException {
		Config temp = getConfig(configId);
		if(temp == null) {
			throw new IOException();
		}
		return temp.getBudget();
	}
	
	public float changeBudget(int configId, float budget)  throws IOException {
		Config conf = getConfig(configId);
		if(conf != null) {
			conf.setBudget(budget);
			return conf.getBudget();
		}else {
			throw new IOException();
		}
	}
	
	public Motherboard addMotherboardToConfig(int configId, Motherboard aMotherboard) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedMotherboard(aMotherboard);
			return conf.getSelectedMotherboard();
		}else {
			throw new IOException();
		}
	}
	
	public Motherboard changeMotherboard(int configId, Motherboard aMotherboard) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedMotherboard(aMotherboard);
			return conf.getSelectedMotherboard();
		}else {
			throw new IOException();
		}
	}
	
	public boolean deleteMotherboard(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedMotherboard(null);
			return true;
		}else {
			throw new IOException();
		}
	}
	
	public RAM addRAMToConfig(int configId, RAM aRam) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedRAM(aRam);
			return conf.getSelectedRAM();
		}else {
			throw new IOException();
		}
	}
	
	public RAM changeRAM(int configId, RAM aRam) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedRAM(aRam);
			return conf.getSelectedRAM();
		}else {
			throw new IOException();
		}
	}
	
	public boolean deleteRAM(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedRAM(null);
			return true;
		}else {
			throw new IOException();
		}
	}

	public Memory addMemoryToConfig(int configId, Memory aMemory) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedMemory(aMemory);
			return conf.getSelectedMemory();
		}else {
			throw new IOException();
		}
	}
	
	public Memory changeMemory(int configId, Memory aMemory) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedMemory(aMemory);
			return conf.getSelectedMemory();
		}else {
			throw new IOException();
		}
	}
	
	public boolean deleteMemory(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedRAM(null);
			return true;
		}else {
			throw new IOException();
		}
	}
	
	public PowerAdaptor addPowerAdaptorToConfig(int configId, PowerAdaptor aPowerAdaptor) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedPoweradaptor(aPowerAdaptor);
			return conf.getSelectedPoweradaptor();
		}else {
			throw new IOException();
		}
	}
	
	public PowerAdaptor changePowerAdaptor(int configId, PowerAdaptor aPowerAdaptor) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedPoweradaptor(aPowerAdaptor);
			return conf.getSelectedPoweradaptor();
		}else {
			throw new IOException();
		}
	}
	
	public boolean deletePowerAdaptor(int configId) throws IOException {
		Config conf= getConfig(configId);
		if(conf != null) {
			conf.setSelectedPoweradaptor(null);
			return true;
		}else {
			throw new IOException();
		}
	}

}
