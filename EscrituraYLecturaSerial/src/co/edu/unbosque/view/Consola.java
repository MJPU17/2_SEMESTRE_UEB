package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.exceptions.NumberTooLongException;
import co.edu.unbosque.util.exceptions.NumeroInvalidoException;

public class Consola {
	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public int leerEntero() {

		while (true) {

			try {

				int temporal = sc.nextInt();
				
				if (Integer.toString(temporal).length() > 5) {
					
					
					throw new NumberTooLongException();
				}
				
				return temporal;

			} catch (NumberFormatException e) {

				System.out.println("Motivo: " + e.getMessage() + " imbecil");
				System.out.println("Vuelva a escribirlo :)");
				sc.nextLine();
				continue;

			} catch (InputMismatchException e2) {

				try {

					throw new NumeroInvalidoException();

					} catch (NumeroInvalidoException e) {
						System.out.println("Ha insertado un dato que no es numerico :)");
						System.out.println("Motivo: " + e.getMessage() + " imbecil");
						System.out.println("Vuelva a escribirlo :)");
						sc.nextLine();
						continue;				}
			}catch (NumberTooLongException e3) {

				System.out.println("Ha insertado un dato mas largo de 5 :)");
				System.out.println("Motivo: " + e3.getMessage() + " imbecil");
				System.out.println("Vuelva a escribirlo :)");
				sc.nextLine();
				continue;	
			
			
			}

		}
	}

	public long leerLong() {
		long temporal = sc.nextLong();
		return temporal;
	}

	public float leerFlotante() {
		float temporal = sc.nextFloat();
		return temporal;
	}

	public double leerDouble() {
		double temporal = sc.nextDouble();
		return temporal;
	}

	public String leerLineaEntera() {
		String temp = sc.nextLine();
		return temp;
	}

	public String leerCadena() {
		String temp = sc.next();
		return temp;
	}

	public void quemarLinea() {
		sc.nextLine();
	}

	public char leerCaracter() {
		char temp = leerCadena().charAt(0);
		return temp;
	}

	public boolean leerBooleano() {
		boolean temp = Boolean.valueOf(leerCadena());
		return temp;
	}

	public void imprimirSinSalto(String text) {
		System.out.print(text);
	}

	public void imprimirConSalto(String text) {
		System.out.println(text);
	}

	public void imprimirSalto() {
		System.out.println();
	}
	
	public void leerCorreo() {
		
		
	}
}
