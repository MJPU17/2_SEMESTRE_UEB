package co.edu.unbosque.model;

public class Triangulo extends Figura2D{

	private double base;
	private double altura;
	
	public Triangulo(double lado, double altura) {
		super();
		this.base = lado;
		this.altura = altura;
	}
	
	@Override
	public void calcularArea() {
		area = (base * altura)/2;
	}

	@Override
	public void calcularPerimetro() {
		perimetro = (3*base);
	}

	@Override
	public String asignarNombre() {
		return "Triangulo";
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}