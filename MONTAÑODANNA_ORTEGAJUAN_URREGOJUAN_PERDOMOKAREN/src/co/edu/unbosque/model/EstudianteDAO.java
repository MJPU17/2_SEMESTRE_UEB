package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class EstudianteDAO implements OperacionesDAO{
	
	private TreeMap<Long, EstudianteDTO> lestuduiantes;
	
	public EstudianteDAO() {
		try {
			lestuduiantes=cargardesdeArchivo();
		}catch (Exception e) {
			lestuduiantes=new TreeMap<>();
		}
	}

	@Override
	public void crear(Object llave, Object obj) {
		lestuduiantes.put((Long)llave, (EstudianteDTO)obj);
		guardarEnArchivo();
	}

	@Override
	public void actualizar(Object allave, Object nllave, Object obj) {
		lestuduiantes.remove((Long)allave);
		lestuduiantes.put((Long)nllave, (EstudianteDTO)obj);
		guardarEnArchivo();
	}

	@Override
	public void eliminar(Object llave) {
		lestuduiantes.remove((Long)llave);
		guardarEnArchivo();
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(EstudianteDTO estudiante:lestuduiantes.values()) {
			sb.append(estudiante.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public TreeMap<Long, EstudianteDTO> cargardesdeArchivo(){
		TreeMap<Long, EstudianteDTO> archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("estudiantes.txt").split("\n");
		for(String fila:filas) {
			String[] columna=fila.split(" ");
			long id=Long.parseLong(columna[0]);
			String nombre=columna[1].replace("_", " ");
			long telefono=Long.parseLong(columna[2]);
			archivo.put(id, new EstudianteDTO(id, nombre, telefono));
		}
		return archivo;
	}
	
	public void guardarEnArchivo() {
		StringBuilder sb=new StringBuilder();
		int index=lestuduiantes.size();
		for(EstudianteDTO estudianes: lestuduiantes.values()) {
			sb.append(estudianes.getId()).append(" ");
			sb.append(estudianes.getName().replaceAll("\\s+", "_")).append(" ");
			sb.append(estudianes.getTelefono());
			
			if(index==1) {
				continue;
			}
			else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("estudiantes.txt", sb.toString());
	}
	
	

	public TreeMap<Long, EstudianteDTO> getLestuduiantes() {
		return lestuduiantes;
	}

	public void setLestuduiantes(TreeMap<Long, EstudianteDTO> lestuduiantes) {
		this.lestuduiantes = lestuduiantes;
	}
	
}
