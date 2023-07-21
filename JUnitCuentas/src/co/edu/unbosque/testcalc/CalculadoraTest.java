package co.edu.unbosque.testcalc;
import co.edu.unbosque.model.*;

import junit.framework.TestCase;

public class CalculadoraTest extends TestCase {
	
	public void setUp() {//Configurar
		System.out.println("Se inicializan variables");
	}
	public void testSuma() {
		Calculadora calc = new Calculadora(); 
		assertEquals("Las sumas no coinciden", 7, calc.suma(5, 2));
	}
	
	public void testsumar_arreglos() {
		int [] esperado = new int [] {9,4,7,2,3};
		Calculadora calc = new Calculadora(); 
		
		assertEquals("No tienen igual longitud",esperado.length, calc.sumar_arreglos(new int [] {2,3,6,1,2},new int [] {1,1,1,1,1}).length);

		   for (int i = 0; i < esperado.length; i++) {
		      assertEquals("elemento diferente pos ="+i, esperado[i], calc.sumar_arreglos(new int [] {2,3,6,1,2},new int [] {1,1,1,1,1})[i]);
		   }		
	}
	public void tearDown() {//Resetear
	}
}
