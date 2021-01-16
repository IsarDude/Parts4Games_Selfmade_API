package persistence;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import data.CPU;
import data.Config;
import data.GPU;

public class ConfigTest {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Parts4Games_Parts4Games");
		em = emf.createEntityManager();
	}

	/*
	 * @Test public void saveConfig() {
	 * 
	 * em.getTransaction().begin(); //Instanz von Config erstellen und mit Budget
	 * und einer GPU füllen Config conf = new Config(); conf.setBudget(1000); GPU
	 * gpu = new GPU("add", "add", "add", "NVidia", "RTX 2070", "2000er", 350);
	 * conf.setSelectedGpu(gpu);
	 * 
	 * em.persist(conf); em.getTransaction().commit();
	 * 
	 * }
	 * 
	 * @Test public void loadConfig() { String sql = "SELECT e FROM Config e";
	 * 
	 * Query query = em.createQuery(sql); List<Config> configs =
	 * query.getResultList();
	 * 
	 * for(Config config : configs) { System.out.printf("%d ",
	 * config.getConfigID()); System.out.printf("%s ", config.getSelectedCpu());
	 * System.out.printf("%s ", config.getSelectedGpu()); System.out.printf("%s ",
	 * config.getSelectedMemory()); System.out.printf("%s ",
	 * config.getSelectedMotherboard()); System.out.printf("%s ",
	 * config.getSelectedPoweradaptor()); System.out.print(config.getSelectedRAM());
	 * } }
	 */

	
	//getBudget
	/*
	@Test
	public void loadBudgetOutOfConfig() {
		int configID = 7;
		
		String sql = "SELECT e.budget FROM Config e WHERE e.configID = :id";

		Query query = em.createQuery(sql);
		query.setParameter("id", configID);
		
		List<Float> budgets = query.getResultList();

		for (Float budget : budgets) {
			System.out.println("\n\n\n### Budget = " + budget + " ###\n\n");
		}
	}
	*/
	 

	/*
	@Test
	public void newConfig() {
		LinkedList<Config> configList = new LinkedList<>();
		em.getTransaction().begin();

		int newID;
		Config newConfig = new Config();
		if (configList.size() > 0) {
			newID = configList.getLast().getConfigID() + 1;
		} else {
			newID = 1;
		}
		newConfig.setConfigID(newID);
		configList.add(newConfig);

		em.persist(newConfig);
		em.getTransaction().commit();
	}
	*/
	
	
	/*
	@Test
	public void getConfig() {
		int aConfigId = 3;
		
		Config temp = null;
		
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";

		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		
		List<Config> configs = query.getResultList();
				  
		temp = configs.get(0);
					  
		System.out.println("ConfigID = "+temp.configID);
		System.out.println("Budget = "+temp.getBudget());
		
	}
	*/
	
	
	/*
	@Test
	public void deleteConfig() {
		int aConfigId = 2;
		
		em.getTransaction().begin();
		Query query = em.createNativeQuery("DELETE FROM Config WHERE configID = " + aConfigId);
		query.executeUpdate();
		
	}
	*/
	
	/*
	@Test
	public void addGPUToConfig() {
		int aConfigId = 1;
		GPU aGPU = new GPU("123456", "test", "NVidia", "NVidia",
				"2070", "sjfdlsf45sfdjlsfj65", 300);
		Config temp = null;
		
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";

		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		
		List<Config> configs = query.getResultList();
				  
		temp = configs.get(0);
		
		em.getTransaction().begin();
		
		temp.setSelectedGpu(aGPU);
		em.persist(temp);
		em.getTransaction().commit();
	}
	*/
	
	
	
	//löschen der Konfig... funktioniert noch nicht ganz... es löscht zwar den ausgewählten Datensatz, aber nicht den Datensatz in verbundener Tabelle... z.B. in Tabelle GPU bleibt der eintrag weiterhin enthalten
	
	@Test
	public void deleteConfig() {
		int aConfigId = 5;
		Config temp = null;
		
		String sql = "SELECT e FROM Config e WHERE e.configID = :id";
	
		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		
		List<Config> configs = query.getResultList();
		temp = configs.get(0);
		
		em.getTransaction().begin();
		em.remove(temp);
		em.getTransaction().commit();
	}
	
	
	
	/*
	@Test
	public void deleteGPU() {
		int aConfigId = 2;
		GPU temp = null;
		
		String sql = "SELECT e.selectedGpu FROM Config e WHERE e.configID = :id";
		
	
		Query query = em.createQuery(sql);
		query.setParameter("id", aConfigId);
		
		List<GPU> configs = query.getResultList();
		temp = configs.get(0);	
		
		em.persist(temp);
		
		
		em.getTransaction().begin();
		em.remove(temp);
		em.getTransaction().commit();
	}
	*/

}
