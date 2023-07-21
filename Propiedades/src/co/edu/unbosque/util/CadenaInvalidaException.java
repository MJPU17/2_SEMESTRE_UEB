package co.edu.unbosque.util;

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
			message="La cadena ingresada solo contiene espacios o esta vacia";
			break;
		}
		
		case 2:{
			message="La cadena ingresada tiene caracteres invalidos.";
			break;
		}
		
		case 3:{
			message="La respuesta ingresada es invalida porfavor ingrese si o no.";
			break;
		}
		
		case 4:{
			message="Los caracteres numericos no son validos.";
			break;
		}
		
		default:{
			message="La cadena ingresada es invalida.";
			break;
		}
		
		}
		
		return message;
	}

}
