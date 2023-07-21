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
	
	public String leerLinea(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		return sc.nextInt();
	}
	
	public long leerEnteroGrande(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLong();
	}
	
	public char leerCaracter(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine().charAt(0);
	}
	
	public double leerDecimal(String mensaje) {
		System.out.println(mensaje);
		return sc.nextDouble();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
}
