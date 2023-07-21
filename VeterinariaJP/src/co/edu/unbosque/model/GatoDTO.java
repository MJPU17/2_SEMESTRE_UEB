package co.edu.unbosque.model;

public class GatoDTO extends AnimalDTO{
	
	private String raza; 
	private int hor_suenio;
	
	public GatoDTO() {
		super();
		raza="";
		hor_suenio=0;
	}
	
	public GatoDTO(String nombre,String habitat,int niv_peligro,String reproduccion,boolean pelaje,String raza,int hor_suenio) {
		super(nombre, habitat, niv_peligro, reproduccion, pelaje);
		this.raza=raza;
		this.hor_suenio=hor_suenio;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("\nRaza :").append(raza);
		sb.append("\nHoras suenio :").append(hor_suenio);
		return sb.toString();
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getHor_suenio() {
		return hor_suenio;
	}

	public void setHor_suenio(int hor_suenio) {
		this.hor_suenio = hor_suenio;
	}

}
