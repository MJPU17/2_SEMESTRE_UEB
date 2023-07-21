package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public long leerEnteroLargo(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLong();
	}
	
	public double leerDecimal(String mensaje) {
		System.out.println(mensaje);
		return sc.nextDouble();
	}
	
	public String leeerCadena(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}

}
