package co.edu.unbosque.util.exception;

public class NumeroInvalidoException extends Exception{
	
	public NumeroInvalidoException() {
		super("No se aceptan numeros negativos.");
	}

}
