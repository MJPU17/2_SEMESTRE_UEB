package co.edu.unbosque.util.exceptions;

public class PasaporteException extends Exception{
	
	private int error;
	
	public PasaporteException(int error) {
		super();
		this.error=error;
	}
	
	@Override
	public String getMessage() {
		switch (error) {
		
		case 1: {
			return "El espacio de nombre contiene caracteres invalidos";
		}
		
		case 2: {
			return "La fecha seleccionada es invalida.";
		}
		
		case 3:{
			return "El pais ingresado no existe.";
		}
		case 4:{
			return "La archivo seleccionado es invalido, por favor ingresar una imagen.";
		}
		case 5:{
			return "Seleccione foto.";
		}
		case 6:{
			return "El espacio de nombre esta vacio. Porfavor ingrese nombre.";
		}	
		
		}
		return "Error al generar pasaporte";
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
	
}
