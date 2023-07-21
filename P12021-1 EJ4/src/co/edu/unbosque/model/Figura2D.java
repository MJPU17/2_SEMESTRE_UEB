package co.edu.unbosque.model;

public abstract class Figura2D implements FiguraGeometrica{
	
	protected double area;
	protected double perimetro;
	
	public Figura2D( ) {
		this.area = 0.0;
		this.perimetro = 0.0;
	}
	
	public abstract void calcularArea();
	public abstract void calcularPerimetro();
	public abstract String asignarNombre();
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getPerimetro() {
		return perimetro;
	}
	
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

}
