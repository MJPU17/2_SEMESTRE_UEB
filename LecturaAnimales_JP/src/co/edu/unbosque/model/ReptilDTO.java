package co.edu.unbosque.model;

public class ReptilDTO extends AnimalDTO{
	
	private String comida_favorita;
	
	public ReptilDTO() {
		super();
		comida_favorita="";
	}

	public ReptilDTO(String nombre, String sub_especie, String habitat, int tiem_vida, boolean eshebivoro,String comida_favorita) {
		super(nombre, sub_especie, habitat, tiem_vida, eshebivoro);
		this.comida_favorita = comida_favorita;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Comida favorita: ").append(comida_favorita).append("\n");
		return sb.toString(); 
	}

	public String getComida_favorita() {
		return comida_favorita;
	}

	public void setComida_favorita(String comida_favorita) {
		this.comida_favorita = comida_favorita;
	}
	
	
}
