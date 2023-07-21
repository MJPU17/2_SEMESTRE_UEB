package co.edu.unbosque.model;

public class EstudianteDTO {
	
	private long id;
	private String name;
	private long telefono;
	
	public EstudianteDTO() {
		id=0;
		name="";
		telefono=0;
	}

	public EstudianteDTO(long id, String name, long telefono) {
		this.id = id;
		this.name = name;
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Id: ").append(id).append("\n");
		sb.append("Nombre: ").append(name).append("\n");
		sb.append("Telefono: ").append(telefono);
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
}
