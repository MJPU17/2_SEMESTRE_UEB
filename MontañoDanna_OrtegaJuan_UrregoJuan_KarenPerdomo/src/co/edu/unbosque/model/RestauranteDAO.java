package co.edu.unbosque.model;

import java.util.TreeMap;

public class RestauranteDAO implements OperacionesDAO{
	
	private TreeMap<String, RestauranteDTO> lrestaurantes;
	
	public RestauranteDAO() {
		lrestaurantes=new TreeMap<>();
	}

	@Override
	public void crear(String nombre, Object obj) {
		lrestaurantes.put(nombre, (RestauranteDTO)obj);
		
	}
	@Override
	public void actualizar(String nombre, Object obj) {
		lrestaurantes.remove(nombre);
		lrestaurantes.put(nombre, (RestauranteDTO)obj);
		
	}

	@Override
	public void eliminar(String nombre) {
		lrestaurantes.remove(nombre);
		
	}
	
	public RestauranteDTO getRestaurante(String nombre) {
		return lrestaurantes.get(nombre);
	}
	
	public boolean containsRestaurante(String nombre) {
		if(lrestaurantes.containsKey(nombre)) {
			return true;
		}
		return false;
	}

	public TreeMap<String, RestauranteDTO> getLrestaurantes() {
		return lrestaurantes;
	}

	public void setLrestaurantes(TreeMap<String, RestauranteDTO> lrestaurantes) {
		this.lrestaurantes = lrestaurantes;
	}
	
}
