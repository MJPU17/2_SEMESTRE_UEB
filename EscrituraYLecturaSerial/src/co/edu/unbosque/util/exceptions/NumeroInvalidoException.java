package co.edu.unbosque.util.exceptions;

import java.util.InputMismatchException;

public class NumeroInvalidoException extends InputMismatchException {

	public NumeroInvalidoException() {

		super("El numero ingresado no es valido");
		

	}

}
