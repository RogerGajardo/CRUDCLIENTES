package main.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Agregar.class, Test_Eliminar.class, Test_Modificar.class,Test_Listar.class,Test_Obtener1.class })

public class AllTests {

}
