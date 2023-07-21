package co.edu.unbosque.model;

public class FelinoDTO extends AnimalDTO{
	
	private String color_pelaje;
	private boolean esagresivo;
	
	public FelinoDTO() {
		super();
		color_pelaje="";
		esagresivo=false;
	}
	
	

	public FelinoDTO(String nombre, String sub_especie, String habitat, int tiem_vida, boolean eshebivoro,String color_pelaje, boolean esagresivo) {
		super(nombre,sub_especie, habitat, tiem_vida, eshebivoro);
		this.color_pelaje = color_pelaje;
		this.esagresivo = esagresivo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Color pelaje: ").append(color_pelaje).append("\n");
		sb.append("Es agresivo? ").append(esagresivo?"Si":"No").append("\n");
		return sb.toString();
	}

	public String getColor_pelaje() {
		return color_pelaje;
	}

	public void setColor_pelaje(String color_pelaje) {
		this.color_pelaje = color_pelaje;
	}

	public boolean isEsagresivo() {
		return esagresivo;
	}

	public void setEsagresivo(boolean esagresivo) {
		this.esagresivo = esagresivo;
	}
	
}
