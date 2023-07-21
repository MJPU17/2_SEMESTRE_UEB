package co.edu.unbosque.util.exception;

public class CaracterEspecialException extends Exception{
	
	public CaracterEspecialException() {
		super("El dato ingresado contiene caracteres especiales invalidos.");
	}

}
