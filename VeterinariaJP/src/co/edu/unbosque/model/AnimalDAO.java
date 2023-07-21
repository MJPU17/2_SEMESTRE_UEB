package co.edu.unbosque.model;

import java.util.TreeMap;

public class AnimalDAO implements OperacionesDAO{
	
	public TreeMap<String, AnimalDTO> ani_list;
	
	public AnimalDAO() {
		ani_list=new TreeMap<>();
	}

	@Override
	public void crear(String nombre,Object obj) {
		ani_list.put(nombre, (AnimalDTO)obj);
	}

	@Override
	public void eliminar(String nombre) {
		ani_list.remove(nombre);
	}
	@Override
	public void actualizar(String nombre,String nuevo_nombre, Object obj) {
		ani_list.remove(nombre);
		ani_list.put(nuevo_nombre, (AnimalDTO)obj);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(String nombre: ani_list.keySet()) {
			sb.append("\n--------------------\n");
			if(ani_list.get(nombre) instanceof GatoDTO) {
				GatoDTO aux=(GatoDTO)ani_list.get(nombre);
				sb.append("Especie Gato\n");
				sb.append(aux.toString());
			}
			else if(ani_list.get(nombre) instanceof PerroDTO) {
				PerroDTO aux=(PerroDTO)ani_list.get(nombre);
				sb.append("Especie Perro\n");
				sb.append(aux.toString());
			}
			else if(ani_list.get(nombre) instanceof LagartijaDTO) {
				LagartijaDTO aux=(LagartijaDTO)ani_list.get(nombre);
				sb.append("Especie Lagartija\n");
				sb.append(aux.toString());
			}
		}
		sb.append("\n--------------------\n");
		return sb.toString();
	}
	
	public void agregarGatos(TreeMap<String, GatoDTO> gatos) {
		ani_list.putAll(gatos);
	}
	
	public void agregarPerros(TreeMap<String, PerroDTO> perros) {
		ani_list.putAll(perros);
	}
	
	public void agregarLagartija(TreeMap<String, LagartijaDTO> lagartijas) {
		ani_list.putAll(lagartijas);
	}

	public TreeMap<String, AnimalDTO> getAni_list() {
		return ani_list;
	}

	public void setAni_list(TreeMap<String, AnimalDTO> ani_list) {
		this.ani_list = ani_list;
	}
	
}
