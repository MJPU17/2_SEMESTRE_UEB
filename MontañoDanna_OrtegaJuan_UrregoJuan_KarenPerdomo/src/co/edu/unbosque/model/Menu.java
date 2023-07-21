package co.edu.unbosque.model;

public class Menu {
	
	private PlatoDAO entradas;
	private PlatoDAO pprincipales;
	private PlatoDAO bebidas;
	private PlatoDAO postres;
	
	public Menu() {
		entradas=new PlatoDAO();
		pprincipales=new PlatoDAO();
		bebidas=new PlatoDAO();
		postres=new PlatoDAO();
	}
	
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		sb.append("\nENTRADAS-------------\n");
		sb.append(entradas.size()>0 ? entradas.mostrar():"El restaurante no tiene entradas.\n");
		sb.append("PLATOS PRINCIPALES---\n");
		sb.append(pprincipales.size()>0 ? pprincipales.mostrar():"El restaurante no tiene platos principales.\n");
		sb.append("BEBIDAS--------------\n");
		sb.append(bebidas.size()>0 ? bebidas.mostrar():"El restaurante no tiene bebidas.\n");
		sb.append("POSTRES--------------\n");
		sb.append(postres.size()>0 ? postres.mostrar():"El restaurante no tiene postres.\n");
		return sb.toString();
	}
	
	public PlatoDTO getEntrada(String nombre) {
		return entradas.getLplatos().get(nombre);
	}
	
	public PlatoDTO getPlatoPrincipal(String nombre) {
		return pprincipales.getLplatos().get(nombre);
	}
	
	public PlatoDTO getBebida(String nombre) {
		return bebidas.getLplatos().get(nombre);
	}
	
	public PlatoDTO getPostre(String nombre) {
		return postres.getLplatos().get(nombre);
	}
	
	public boolean containsEntrada(String nombre) {
		if(entradas.getLplatos().containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
	public boolean containsPlatoPrincipal(String nombre) {
		if(pprincipales.getLplatos().containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
	public boolean containsBebida(String nombre) {
		if(bebidas.getLplatos().containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
	public boolean containsPostre(String nombre) {
		if(postres.getLplatos().containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
	

	public PlatoDAO getEntradas() {
		return entradas;
	}

	public void setEntradas(PlatoDAO entradas) {
		this.entradas = entradas;
	}

	public PlatoDAO getPprincipales() {
		return pprincipales;
	}

	public void setPprincipales(PlatoDAO pprincipales) {
		this.pprincipales = pprincipales;
	}

	public PlatoDAO getBebidas() {
		return bebidas;
	}

	public void setBebidas(PlatoDAO bebidas) {
		this.bebidas = bebidas;
	}

	public PlatoDAO getPostres() {
		return postres;
	}

	public void setPostres(PlatoDAO postres) {
		this.postres = postres;
	}

}
