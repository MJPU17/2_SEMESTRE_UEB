package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class FelinoDAO implements OperacionesDAO{
	
	private TreeMap<String, FelinoDTO> lfelinos;
	
	public FelinoDAO() {
		try {
			lfelinos=cargarDesdeArchivo();
		}catch (Exception e) {
			lfelinos=new TreeMap<>();
		}
	}
	
	

	public FelinoDAO(TreeMap<String, FelinoDTO> lfelinos) {
		this.lfelinos = lfelinos;
	}

	@Override
	public void crear(String llave, AnimalDTO animal) {
		lfelinos.put(llave, (FelinoDTO)animal);
	}

	@Override
	public void actualizar(String anombre, String nnombre, AnimalDTO animal) {
		lfelinos.remove(anombre);
		lfelinos.put(nnombre, (FelinoDTO)animal);
		
	}

	@Override
	public void eliminar(String llave) {
		lfelinos.remove(llave);
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(FelinoDTO felino: lfelinos.values()) {
			sb.append("\n________________________\n");
			sb.append(felino.toString());
		}
		return sb.toString();
	}
	
	public TreeMap<String, FelinoDTO> cargarDesdeArchivo(){
		TreeMap<String, FelinoDTO> archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("archivo.csv").split("\n");
		for(String fila:filas) {
			String columna[]=fila.split(";");
			if(columna[0].equals("Felino")) {
				String nombre=columna[1];
				String subespecie=columna[2];
				String habitat=columna[3];
				int tiem_vida=Integer.parseInt(columna[4]);
				boolean esherbivoro=columna[5].equals("si")?true:false;
				String color_pelaje=columna[6];
				boolean esagresivo=columna[7].equals("si")?true:false;
				archivo.put(nombre, new FelinoDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
			}
		}
		return archivo;
	}

	public TreeMap<String, FelinoDTO> getLfelinos() {
		return lfelinos;
	}

	public void setLfelinos(TreeMap<String, FelinoDTO> lfelinos) {
		this.lfelinos = lfelinos;
	}

}
