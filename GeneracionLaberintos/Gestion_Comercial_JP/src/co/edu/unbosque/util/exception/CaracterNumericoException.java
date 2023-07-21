package co.edu.unbosque.util.exception;

public class CaracterNumericoException extends Exception{
	
	public CaracterNumericoException() {
		super("El dato contiene datos numericos que no son validos");
	}
}
