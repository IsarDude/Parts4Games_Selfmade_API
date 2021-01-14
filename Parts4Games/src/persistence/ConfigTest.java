package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import data.Config;
import data.GPU;

public class ConfigTest {

	private EntityManager em;
	
	@Before
	public void setUp() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parts4Games_Parts4Games");
		em = emf.createEntityManager();
	}

	@Test
	public void saveConfig() {
		
		em.getTransaction().begin();
		//Instanz von Config erstellen und mit Budget und einer GPU füllen
		Config conf = new Config();
		conf.setBudget(1000);
		GPU gpu = new GPU("new", "test", "test", "NVidia", "RTX 2070", "2000er", 250);
		conf.setSelectedGpu(gpu);
		
		em.persist(conf);
		em.getTransaction().commit();
		
	}

}
