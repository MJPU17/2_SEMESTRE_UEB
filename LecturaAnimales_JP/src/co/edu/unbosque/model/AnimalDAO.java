package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class AnimalDAO implements OperacionesDAO{
	
	private TreeMap<String, AnimalDTO> lanimeles;
	
	public AnimalDAO() {
		
		try {
			lanimeles=cargarDesdeArchivo();
		}catch (Exception e) {
			lanimeles=new TreeMap<>();
		}
		
	}

	public AnimalDAO(TreeMap<String, AnimalDTO> lanimeles) {
		this.lanimeles = lanimeles;
	}



	@Override
	public void crear(String llave, AnimalDTO animal) {
		lanimeles.put(llave, animal);
		guardarEnArchivo();
	}

	@Override
	public void actualizar(String anombre, String nnombre, AnimalDTO animal) {
		lanimeles.remove(anombre);
		lanimeles.put(nnombre, animal);
		guardarEnArchivo();
	}

	@Override
	public void eliminar(String llave) {
		lanimeles.remove(llave);
		guardarEnArchivo();
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(AnimalDTO animal:lanimeles.values()) {
			sb.append("\n____________________\n");
			if(animal instanceof AveDTO)sb.append("Especie: Ave\n");
			else if(animal instanceof FelinoDTO)sb.append("Especie: Felino\n");
			else if(animal instanceof ReptilDTO)sb.append("Especie: Reptil\n");
			sb.append(animal.toString());
		}
		return sb.toString();
	}
	
	public TreeMap<String, AnimalDTO> cargarDesdeArchivo(){
		TreeMap<String, AnimalDTO> archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("archivo.csv").split("\n");
		for(String fila:filas) {
			String[] columna=fila.split(";");
			String nombre=columna[1];
			String subespecie=columna[2];
			String habitat=columna[3];
			int tiem_vida=Integer.parseInt(columna[4]);
			boolean esherbivoro=columna[5].equals("si")?true:false;
			if(columna[0].equals("Ave")) {
				String color_plumas=columna[6];
				archivo.put(nombre, new AveDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
			}
			else if(columna[0].equals("Felino")) {
				String color_pelaje=columna[6];
				boolean esagresivo=columna[7].equals("si")?true:false;
				archivo.put(nombre, new FelinoDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
			}
			else if(columna[0].equals("Reptil")) {
				String comida_favorita=columna[6];
				archivo.put(nombre, new ReptilDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
			}
		}
		return archivo;
	}
	
	public void guardarEnArchivo() {
		StringBuilder sb=new StringBuilder();
		
		int index = lanimeles.size();
		for(AnimalDTO animal:lanimeles.values()) {
			if(animal instanceof AveDTO) {
				AveDTO aux=(AveDTO)animal;
				sb.append("Ave;");
				sb.append(aux.getNombre()).append(";");
				sb.append(aux.getSub_especie()).append(";");
				sb.append(aux.getHabitat()).append(";");
				sb.append(aux.getTiem_vida()).append(";");
				sb.append(aux.isEsherbivoro()?"si":"no").append(";");
				sb.append(aux.getColor_plumas());
			}
			else if(animal instanceof FelinoDTO) {
				FelinoDTO aux=(FelinoDTO)animal;
				sb.append("Felino;");
				sb.append(aux.getNombre()).append(";");
				sb.append(aux.getSub_especie()).append(";");
				sb.append(aux.getHabitat()).append(";");
				sb.append(aux.getTiem_vida()).append(";");
				sb.append(aux.isEsherbivoro()?"si":"no").append(";");
				sb.append(aux.getColor_pelaje()).append(";");
				sb.append(aux.isEsagresivo()?"si":"no");
			}
			else if(animal instanceof ReptilDTO) {
				ReptilDTO aux=(ReptilDTO)animal;
				sb.append("Reptil;");
				sb.append(aux.getNombre()).append(";");
				sb.append(aux.getSub_especie()).append(";");
				sb.append(aux.getHabitat()).append(";");
				sb.append(aux.getTiem_vida()).append(";");
				sb.append(aux.isEsherbivoro()?"si":"no").append(";");
				sb.append(aux.getComida_favorita());
			}
			
			if (index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");

			}
		}
		FileHandler.escribirArchivo("archivo.csv", sb.toString());
	}

	public TreeMap<String, AnimalDTO> getLanimeles() {
		return lanimeles;
	}

	public void setLanimeles(TreeMap<String, AnimalDTO> lanimeles) {
		this.lanimeles = lanimeles;
	}

}
