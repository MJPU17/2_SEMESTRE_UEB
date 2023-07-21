package co.edu.unbosque.model;

public abstract class AnimalDTO {
	
	private String nombre;
	private String sub_especie;
	private String habitat;
	private int tiem_vida;
	private boolean esherbivoro;
	
	public AnimalDTO() {
		nombre="";
		sub_especie="";
		habitat="";
		tiem_vida=0;
		esherbivoro=false;
	}

	public AnimalDTO(String nombre,String sub_especie, String habitat, int tiem_vida, boolean eshebivoro) {
		this.nombre=nombre;
		this.sub_especie = sub_especie;
		this.habitat = habitat;
		this.tiem_vida = tiem_vida;
		this.esherbivoro=eshebivoro;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Subespecie: ").append(sub_especie).append("\n");
		sb.append("Habitat: ").append(habitat).append("\n");
		sb.append("Anios vida: ").append(tiem_vida).append("\n");
		sb.append("Es herbivoro: ").append(esherbivoro?"Si":"No").append("\n");
		return sb.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSub_especie() {
		return sub_especie;
	}

	public void setSub_especie(String sub_especie) {
		this.sub_especie = sub_especie;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public int getTiem_vida() {
		return tiem_vida;
	}

	public void setTiem_vida(int tiem_vida) {
		this.tiem_vida = tiem_vida;
	}

	public boolean isEsherbivoro() {
		return esherbivoro;
	}

	public void setEsherbivoro(boolean esherbivoro) {
		this.esherbivoro = esherbivoro;
	}
	
}
