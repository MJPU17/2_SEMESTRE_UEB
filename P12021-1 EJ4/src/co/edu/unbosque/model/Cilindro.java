package co.edu.unbosque.model;

public class Cilindro extends Figura3D{

	private double radio;
	private double altura;
	
	public Cilindro(double radio, double altura) {
		super();
		this.radio = radio;
		this.altura = altura;
	}
	
	@Override
	public String asignarNombre() {
		return "Cilindro";
	}

	@Override
	public void calcularVolumen() {
		volumen = Math.PI* radio*radio* altura;		
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
