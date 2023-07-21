package co.edu.unbosque.view;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.exception.CadenaInvalidaException;
import co.edu.unbosque.util.exception.CaracterEspecialException;
import co.edu.unbosque.util.exception.CaracterNumericoException;
import co.edu.unbosque.util.exception.LimiteExcedidoException;
import co.edu.unbosque.util.exception.NumeroNegativoException;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc=new Scanner(System.in);
	}
	
	public void mostrarInformacion(String informacion) {
		System.out.println(informacion);
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				BigInteger aux=sc.nextBigInteger();
				if(aux.compareTo(new BigInteger("2147483647"))==1) throw new LimiteExcedidoException();
				
				else if(aux.compareTo(BigInteger.ZERO)==-1) throw new NumeroNegativoException();
				
				return Integer.parseInt(aux.toString());
			}
			catch (LimiteExcedidoException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch(NumeroNegativoException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch (InputMismatchException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: El dato ingresado no es numerico");
				System.out.println("Ingrese el dato nuevamente:");
				sc.nextLine();
			}
		}
	}
	
	public long leerEnteroGrande(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				BigInteger aux=sc.nextBigInteger();
				if(aux.compareTo(new BigInteger("9223372036854775807"))==1) throw new LimiteExcedidoException();
			
				else if(aux.compareTo(BigInteger.ZERO)==-1) throw new NumeroNegativoException();
				
				return Long.parseLong(aux.toString());
			}
			catch (LimiteExcedidoException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch(NumeroNegativoException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch (InputMismatchException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: El dato ingresado no es numerico");
				System.out.println("Ingrese el dato nuevamente:");
				sc.nextLine();
			}
		}
	}
	
	public String leerLinea(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				
				String aux=sc.nextLine();
				if(aux.length()==0||!aux.matches(".*[^ ].*")) throw new CadenaInvalidaException();
				
				else if(aux.matches("[0-9]")) throw new CaracterNumericoException();
				
				else if(aux.matches(".*[^a-zA-z ].*"))throw new CaracterEspecialException();
				
				return aux;
				
			}
			catch (CaracterEspecialException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch (CaracterNumericoException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
			catch (CadenaInvalidaException e) {
				System.out.println("Ha ocurrido un error");
				System.out.println("Motivo: "+e.getMessage());
				System.out.println("Ingrese el dato nuevamente:");
			}
		}
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
}
