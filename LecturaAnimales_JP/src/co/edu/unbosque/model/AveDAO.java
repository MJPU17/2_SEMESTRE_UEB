package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class AveDAO implements OperacionesDAO{

	private TreeMap<String, AveDTO> laves;
	
	public AveDAO() {
		
		try {
			laves=cargarDesdeArchivo();
		} catch (Exception e) {
			laves=new TreeMap<>();
		}
	}
	


	public AveDAO(TreeMap<String, AveDTO> laves) {
		this.laves = laves;
	}


	@Override
	public void crear(String llave, AnimalDTO animal) {
		laves.put(llave, (AveDTO)animal);
	}

	@Override
	public void actualizar(String anombre, String nnombre, AnimalDTO animal) {
		laves.remove(anombre);
		laves.put(nnombre, (AveDTO)animal);
	}

	@Override
	public void eliminar(String llave) {
		laves.remove(llave);
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(AveDTO ave:laves.values()) {
			sb.append("\n______________________\n");
			sb.append(ave.toString());
		}
		return sb.toString();
	}
	
	public TreeMap<String, AveDTO> cargarDesdeArchivo(){
		TreeMap<String, AveDTO> archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("archivo.csv").split("\n");
		for(String fila:filas) {
			String[] columna=fila.split(";");
			if(columna[0].equals("Ave")) {
				String nombre=columna[1];
				String subespecie=columna[2];
				String habitat=columna[3];
				int tiem_vida=Integer.parseInt(columna[4]);
				boolean esherbivoro=columna[5].equals("si")?true:false;
				String color_plumas=columna[6];
				archivo.put(nombre, new AveDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
			}
		}
		return archivo;
	}


	public TreeMap<String, AveDTO> getLaves() {
		return laves;
	}


	public void setLaves(TreeMap<String, AveDTO> laves) {
		this.laves = laves;
	}

}
