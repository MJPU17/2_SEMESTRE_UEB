package co.edu.unbosque.util.exception;

public class NumeroNegativoException extends Exception{
	
	public NumeroNegativoException() {
		super("No se permiten valores negativos");
	}
}
