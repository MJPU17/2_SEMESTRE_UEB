package co.edu.unbosque.model;

public class PerroDTO extends AnimalDTO{
	
	private String raza;
	private String comida_preferida;
	
	public PerroDTO() {
		super();
		raza="";
		comida_preferida="";
	}
	
	public PerroDTO(String nombre,String habitat,int niv_peligro,String reproduccion,boolean pelaje,String raza, String comida_preferida) {
		super(nombre, habitat, niv_peligro, reproduccion, pelaje);
		this.raza=raza;
		this.comida_preferida=comida_preferida;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getComida_preferida() {
		return comida_preferida;
	}

	public void setComida_preferida(String comida_preferida) {
		this.comida_preferida = comida_preferida;
	}
	
	

}
