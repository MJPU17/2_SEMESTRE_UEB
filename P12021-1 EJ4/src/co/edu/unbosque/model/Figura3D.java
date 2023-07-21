package co.edu.unbosque.model;

public abstract class Figura3D implements FiguraGeometrica{

	protected double volumen;
	
	public Figura3D() {
		volumen = 0.0;
	}
	
	public abstract String asignarNombre();
	public abstract void calcularVolumen();

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

}
