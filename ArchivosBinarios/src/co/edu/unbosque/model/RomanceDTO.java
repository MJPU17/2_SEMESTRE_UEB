package co.edu.unbosque.model;

public class RomanceDTO extends AnimeDTO {
	
	private String pareja_principal;
	private int ndiabetes;
	
	public RomanceDTO() {
		super();
		pareja_principal="";
		ndiabetes=0;
	}
	
	

	public RomanceDTO(String nombre, String descripcion, int temporadas,String pareja_principal, int ndiabetes) {
		super(nombre, descripcion, temporadas);
		this.pareja_principal = pareja_principal;
		this.ndiabetes = ndiabetes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Pareja principal: ").append(pareja_principal).append("\n");
		sb.append("Nivel diabetes: ").append(ndiabetes).append("\n");
		return sb.toString();
	}
	
	public String getPareja_principal() {
		return pareja_principal;
	}

	public void setPareja_principal(String pareja_principal) {
		this.pareja_principal = pareja_principal;
	}

	public int getNdiabetes() {
		return ndiabetes;
	}

	public void setNdiabetes(int ndiabetes) {
		this.ndiabetes = ndiabetes;
	}

}
