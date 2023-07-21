package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				int num=sc.nextInt();
				return num;
				
			} catch (InputMismatchException e) {
				System.out.println("Formato de entrada no valido.");
				System.out.println("Intentelo de nuevo.");
				sc.nextLine();
			}
		}
	}
	
	public void mostrarInformacion(String informacion) {
		System.out.println(informacion);
	}
}
