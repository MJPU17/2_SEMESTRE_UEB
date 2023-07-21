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
	
	public String leerlinea(String mensaje,int max_caracteres) {
		System.out.println(mensaje);
		while(true) {
			try {
				String line=sc.nextLine();
				 if(line.length()==0||!line.matches(".*[^ ].*"))throw new CadenaInvalidaException(1);
				else if(line.matches(".*[0-9].*"))throw new CadenaInvalidaException(2);
				else if(line.matches(".*[^A-Za-z ].*"))throw new CadenaInvalidaException(3);
				else if(line.length()>max_caracteres) throw new CadenaInvalidaException(4);
				return line;
			}catch (CadenaInvalidaException e) {
				if(e.getError()==4) {
					System.out.println(e.getMessage()+"El maximo de caracteres es "+max_caracteres+".");
				}
				else {
					System.out.println(e.getMessage());
				}
				System.out.println("Intentelo de nuevo:");
			} 
		}
		
	}
	
	public String leerCorreo(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				String aux=sc.nextLine();
				if(!aux.contains("@")||!aux.contains("."))throw new CadenaInvalidaException(6);
				else if(aux.indexOf("@")>aux.indexOf("."))throw new CadenaInvalidaException(6);
				else if(aux.substring(0,aux.indexOf("@")).length()>64||aux.substring(aux.indexOf("@"),aux.indexOf(".")).length()>64||aux.substring(aux.indexOf(".")).length()>64)throw new CadenaInvalidaException(6);
				else if(aux.replaceAll("[^\\@]", "").length()>1)throw new CadenaInvalidaException(6);
				return aux;
			}catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentetlo de nuevo:");
			}
			
		}
	}
	
	public boolean leerBoolean(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				String aux=sc.nextLine().toLowerCase();
				if(!aux.contains("si")&&!aux.contains("no"))throw new CadenaInvalidaException(5);
				return aux.contains("si");
			}catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentetlo de nuevo:");
			}
		}
	}
	
	public int leerOpcion(String mensaje) {
		System.out.println(mensaje);
		while (true) {
			try {
				int num=sc.nextInt();
				return num;
			}
			catch(InputMismatchException e) {
				System.out.println("El formato de entrada es invalido.");
				System.out.println("Intentelo denuevo:");
				sc.nextLine();
			}
		}
	}
			
	public int leerEntero(String mensaje,int max_caracteres) {
		System.out.println(mensaje);
		while (true) {
			try {
				int num=sc.nextInt();
				if(num<0)throw new NumeroInvalidoException();
				else if(Integer.toString(num).length()>max_caracteres)throw new CadenaInvalidaException(4);
				return num;
			}
			catch (NumeroInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo denuevo:");
			}
			catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage()+"El maximo de caracteres es "+max_caracteres+".");
				System.out.println("Intenetelo de nuevo:");
			}
			catch(InputMismatchException e) {
				System.out.println("El formato de entrada es invalido.");
				System.out.println("Intentelo denuevo:");
				sc.nextLine();
			}
		}
	}
	
	public long leerEnteroGrande(String mensaje,int max_caracteres) {
		System.out.println(mensaje);
		while (true) {
			try {
				long num=sc.nextLong();
				if(num<0)throw new NumeroInvalidoException();
				else if(Long.toString(num).length()>max_caracteres)throw new CadenaInvalidaException(4);
				return num;
			}
			catch (NumeroInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentelo denuevo:");
			}
			catch (CadenaInvalidaException e) {
				System.out.println(e.getMessage()+"El maximo de caracteres es "+max_caracteres+".");
				System.out.println("Intenetelo de nuevo:");
			}
			catch(InputMismatchException e) {
				System.out.println("El formato de entrada es invalido.");
				System.out.println("Intentelo denuevo:");
				sc.nextLine();
			}
		}
	}
	
	public void imprimirConSalto(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void imprimirSinSalto(String mensaje) {
		System.out.print(mensaje);
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
	
}
