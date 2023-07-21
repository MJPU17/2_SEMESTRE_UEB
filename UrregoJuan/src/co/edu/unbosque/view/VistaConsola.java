package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public long leerEnteroGrande(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLong();
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		return sc.nextInt();
	}
	
	public String leerLinea(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public void mostrarInformacion(String informacion) {
		System.out.println(informacion);
	}
	
	public void saltoLinea() {
		sc.nextLine();
	}
}
