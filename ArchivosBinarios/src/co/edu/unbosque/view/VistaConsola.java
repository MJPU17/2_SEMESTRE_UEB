package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.exception.CadenaInvalidaException;
import co.edu.unbosque.util.exception.NumeroInvalidoException;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public String leerNombrePersonaje(String mensaje) {
		System.out.println(mensaje);
		while (true) {
			try {
				String nombre=sc.nextLine();
				if(!nombre.matches(".*[^ ].*")) throw new CadenaInvalidaException(1);
				else if(nombre.matches(".*[0-9].*")) throw new CadenaInvalidaException(2);
				else if(nombre.matches(".*[^A-Za-z ].*")) throw new CadenaInvalidaException(3);
				return nombre;
			}
			catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo: ");
			}
		}
	}
	
	public String leerDescripcion(String mensaje) {
		System.out.println(mensaje);
		while (true) {
			try {
				String descripcion=sc.nextLine();
				if(!descripcion.matches(".*[^ ].*")) throw new CadenaInvalidaException(1);
				else if(descripcion.matches(".*[^A-Za-z0-9 ].*")) throw new CadenaInvalidaException(3);
				return descripcion;
			}
			catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo: ");
			}
		}
	}
	
	public String leerNombreSerie(String mensaje) {
		System.out.println(mensaje);
		while (true) {
			try {
				String nombre=sc.nextLine();
				if(!nombre.matches(".*[^ ].*")) throw new CadenaInvalidaException(1);
				return nombre;
			}
			catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo: ");
			}
		}
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				int num=sc.nextInt();
				if(num<0) throw new NumeroInvalidoException();
				return num;
			}
			catch (NumeroInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo: ");
			}
			catch (InputMismatchException e) {
				System.out.println("Formato de entrada no valido.");
				System.out.println("Intentelo de nuevo: ");
			}
		}
	}
	
	public int leerOpcion (String mensaje) {
		System.out.println(mensaje);
		return sc.nextInt();
	}
	
	public void mostrarInformacion(String informacion) {
		System.out.println(informacion);
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}

}
