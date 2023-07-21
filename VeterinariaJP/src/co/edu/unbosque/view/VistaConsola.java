package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		return sc.nextInt();
	}
	
	public String leerLinea(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
}
