package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		return sc.nextInt();
	}
	
	public long leerEnteroGrande(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLong();
	}
	
	public String leerLinea(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public void motrarInformacion(String informacion) {
		System.out.println(informacion);
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}

}
