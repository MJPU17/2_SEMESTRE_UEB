package co.edu.unbosque.model;

import java.util.TreeMap;

public class GestionComercial {
	
	private TreeMap<String, JefeZona> listaf;
	private TreeMap<Long, Empleado> listav;
	
	public GestionComercial() {
		listaf=new TreeMap<>();
		listav=new TreeMap<>();
	}
	
	public void agrgarJefeZona(JefeZona a) {
		listaf.put(a.getZona(), a);
	}
	
	public boolean existeJefeZona(String zona) {
		if(listaf.containsKey(zona)) {
			return true;
		}
		return false;
	}
	
	public void eliminarJefeZona(JefeZona a) {
		listaf.remove(a.getZona());
	}
	
	public void cambiarZona(JefeZona a, String zona) {
		listaf.remove(a.getZona());
		listaf.put(zona, a);
	}

	public TreeMap<String, JefeZona> getListaf() {
		return listaf;
	}

	public void setListaf(TreeMap<String, JefeZona> listaf) {
		this.listaf = listaf;
	}

}
