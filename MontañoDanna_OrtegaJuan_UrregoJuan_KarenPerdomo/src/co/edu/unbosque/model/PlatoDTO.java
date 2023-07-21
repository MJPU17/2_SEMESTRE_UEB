package co.edu.unbosque.model;

public class PlatoDTO {
	
	private String nombre;
	private String descripcion;
	private String[] ingredientes;
	private int precio;
	
	public PlatoDTO() {
		nombre="";
		descripcion="";
		ingredientes=null;
		precio=0;
	}
	
	public PlatoDTO(String nombre,String descripcion,String[] ingredientes,int precio) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.ingredientes=ingredientes;
		this.precio=precio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre);
		sb.append("\nPrecio: ").append(precio);
		sb.append("\nDescripcion: ").append(descripcion);
		sb.append("\nIngredientes: ");
		for(int i=0;i<ingredientes.length;i++) {
			sb.append(ingredientes[i]);
			sb.append(i<ingredientes.length-1?", ":".");
		}
		sb.append("\n\n");
		return sb.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
