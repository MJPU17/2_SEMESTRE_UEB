package co.edu.unbosque.model;

import java.util.HashMap;

public class PlatoDAO implements OperacionesDAO{
	
	private HashMap<String, PlatoDTO> lplatos;
	
	public PlatoDAO() {
		lplatos=new HashMap<>(3);
	}
	
	@Override
	public void crear(String nombre, Object obj) {
		lplatos.put(nombre, (PlatoDTO)obj);
		
	}

	@Override
	public void actualizar(String nombre, Object obj) {
		lplatos.remove(nombre);
		lplatos.put(nombre, (PlatoDTO)obj);
		
	}

	@Override
	public void eliminar(String nombre) {
		lplatos.remove(nombre);
		
	}
	
	public void actualizar(String name, int precio) {
		lplatos.get(name).setPrecio(precio);
	}
	
	public void actualizar(String name, String[] ingredientes) {
		lplatos.get(name).setIngredientes(ingredientes);
	}
	
	public int size() {
		return lplatos.size();
	}
	
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(String plato:lplatos.keySet()) {
			sb.append(lplatos.get(plato).toString());
		}
		return sb.toString();
	}

	public HashMap<String, PlatoDTO> getLplatos() {
		return lplatos;
	}

	public void setLplatos(HashMap<String, PlatoDTO> lplatos) {
		this.lplatos = lplatos;
	}

}
