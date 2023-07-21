package co.edu.unbosque.model;

public class Empleado {
	
	private long cedula;
	private String nombre;
	private String cargo;
	private long salario;
	
	public Empleado() {
		cedula=0;
		nombre="";
		cargo="";
		salario=0;
	}
	
	public Empleado(long cedula,String nombre,String cargo,long salario) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.cargo=cargo;
		this.salario=salario;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}
	
	

}
