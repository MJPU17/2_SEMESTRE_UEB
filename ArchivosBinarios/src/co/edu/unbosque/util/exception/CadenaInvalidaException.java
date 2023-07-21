package co.edu.unbosque.util.exception;

public class CadenaInvalidaException extends Exception{
	
	private int error;
	
	public CadenaInvalidaException(int error) {
		super();
		this.error=error;
	}
	
	@Override
	public String getMessage() {
		
		String message="";
		
		switch (error) {
		case 1:{
			message="La cadena ingresada solo contiene espacias o esta vacia.";
			break;
		}
		case 2: {
			message="La cadena ingresada contiene valores numericos.";
			break;
		}
		case 3:{
			message="La cadena ingresada tiene caracteres especiales invalidos.";
			break;
		}
		default:
			message="La cadena ingresada es invalida.";
			break;
		}
		
		return message;
	}

}
