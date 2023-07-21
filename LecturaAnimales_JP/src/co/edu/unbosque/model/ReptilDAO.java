package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class ReptilDAO implements OperacionesDAO{
	
	private TreeMap<String, ReptilDTO> lreptiles;
	
	public ReptilDAO() {
		try {
			lreptiles=cargarDesdeArchivo();
		} catch (Exception e) {
			lreptiles=new TreeMap<>();
		}
	}
	
	public ReptilDAO(TreeMap<String, ReptilDTO> lreptiles) {
		this.lreptiles=lreptiles;
	}

	@Override
	public void crear(String llave, AnimalDTO animal) {
		lreptiles.put(llave, (ReptilDTO)animal);
		
	}

	@Override
	public void actualizar(String anombre, String nnombre, AnimalDTO animal) {
		lreptiles.remove(anombre);
		lreptiles.put(nnombre, (ReptilDTO)animal);
		
	}

	@Override
	public void eliminar(String llave) {
		lreptiles.remove(llave);
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(ReptilDTO reptil:lreptiles.values()) {
			sb.append("\n_______________\n");
			sb.append(reptil.toString());
		}
		return sb.toString();
	}
	
	public TreeMap<String, ReptilDTO> cargarDesdeArchivo(){
		TreeMap<String, ReptilDTO> archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("archivo.csv").split("\n");
		for(String fila:filas) {
			String[] columna=fila.split(";");
			if(columna[0].equals("Reptil")) {
				String nombre=columna[1];
				String subespecie=columna[2];
				String habitat=columna[3];
				int tiem_vida=Integer.parseInt(columna[4]);
				boolean esherbivoro=columna[5].equals("si")?true:false;
				String comida_favorita=columna[6];
				archivo.put(nombre, new ReptilDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
			}
		}
		return archivo;
	}

	public TreeMap<String, ReptilDTO> getLreptiles() {
		return lreptiles;
	}

	public void setLreptiles(TreeMap<String, ReptilDTO> lreptiles) {
		this.lreptiles = lreptiles;
	}

}
