package co.edu.unbosque.util.exception;

public class CadenaInvalidaException extends Exception{
	
	public CadenaInvalidaException() {
		super("El dato ingresado esta vacio o solo contiene espacios");
	}
}
