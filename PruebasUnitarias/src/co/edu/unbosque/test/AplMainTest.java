package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.ecu.unbosque.controller.AplMain;

public class AplMainTest {
	
	private static int contador=0;
	
	@BeforeAll
	public static void saludoInicio() {
		System.out.println("Iniciar todas las pruebas unitarias.");
	}
	
	@BeforeEach
	public void saluudoAntesDe() {
		System.out.println("Iniciando la prueba numero "+contador);
	}
	
	@AfterEach
	public void saludoDespuesDe() {
		System.out.println("Finalizando la prueba numero "+(contador-1));
	}
	
	@AfterAll
	public static void despedidaFinal() {
		System.out.println("Se ha ejecutado "+contador+" test.");
	}
	
	@Test
	public void testeoSuma() {
		contador++;
		AplMain a=new AplMain();
		int res=a.suma(5, 4);
		assertEquals(9, res);
	}
	
	@Test
	public void testeoSuma2() {
		contador++;
		AplMain a=new AplMain();
		int res=a.suma(8, 30);
		assertEquals(38, res);
	}
	
	@Test
	public void testeoSuma3() {
		contador++;
		AplMain a=new AplMain();
		int res=a.suma(2,3);
		assertEquals("La prueba "+(contador-1)+" fallo.",5,res);
	}
	
}
