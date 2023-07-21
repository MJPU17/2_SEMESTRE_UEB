package co.edu.unbosque.model;

public class Calculadora {
		
		private static int ans;
	
	public Calculadora() {
		ans = 0;
	}
	
	public int suma(int a, int b) {
		ans = a+b;
		return ans;
	}
	
	public int resta(int a, int b) {
		ans = a-b;
		return ans;
	}
	

	public double multiplicacion(int a, int b) {
		return a+b;
	}
	
	
	public int [] sumar_arreglos(int [] a1, int [] a2) {
		int [] suma = new int [5];
		for(int i=0; i<a1.length;i++)
			suma[i]= a1[i]+a2[i];
		return suma;
	}
	
	public void ac() {
		ans = 0;
	}
}