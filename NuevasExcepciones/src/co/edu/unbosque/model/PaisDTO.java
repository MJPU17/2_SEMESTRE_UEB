package co.edu.unbosque.model;

public class PaisDTO {
	
	private String nombre;
	private String moneda;
	private int nciudades;
	private long npoblacion;
	private final String PREFIJO;
	
	public PaisDTO() {
		nombre="";
		moneda="";
		nciudades=0;
		npoblacion=0;
		PREFIJO="";
	}
	
	public PaisDTO(String nombre, String moneda, int nciudades, long npoblacion, int PREFIJO) {
		this.nombre = nombre;
		this.moneda = moneda;
		this.nciudades = nciudades;
		this.npoblacion = npoblacion;
		this.PREFIJO = "+"+PREFIJO;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre);
		sb.append("\nMoneda: ").append(moneda);
		sb.append("\nNumero de ciudades: ").append(nciudades);
		sb.append("\nNumero poblacion: ").append(npoblacion);
		sb.append("\nPrefijo: ").append(PREFIJO);
		return sb.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getNciudades() {
		return nciudades;
	}

	public void setNciudades(int nciudades) {
		this.nciudades = nciudades;
	}

	public long getNpoblacion() {
		return npoblacion;
	}

	public void setNpoblacion(long npoblacion) {
		this.npoblacion = npoblacion;
	}

	public String getPREFIJO() {
		return PREFIJO;
	}

}
