package co.edu.unbosque.model;

public class IsekaiDTO extends AnimeDTO {
	
	
	private String protagonista;
	private String mundo;
	
	public IsekaiDTO() {
		super();
		protagonista="";
		mundo="";
	}

	public IsekaiDTO(String nombre, String descripcion, int temporadas,String protagonista, String mundo) {
		super(nombre, descripcion, temporadas);
		this.protagonista = protagonista;
		this.mundo = mundo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Protagonista: ").append(protagonista).append("\n");
		sb.append("Mundo: ").append(mundo).append("\n");
		return sb.toString();
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getMundo() {
		return mundo;
	}

	public void setMundo(String mundo) {
		this.mundo = mundo;
	}
	
}
