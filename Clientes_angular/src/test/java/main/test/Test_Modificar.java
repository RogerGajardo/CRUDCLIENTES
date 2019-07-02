package main.test;

import static org.junit.Assert.assertNotNull;
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
public class Test_Modificar {

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	RPClass_Clientes rp_clientes;
	
	@Before
	public void setUp() throws Exception {
		Clientes cliente = new Clientes("1111111-1", "Juan 1", "Gonzales 1", "example@example.cl", "11111111");
		this.entityManager.persist(cliente);
		cliente = new Clientes("1111111-2", "Juan 2", "Gonzales 2", "example@example.cl", "11111112");
		this.entityManager.persist(cliente);
		cliente = new Clientes("1111111-3", "Juan 3", "Gonzales 3", "example@example.cl", "11111113");
		this.entityManager.persist(cliente);
		cliente = new Clientes("1111111-4", "Juan 4", "Gonzales 4", "example@example.cl", "11111114");
		this.entityManager.persist(cliente);
		cliente = new Clientes("1111111-5", "Juan 5", "Gonzales 5", "example@example.cl", "11111115");
		this.entityManager.persist(cliente);
	}	

	@Test
	public void cuandoModificaNombresEntoncesSeObtieneModificado() {
		this.rp_clientes.save(new Clientes("1111111-1", "Juan 1", "Gonzales 1", "example@example.cl", "11111111"));
		Clientes juan1 = this.rp_clientes.findById("1111111-1").get();
		assertNotNull(juan1);
		assertTrue("ES " + juan1.getNombres() + " PERO DEBERÍA SER Juan 1", juan1.getNombres().equals("Juan 1"));
	}
	
}
