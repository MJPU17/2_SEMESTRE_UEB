package co.edu.unbosque.model;

public class EmpleadoDTO {
	
	private long cedula;
	private String nombre;
	private String cargo;
	private long salario;
	
	public EmpleadoDTO() {
		cedula=0;
		nombre="";
		cargo="";
		salario=0;
	}

	public EmpleadoDTO(long cedula, String nombre, String cargo, long salario) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Cedula: ").append(cedula).append("\n");
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Cargo: ").append(cargo).append("\n");
		sb.append("Salario: ").append(salario).append("\n");
		return sb.toString();
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
