package co.edu.unbosque.util;

public class NumeroInvalidoException extends Exception{
	
	private int error;
	
	public NumeroInvalidoException(int error) {
		super();
		this.error=error;
	}
	
	@Override
	public String getMessage() {
		String message="";
		switch (error) {
		case 1: {
			message="El tiempo de vida maximo de un animal es de 400 años.";
			break;
		}
		
		case 2:{
			message="No se permiten valores negativos.";
			break;
		}
		
		default:{
			message="El numero ingresado es invalido.";
		}
		
		}
		return message;
	}

}
