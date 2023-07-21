package co.edu.unbosque.model;

public class Operaciones {
	
	public static double suma(double n,double x) {
		return n+x;
	}
	
	public static double resta(double n,double x) {
		return n-x;
	}
	
	public static double multiplicacion(double n,double x) {
		return n*x;
	}
	
	public static double division(double n,double x) throws ArithmeticException{
		if(x==0) {
			throw new ArithmeticException();
		}
		return n/x;
	}
	
	public static double porcentaje(double n,double x) {
		return x*n/100;
	}
	
	public static double notacionE(double n,double x) {
		return n*Math.pow(10, x);
	}
	
	public static double opuesto(double n) {
		return n*-1;
	}

}
