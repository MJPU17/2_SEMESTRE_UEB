package co.edu.unbosque.model;

import java.util.TreeMap;

public class LagartijaDAO implements OperacionesDAO{
	
	private TreeMap<String, LagartijaDTO> larg_list;
	
	public LagartijaDAO() {
		larg_list=new TreeMap<>();
	}

	@Override
	public void crear(String nombre, Object obj) {
		larg_list.put(nombre, (LagartijaDTO)obj);
		
	}

	@Override
	public void eliminar(String nombre) {
		larg_list.remove(nombre);
	}

	@Override
	public void actualizar(String nombre,String nuevo_nombre, Object obj) {
		larg_list.remove(nombre);
		larg_list.put(nuevo_nombre,(LagartijaDTO)obj);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		int cont=1;
		for(String monbre:larg_list.keySet()) {
			sb.append("Lagartija ").append(cont).append(" ---------------");
			sb.append(larg_list.toString());
		}
		return sb.toString();
	}

}
