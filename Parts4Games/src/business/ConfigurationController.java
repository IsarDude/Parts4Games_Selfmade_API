package business;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data.Config;
import data.GPU;
import data.Memory;
import data.RAM;
import data.CPU;
import data.Motherboard;

import data.PowerAdaptor;


public class ConfigurationController {
	
	//EntityFactory und Manager für persistence
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parts4Games_Parts4Games");
	EntityManager em = emf.createEntityManager();
	
	LinkedList<Config> configList = new LinkedList<>();
	
	static ConfigurationController instance = new ConfigurationController();
	
	public static ConfigurationController getInstance() {
		return instance;
	}
	
	//DB added
	public Config createConfig() {
		
		em.getTransaction().begin();
		
		Config newConfig = new Config();
		
		
		em.persist(newConfig);
		em.getTransaction().commit();
		
		return newConfig;
	}
	
	//DB added
	public Config getConfig(int aConfigId) {
		Config temp = null;
		
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";

		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		
		List<Config> configs = query.getResultList();
		
		temp = configs.get(0);
		
		return temp;
	}
	
	//DB added... es wird zwar der komplette config eintrag gelöscht, aber die bestandteile davon(cpu,gpu,...) bleiben in ihren jeweiligen Tables noch enthalten
	public boolean deleteConfig(int aConfigId) {
		
		//DB
		Config temP = null;
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		List<Config> configs = query.getResultList();
		temP = configs.get(0);
		em.getTransaction().begin();
		em.remove(temP);
		em.getTransaction().commit();
		
		
		Config temp = getConfig(aConfigId);
		if(temp != null) {
			configList.remove(temp);
			return true;
		}else {
			return false;
		}
	}
	
	
	//DB added
	public CPU addCpuToConfig(int configId,CPU aCpu) throws IOException {
		Config config = getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		config = configs.get(0);
		em.getTransaction().begin();
		config.setSelectedCpu(aCpu);
		em.persist(config);
		em.getTransaction().commit();
		
		
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
	
	//DB added
	public GPU addGpuToConfig(int configId, GPU aGpu) throws IOException{
		Config config = getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		config = configs.get(0);
		em.getTransaction().begin();
		config.setSelectedGpu(aGpu);
		em.persist(config);
		em.getTransaction().commit();
		
		
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
	
	//DB added
	public Motherboard addMotherboardToConfig(int configId, Motherboard aMotherboard) throws IOException {
		Config conf= getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		conf = configs.get(0);
		em.getTransaction().begin();
		conf.setSelectedMotherboard(aMotherboard);
		em.persist(conf);
		em.getTransaction().commit();
		
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
	
	//DB added
	public RAM addRAMToConfig(int configId, RAM aRam) throws IOException {
		Config conf= getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		conf = configs.get(0);
		em.getTransaction().begin();
		conf.setSelectedRAM(aRam);
		em.persist(conf);
		em.getTransaction().commit();
		
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
	
	//DB added
	public Memory addMemoryToConfig(int configId, Memory aMemory) throws IOException {
		Config conf= getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		conf = configs.get(0);
		em.getTransaction().begin();
		conf.setSelectedMemory(aMemory);
		em.persist(conf);
		em.getTransaction().commit();
		
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
	
	//DB added
	public PowerAdaptor addPowerAdaptorToConfig(int configId, PowerAdaptor aPowerAdaptor) throws IOException {
		Config conf= getConfig(configId);
		
		//DB
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", configId);
		List<Config> configs = query.getResultList();	  
		conf = configs.get(0);
		em.getTransaction().begin();
		conf.setSelectedPoweradaptor(aPowerAdaptor);
		em.persist(conf);
		em.getTransaction().commit();
		
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
