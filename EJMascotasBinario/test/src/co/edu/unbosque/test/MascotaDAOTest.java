package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.MascotaDAO;
import junit.framework.TestCase;

public class MascotaDAOTest extends TestCase{

	private Archivo archivo;
	private ArrayList<Mascota> mascotas;
	private MascotaDAO mascotadao;
	private File file = new File("dataTest/informacionTest.dat");
	private Mascota m1;
	private Mascota m2;
	private Mascota m3;
	private Mascota m4;
	
	private void setupEscenario() {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo = new Archivo(file);	
		mascotas = archivo.leerArchivo(file);
		mascotadao = new MascotaDAO(archivo);


		m1 = new Mascota("Max", "Perro");
		m2 = new Mascota("Luna","Perro");
		m3 = new Mascota("Wanda", "Gato");
		m4 = new Mascota("Luna", "Culebra");
		
		mascotas.add(m1);
		mascotas.add(m2);
	}
	
	public void testMascotaDAO() {
		setupEscenario();

		assertEquals("La cantidad de mascotas debe ser 2",2,mascotas.size());
	}


	public void testAgregarMascota() {
		setupEscenario();

		assertTrue("Se debió agregar el mascota", mascotadao.agregarMascota(m3.getNombre(), m3.getTipo(), mascotas, file));
		assertFalse("No se debería agregar una mascota con nombre igual", mascotadao.agregarMascota(m4.getNombre(), m4.getTipo(), mascotas, file));
	}
	
	public void testBuscarMascota() {

		setupEscenario();

		assertNotNull("Debió encontrarse a la mascota", mascotadao.buscarMascota("Max", mascotas));
		assertNull("No debió encontrar una mascota", mascotadao.buscarMascota("Mateo", mascotas));
	}


	public void testEliminarEmpleado() {
		setupEscenario();
		
		assertTrue("Debió eliminarse la mascota", mascotadao.eliminarMascota("Luna", mascotas, file));
		assertFalse("No se eliminó la mascota, dado que NO existe en el sistema", mascotadao.eliminarMascota("Mateo", mascotas, file));
		
	}
	
}
