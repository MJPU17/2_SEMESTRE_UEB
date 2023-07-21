package co.edu.unbosque.view;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.CadenaInvalidaException;
import co.edu.unbosque.util.NumeroInvalidoException;

public class VistaConsola {
	
	private Scanner sc;
	private PrintStream ps;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
		ps=new PrintStream(System.out, true, StandardCharsets.UTF_8);
	}
	
	public int leerEntero(String mensaje,boolean opcion) {
		ps.println(mensaje);
		while(true) {
			try {
				int aux=sc.nextInt();
				if(!opcion && aux>400) throw new NumeroInvalidoException(1);
				else if(!opcion && aux<0) throw new NumeroInvalidoException(2);
				return aux;
			} catch (NumeroInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo:");
			}
			catch(InputMismatchException e) {
				System.out.println("El formato de entrada es invalido.");
				System.out.println("Intentelo de nuevo:");
				sc.nextLine();
			}
		}
	}
	
	public String leerLinea(String mensaje,boolean unic) {
		ps.println(mensaje);
		while (true) {
			try {
				String aux=sc.nextLine();
				if(unic && !aux.toLowerCase().contains("si") && !aux.toLowerCase().contains("no")) throw new CadenaInvalidaException(3);
				else if(aux.length()==0||!aux.matches(".*[^ ].*")) throw new CadenaInvalidaException(1);
				else if(aux.matches(".*[0-9].*"))throw new CadenaInvalidaException(4);
				else if(aux.matches(".*[^A-Za-z ].*")) throw new CadenaInvalidaException(2);
				return aux;
			}catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo de nuevo:");
			}
		}
	}
	
	public void imprimirConSalto(String message) {
		ps.println(message);
	}
	
	public void imprimirSinSalto(String message) {
		ps.print(message);
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
	
	
}
