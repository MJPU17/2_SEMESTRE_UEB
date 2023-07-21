package co.edu.unbosque.model;

public class AveDTO extends AnimalDTO{
	
	private String color_plumas;
	
	public AveDTO() {
		super();
		color_plumas="";
	}

	public AveDTO(String nombre,String sub_especie, String habitat, int tiem_vida, boolean eshebivoro,String color_plumas) {
		super(nombre,sub_especie, habitat, tiem_vida, eshebivoro);
		this.color_plumas = color_plumas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Color plumas: ").append(color_plumas).append("\n");
		return sb.toString();
	}

	public String getColor_plumas() {
		return color_plumas;
	}

	public void setColor_plumas(String color_plumas) {
		this.color_plumas = color_plumas;
	}	

}
