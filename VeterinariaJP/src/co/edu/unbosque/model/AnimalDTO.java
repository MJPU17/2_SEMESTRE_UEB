package co.edu.unbosque.model;

public abstract class AnimalDTO {
	
	private String nombre;
	private String habitat;
	private int niv_peligro;
	private String reproduccion;
	private boolean pelaje;
	
	public AnimalDTO() {
		nombre="";
		habitat="";
		niv_peligro=0;
		reproduccion="";
		pelaje=false;
	}
	
	public AnimalDTO(String nombre,String habitat,int niv_peligro,String reproduccion,boolean pelaje){
		this.nombre=nombre;
		this.habitat=habitat;
		this.niv_peligro=niv_peligro;
		this.reproduccion=reproduccion;
		this.pelaje=pelaje;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre);
		sb.append("\nHabitat: ").append(habitat);
		sb.append("\nNivel peligro: ").append(niv_peligro);
		sb.append("\nReproduccion: ").append(reproduccion);
		sb.append("\nTiene pelaje: ").append(pelaje ? "Si":"No");
		return sb.toString();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public int getNiv_peligro() {
		return niv_peligro;
	}

	public void setNiv_peligro(int niv_peligro) {
		this.niv_peligro = niv_peligro;
	}

	public String getReproduccion() {
		return reproduccion;
	}

	public void setReproduccion(String reproduccion) {
		this.reproduccion = reproduccion;
	}

	public boolean isPelaje() {
		return pelaje;
	}

	public void setPelaje(boolean pelaje) {
		this.pelaje = pelaje;
	}

}
