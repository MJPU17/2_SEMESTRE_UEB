package co.edu.unbosque.model;

import java.io.Serializable;

public class VideoJuegoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6668500302088448811L;
	private String nombre;
	private String consola;
	private String rating;
	private boolean es_multijugador;

	public VideoJuegoDTO() {
		// TODO Auto-generated constructor stub
	}

	public VideoJuegoDTO(String nombre, String consola, String rating, boolean es_multijugador) {
		super();
		this.nombre = nombre;
		this.consola = consola;
		this.rating = rating;
		this.es_multijugador = es_multijugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isEs_multijugador() {
		return es_multijugador;
	}

	public void setEs_multijugador(boolean es_multijugador) {
		this.es_multijugador = es_multijugador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: " + getNombre() + "\n");
		sb.append("Consola: " + getConsola() + "\n");
		sb.append("Rating: " + getRating() + "\n");
		sb.append("Es multijugador?: " + (isEs_multijugador()?"Si":"No") + "\n" + "\n");

		return sb.toString();
	}

}
