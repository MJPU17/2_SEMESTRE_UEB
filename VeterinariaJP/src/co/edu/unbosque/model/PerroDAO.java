package co.edu.unbosque.model;

import java.util.TreeMap;

public class PerroDAO implements OperacionesDAO{
	
	private TreeMap<String, PerroDTO> per_list;
	
	public PerroDAO() {
		per_list=new TreeMap<>();
	}

	@Override
	public void crear(String nombre, Object obj) {
		per_list.put(nombre, (PerroDTO)obj);
		
	}

	@Override
	public void eliminar(String nombre) {
		per_list.remove(nombre);
	}

	@Override
	public void actualizar(String nombre,String nuevo_nombre, Object obj) {
		per_list.remove(nombre);
		per_list.put(nuevo_nombre, (PerroDTO)obj);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		int cont=1;
		for(String nombre: per_list.keySet()) {
			sb.append("Perro ").append(cont).append(" ---------------");
			sb.append(per_list.get(nombre).toString());
		}
		return sb.toString();
	}

}
