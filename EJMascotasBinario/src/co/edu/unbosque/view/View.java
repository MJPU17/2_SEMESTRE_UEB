package co.edu.unbosque.view;

import java.util.Scanner;

public class View {
	
	private Scanner leer;
	
	public View() {
		leer = new Scanner(System.in);
	}
	
	public String leerDato(String mensaje) {
		String dato = "";
		System.out.println(mensaje);
		dato = leer.nextLine();
		return dato;
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}
}
