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
		
		case 1: {
			message="La cadena ingresada esta vacia o solo contiene espacios.";
			break;
		}
		
		case 2:{
			message="No se aceptan caracteres numericos.";
		}
		
		case 3:{
			message="La cadena ingresada tiene caracteres invalidos.";
			break;
		}
		
		case 4:{
			message="La cadena ingresada excede los caracteres maximos.";
			break;
		}
		
		case 5:{
			message="Respuesta invalida por favor ingrese si o no.";
			break;
		}
		
		case 6:{
			message="El correo introducido es invalido.";
			break;
		}
		
		default:
			message="La cadena ingresada es invalida.";
			break;
		}
		return message;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

}
