package co.edu.unbosque.model;

import java.util.LinkedList;
import java.util.TreeMap;

public class CursoDTO {
	
	private int ncodigo;
	private int ccodigo;
	private String nombre;
	private String horario;
	private int duracion;
	private LinkedList<Long> lid;
	
	public CursoDTO() {
		ncodigo=0;
		ccodigo=0;
		nombre="";
		horario="";
		duracion=0;
		lid=new LinkedList<>();
	}

	public CursoDTO(int ncodigo, int ccodigo, String nombre, String horario, int duracion) {
		this.ncodigo = ncodigo;
		this.ccodigo = ccodigo;
		this.nombre = nombre;
		this.horario = horario;
		this.duracion = duracion;
		lid=new LinkedList<>(); 
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Codigo : ").append(ccodigo).append("\n");
		sb.append("Nombre del curso: ").append(nombre).append("\n");
		sb.append("Nivel : ").append(ncodigo).append("\n");
		sb.append("Horario: ").append(horario).append("\n");
		sb.append("Duracion: ").append(duracion).append(" minutos\n");
		sb.append("Cantidad de matriculados: ").append(lid.size()).append("\n");
		return sb.toString();
	}
	
	public String listaEstudiantes(TreeMap<Long, EstudianteDTO>lestudiantes) {
		StringBuilder sb=new StringBuilder();
		sb.append(toString());
		if(lid.size()>0) {
			int i=1;
			for(long id: lid) {
				EstudianteDTO estudiante=lestudiantes.get(id);
				sb.append("\n\nEstudiante "+i+"\n");
				sb.append(estudiante.toString());
				i++;
			}
		}
		else {
			sb.append("\nNo se ha matriculado nigun estudiante.");
		}
		return sb.toString();
	}

	public int getNcodigo() {
		return ncodigo;
	}

	public void setNcodigo(int ncodigo) {
		this.ncodigo = ncodigo;
	}

	public int getCcodigo() {
		return ccodigo;
	}

	public void setCcodigo(int ccodigo) {
		this.ccodigo = ccodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LinkedList<Long> getLid() {
		return lid;
	}

	public void setLid(LinkedList<Long> lid) {
		this.lid = lid;
	}
	
}
