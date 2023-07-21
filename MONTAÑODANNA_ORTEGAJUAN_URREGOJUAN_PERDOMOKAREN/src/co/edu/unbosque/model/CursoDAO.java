package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class CursoDAO implements OperacionesDAO{
	
	private TreeMap<Integer, CursoDTO> lcursos;
	
	public CursoDAO() {
		try {
			lcursos=cargarDesdeArchivo();
		}catch (Exception e) {
			lcursos=new TreeMap<>();
		}
	}

	@Override
	public void crear(Object llave, Object obj) {
		lcursos.put((Integer)llave, (CursoDTO)obj);
	}

	@Override
	public void actualizar(Object allave, Object nllave, Object obj) {
		lcursos.remove((Integer)allave);
		lcursos.put((Integer)nllave, (CursoDTO)obj);
		
	}

	@Override
	public void eliminar(Object llave) {
		lcursos.remove((Integer)llave);
		guardarEnArchivo();
		guardarCursoListaEstudiantes();
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(CursoDTO curso: lcursos.values()) {
			sb.append(curso.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public String mostrarCursos(TreeMap<Long, EstudianteDTO>lestudiantes) {
		StringBuilder sb=new StringBuilder();
		for(CursoDTO curso: lcursos.values()) {
			sb.append("\n____________________\n");
			sb.append(curso.listaEstudiantes(lestudiantes));
		}
		return sb.toString();
	}
	
	public void agregarEstudianteCurso(int llave,long id) {
		lcursos.get(llave).getLid().add(id);
		guardarCursoListaEstudiantes();
	}
	
	public TreeMap<Integer, CursoDTO> cargarDesdeArchivo() {
		TreeMap<Integer, CursoDTO>archivo=new TreeMap<>();
		String[] filas=FileHandler.leerArchivo("cursos.txt").split("\n");
		for(String fila:filas) {
			int ncodigo=Integer.parseInt(fila.substring(0, 5).trim());
			int ccodigo=Integer.parseInt(fila.substring(5,10).trim());
			String nombre=fila.substring(10, 30).trim();
			String horario=fila.substring(30, 37).trim();
			int duracion=Integer.parseInt(fila.substring(37, fila.length()).trim());
			archivo.put(ccodigo, new CursoDTO(ncodigo, ccodigo, nombre, horario, duracion));
		}
		filas=FileHandler.leerArchivo("estudiantescursos.txt").split("\n");
		for(String fila : filas) {
			String[] columna=fila.split("\\s+");
			if(!columna[0].equals("")) {
				int ccodigo=Integer.parseInt(columna[0]);
				for(int i=1;i<columna.length;i++) {
					archivo.get(ccodigo).getLid().add(Long.parseLong(columna[i]));
				}
			}
		}
		return archivo;
	}
	
	public void guardarEnArchivo() {
		StringBuilder sb=new StringBuilder();
		String filas[]=FileHandler.leerArchivo("cursos.txt").split("\n");
		int index=lcursos.size();
		for(String fila : filas) {
			int ccodigo=Integer.parseInt(fila.substring(5,10).trim());
			if(lcursos.containsKey(ccodigo)) {
				sb.append(fila);
				if(index==1) {
					continue;
				}
				else {
					index--;
					sb.append("\n");
				}
			}
		}
		FileHandler.escribirArchivo("cursos.txt", sb.toString());
	}
	
	public void guardarCursoListaEstudiantes() {
		StringBuilder sb=new StringBuilder();
		
		int index=lcursos.size();
		for(CursoDTO curso : lcursos.values()) {
			sb.append(curso.getCcodigo()).append(" ");
			String ides=Arrays.asList(curso.getLid()).toString().replace("[", "").replace("]", "").replace(",", " ");
			sb.append(ides);
			if(index==1) {
				continue;
			}
			else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("estudiantescursos.txt", sb.toString());
	}
	
	
	public void guardarCursos(TreeMap<Long, EstudianteDTO> lestudiantes) {
		for(CursoDTO curso:lcursos.values()) {
			StringBuilder sb=new StringBuilder();
			sb.append(curso.getCcodigo()<10?"0"+curso.getCcodigo():curso.getCcodigo()).append(" ");
			sb.append(curso.getNombre()).append(" ");
			sb.append(curso.getHorario()).append(" ");
			sb.append(curso.getDuracion()<10?"0"+curso.getDuracion():curso.getDuracion()).append("\n");
			int index=curso.getLid().size();
			for(long id : curso.getLid()) {
				EstudianteDTO estudiante=lestudiantes.get(id);
				int e=Long.toString(estudiante.getId()).length();
				sb.append(estudiante.getId());
				for(int i=0;i<11-e;i++)sb.append(" ");
				sb.append(estudiante.getName());
				for(int i=0;i<25-estudiante.getName().length();i++) sb.append(" ");
				sb.append(estudiante.getTelefono());
				if(index==1) {
					continue;
				}
				else {
					index--;
					sb.append("\n");
				}
			}
			String filename=(curso.getCcodigo()<10?"0"+curso.getCcodigo():curso.getCcodigo())+curso.getNombre()+curso.getHorario().substring(0, curso.getHorario().indexOf(":"));
			FileHandler.escribirArchivo(filename, sb.toString());
		}
	}
	
	public void generarArchivoRetirados(ArrayList<Integer>ccodigos,TreeMap<Long, EstudianteDTO> lestudiantes) {
		StringBuilder sb=new StringBuilder();
		for(Integer ccodigo: ccodigos) {
			CursoDTO curso=lcursos.get(ccodigo);
			int index=lestudiantes.size();
			for(long id : curso.getLid()) {
				EstudianteDTO estudiante=lestudiantes.get(id);
				sb.append(curso.getCcodigo()).append(" ");
				sb.append(curso.getNcodigo()).append(" ");
				sb.append(curso.getNombre()).append(" ");
				sb.append(curso.getHorario()).append(" ");
				sb.append(curso.getDuracion()).append(" ");
				sb.append(estudiante.getId()).append(" ");
				sb.append(estudiante.getName()).append(" ");
				sb.append(estudiante.getTelefono());
				if(index==1) {
					continue;
				}
				else {
					index--;
					sb.append("\n");
				}
			}
		}
		FileHandler.escribirArchivo("retirados.txt", sb.toString());
	}
	
	public LinkedList<Object[]> arrayNiveles() {
		TreeMap<String, Integer> aux=new TreeMap<>();
		LinkedList<Object[]> niveles=new LinkedList<>();
		for(CursoDTO curso : lcursos.values()) {
			if(!aux.containsKey(curso.getNombre())) {
				aux.put(curso.getNombre(), curso.getNcodigo());
				Object[] nivel= {(String)curso.getNombre(),(Integer)curso.getNcodigo()};
				niveles.add(nivel);
			}
		}
		return niveles;
	}
	
	public LinkedList<Object[]> arrayHorario(String nombre) {
		LinkedList<Object[]> hoarios=new LinkedList<>();
		for(CursoDTO curso : lcursos.values()) {
			if(nombre.equals(curso.getNombre())) {
				Object[] horario= {(String)curso.getHorario(),(Integer)curso.getDuracion()};
				hoarios.add(horario);
			}
			
		}
		return hoarios;
	}
	
	public int obtenerLlave(int nivel,String name,String horario,int duracion) {
		for(CursoDTO curso : lcursos.values()) {
			if(curso.getNcodigo()==nivel&&curso.getNombre().equals(name)&&curso.getHorario().equals(horario)&&curso.getDuracion()==duracion) {
				return curso.getCcodigo();
			}
		}
		return -1;
	}

	public TreeMap<Integer, CursoDTO> getLcursos() {
		return lcursos;
	}

	public void setLcursos(TreeMap<Integer, CursoDTO> lcursos) {
		this.lcursos = lcursos;
	}
	
}
