package co.edu.unbosque.model;

public class Vendedor extends Empleado{
	
	private double comision;
	private long ventas_mes;
	
	public Vendedor() {
		super();
		comision=0.0;
		ventas_mes=0;
	}
	
	public Vendedor(long cedula,String nombre,String cargo,long salario,double comision,long ventas_mes) {
		super(cedula, nombre, cargo, salario);
		this.comision=comision;
		this.ventas_mes=ventas_mes;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public long getVentas_mes() {
		return ventas_mes;
	}

	public void setVentas_mes(long ventas_mes) {
		this.ventas_mes = ventas_mes;
	}
	
}
