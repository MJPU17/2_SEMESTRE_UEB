package co.edu.unbosque.model;

public class RestauranteDTO {
	
	private String nombre;
	private String propetario;
	private String direccion;
	private long telefono;
	private Menu menu;
	
	public RestauranteDTO() {
		nombre="";
		propetario="";
		direccion="";
		telefono=0;
		menu=new Menu();
	}
	
	public RestauranteDTO(String nombre,String propetario,String direccion,long telefono) {
		this.nombre=nombre;
		this.propetario=propetario;
		this.direccion=direccion;
		this.telefono=telefono;
		menu=new Menu();
	}
	
	public String mostrarCarta() {
		StringBuilder sb=new StringBuilder();
		sb.append("Restaurante: ").append(nombre);
		sb.append("\nPropetario: ").append(propetario);
		sb.append("\nDireccion: ").append(direccion);
		sb.append("\nTelefono: ").append(telefono);
		sb.append("\nCarta del restaurante: \n").append(menu.mostrar());
		return sb.toString();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropetario() {
		return propetario;
	}

	public void setPropetario(String propetario) {
		this.propetario = propetario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
