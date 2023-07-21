package co.edu.unbosque.model;

import java.util.TreeMap;

public class PaisDAO implements OperacionesDAO{
	
	private TreeMap<String, PaisDTO> lpaises;

	public PaisDAO() {
		lpaises=new TreeMap<>();
	}

	public TreeMap<String, PaisDTO> getLpaises() {
		return lpaises;
	}

	public void setLpaises(TreeMap<String, PaisDTO> lpaises) {
		this.lpaises = lpaises;
	}
	
	public PaisDTO getPais(String nombre) {
		return lpaises.get(nombre);
	}
	
	public int size() {
		return lpaises.size();
	}
	
	public boolean containsNombre(String nombre) {
		if(lpaises.containsKey(nombre)) {
			return true;
		}
		return false;
	}

	@Override
	public void crear(String nombre, PaisDTO pais) {
		lpaises.put(nombre, pais);
	}

	@Override
	public void actualizar(String anombre, String nnombre, PaisDTO pais) {
		lpaises.remove(anombre);
		lpaises.put(nnombre, pais);
	}

	@Override
	public void eliminar(String nombre) {
		lpaises.remove(nombre);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(String pais:lpaises.keySet()) {
			sb.append(lpaises.get(pais).toString()).append("\n\n");
		}
		return sb.toString();
	}
	
	
}
