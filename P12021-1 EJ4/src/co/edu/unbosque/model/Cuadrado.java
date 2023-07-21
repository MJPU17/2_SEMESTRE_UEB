package co.edu.unbosque.model;

public class Cuadrado extends Figura2D {

	private double lado;
	
	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}
	
	@Override
	public void calcularArea() {
		area = (lado * lado);
	}

	@Override
	public void calcularPerimetro() {
		perimetro = (4*lado);
	}

	@Override
	public String asignarNombre() {
		return "Cuadrado";
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
}
