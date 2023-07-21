package co.edu.unbosque.model;

public abstract class Empleado {
	
	protected long id;
	protected String nombre;
	protected long celular;
	protected int edad;
	protected long sueldo;
	
	public Empleado() {
		id=0;
		nombre="";
		celular=0;
		edad=0;
		sueldo=0;
	}
	
	public Empleado(long id,String nombre,long celular,int edad) {
		this.edad=edad;
		this.nombre=nombre;
		this.celular=celular;
		this.edad=edad;
		this.sueldo=0;
	}
	
	public abstract long calcularSueldo(int diastrab);
	
	@Override
	public String toString() {
		return super.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getSueldo() {
		return sueldo;
	}

	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
