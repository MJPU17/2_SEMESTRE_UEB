package co.edu.unbosque.model;

public abstract class Persona {
	
	private String nombres;
	private String apellidos;
	private long num_ide;
	private String est_civil;
	
	public Persona() {
		nombres="";
		apellidos="";
		num_ide=0;
		est_civil="";
	}
	
	public Persona(String nombres ,String apellidos ,long num_ide, String est_civil) {
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.num_ide=num_ide;
		this.est_civil=est_civil;
	}
	
	@Override
	public abstract String toString();

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getNum_ide() {
		return num_ide;
	}

	public void setNum_ide(long num_ide) {
		this.num_ide = num_ide;
	}

	public String getEst_civil() {
		return est_civil;
	}

	public void setEst_civil(String est_civil) {
		this.est_civil = est_civil;
	}

}
