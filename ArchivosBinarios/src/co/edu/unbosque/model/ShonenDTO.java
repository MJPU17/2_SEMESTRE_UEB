package co.edu.unbosque.model;

import java.io.Serializable;

public class ShonenDTO extends AnimeDTO {

	private String protagonista;
	private String des_peleas;
	
	public ShonenDTO() {
		super();
		protagonista="";
		des_peleas="";
	}

	public ShonenDTO(String nombre, String descripcion, int temporadas,String protagonista, String des_peleas) {
		super(nombre, descripcion, temporadas);
		this.protagonista = protagonista;
		this.des_peleas = des_peleas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Protagonista :").append(protagonista).append("\n");
		sb.append("Descripcion de peleas: ").append(des_peleas).append("\n");
		return sb.toString();
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getDes_peleas() {
		return des_peleas;
	}

	public void setDes_peleas(String des_peleas) {
		this.des_peleas = des_peleas;
	}


}
