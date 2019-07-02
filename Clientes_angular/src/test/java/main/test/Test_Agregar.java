package main.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import main.model.Clientes;
import main.model.repository.RPClass_Clientes;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Test_Agregar {

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	RPClass_Clientes rp_clientes;
	
	@Before
	public void setUp() throws Exception {
		Clientes cliente = new Clientes("1111111-1", "Juan 1", "Gonzales 1", "example@example.cl", "11111111");
		this.entityManager.persist(cliente);
	}	

	@Test
	public void cuandoInserta1Entonces2Equipos() {
		this.rp_clientes.save(new Clientes("1111111-2", "Juan 2", "Gonzales 6", "example@example.cl", "11111116"));
		int largo = this.rp_clientes.findAll().size();
		assertTrue("SON " + largo + " PERO DEBERÍAN SER 2", largo == 2);
	}
	
	
	
	
	
	
	
	
	
	
}
