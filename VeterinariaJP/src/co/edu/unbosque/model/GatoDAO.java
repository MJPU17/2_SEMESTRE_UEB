package co.edu.unbosque.model;

import java.util.TreeMap;

public class GatoDAO implements OperacionesDAO{
	
	private TreeMap<String, GatoDTO> gat_list;
	
	public GatoDAO() {
		gat_list=new TreeMap<>();
	}

	@Override
	public void crear(String nombre, Object obj) {
		gat_list.put(nombre, (GatoDTO)obj);
	}

	@Override
	public void eliminar(String nombre) {
		gat_list.remove(nombre);
	}

	@Override
	public void actualizar(String nombre,String nuevo_nombre, Object obj) {
		gat_list.remove(nombre);
		gat_list.put(nuevo_nombre, (GatoDTO)obj);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		int cont=1;
		for(String nombre: gat_list.keySet()) {
			sb.append("Gato ").append(cont).append(" ---------------");
			sb.append(gat_list.get(nombre).toString());
			cont++;
		}
		return sb.toString();
	}

}
