package co.edu.unbosque.util.exception;

public class LimiteExcedidoException extends Exception{
	
	public LimiteExcedidoException() {
		super("El numero ingresado es demasiado grande.");
	}
}
