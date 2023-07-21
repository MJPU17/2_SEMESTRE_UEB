package co.edu.unbosque.model;

public class LagartijaDTO extends AnimalDTO{
	
	private String comida_preferida;
	
	public LagartijaDTO() {
		super();
		comida_preferida="";
	}
	
	public LagartijaDTO(String nombre,String habitat,int niv_peligro,String reproduccion,boolean pelaje, String comida_preferida) {
		super(nombre, habitat, niv_peligro, reproduccion, pelaje);
		this.comida_preferida=comida_preferida;
	}

	public String getComida_preferida() {
		return comida_preferida;
	}

	public void setComida_preferida(String comida_preferida) {
		this.comida_preferida = comida_preferida;
	}

}
