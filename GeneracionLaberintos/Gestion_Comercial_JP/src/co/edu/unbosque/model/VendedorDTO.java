package co.edu.unbosque.model;

public class VendedorDTO extends EmpleadoDTO{
	
	private double comision;
	private long ventas_mes;
	
	public VendedorDTO() {
		super();
		comision=0.0;
		ventas_mes=0;
	}

	public VendedorDTO(long cedula, String nombre, String cargo, long salario,double comision, long ventas_mes) {
		super(cedula, nombre, cargo, salario);
		this.comision = comision;
		this.ventas_mes = ventas_mes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Comision: ").append(comision).append("\n");
		sb.append("Ventas al mes: ").append(ventas_mes).append("\n");
		return sb.toString();
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
