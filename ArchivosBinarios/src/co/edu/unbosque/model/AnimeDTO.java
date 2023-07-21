package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class AnimeDTO implements Serializable{
	
	private static final long serialVersionUID = 6679914459904568588L;
	private String nombre;
	private String descripcion;
	private int temporadas;
	
	public AnimeDTO() {
		nombre="";
		descripcion="";
		temporadas=0;
	}

	public AnimeDTO(String nombre, String descripcion, int temporadas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.temporadas = temporadas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Descripcion: ").append(descripcion).append("\n");
		sb.append("Numero temporadas: ").append(temporadas).append("\n");
		return sb.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

}
