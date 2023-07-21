package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.unbosque.model.CursoDAO;
import co.edu.unbosque.model.CursoDTO;
import co.edu.unbosque.model.EstudianteDAO;
import co.edu.unbosque.model.EstudianteDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private CursoDAO cursos;
	private EstudianteDAO estudiantes;
	
	public Controller() {
		vista=new VistaConsola();
		cursos=new CursoDAO();
		estudiantes=new EstudianteDAO();
		funcionar();
	}

	private void funcionar() {
		
		int opcion=0;
		do {
			vista.imprimirConSalto("THE FOREST SCHOOL\n\n1)Incribir estudiante.\n2)Listar cursos.\n3)Cancelar cursos.\n4)Cierre incripciones.\n5)Salir.");
			opcion=vista.leerOpcion("\nIngrese opcion: ");
			switch (opcion) {
			case 1: {
				long id=vista.leerEnteroGrande("Ingrese numero identificacion: ", 11);
				if(!estudiantes.getLestuduiantes().containsKey(id)) {
					vista.quemarLinea();
					String name=vista.leerlinea("Ingrese nombre: ", 25);
					long telefono=vista.leerEnteroGrande("Ingrese telefono.", 10);
					LinkedList<Object[]>aux=cursos.arrayNiveles();
					for(int i=0;i<aux.size();i++) {
						Object[]nivel=aux.get(i);
						vista.imprimirConSalto((i+1)+")Curso: "+nivel[0]+"; Nivel: "+nivel[1]);
					}
					
					do {
						opcion=vista.leerOpcion("\nIngrese el curso a incribir: ");
						if(opcion<1||opcion>aux.size()) {
							vista.imprimirConSalto("Opcion invalida.");
						}
					}while(opcion<1||opcion>aux.size());
					
					String curso=(String)aux.get(opcion-1)[0];
					int ncodigo=(int)aux.get(opcion-1)[1];
					aux=cursos.arrayHorario(curso);
					
					for(int i=0;i<aux.size();i++) {
						Object[]horario=aux.get(i);
						vista.imprimirConSalto((i+1)+")Inicio: "+horario[0]+"; Duracion: "+horario[1]);
					}
					
					do {
						opcion=vista.leerOpcion("\nIngrese el horario : ");
						if(opcion<1||opcion>aux.size()) {
							vista.imprimirConSalto("Opcion invalida.");
						}
					}while(opcion<1||opcion>aux.size());
					
					String horario=(String)aux.get(opcion-1)[0];
					int duracion=(int)aux.get(opcion-1)[1];
					estudiantes.crear(id, new EstudianteDTO(id, name, telefono));
					cursos.agregarEstudianteCurso(cursos.obtenerLlave(ncodigo, curso, horario, duracion), id);
					vista.imprimirConSalto("\nEsttudiante matriculado con exito.\n");
				}
				else {
					vista.imprimirConSalto("\nEl numero de identificacion ya esta registrado.");
				}
				break;
			}
			
			case 2:{
				vista.imprimirConSalto(cursos.mostrarCursos(estudiantes.getLestuduiantes())+"\n");
				break;
			}
			
			case 3:{
				ArrayList<Integer>retirados=new ArrayList<>();
				int i=0;
				for(CursoDTO curso : cursos.getLcursos().values()) {
					if(curso.getLid().size()<7) {
						i++;
						if(i==1) {
							vista.imprimirConSalto("Los cursos que se van a eliminar son: ");
						}
						vista.imprimirConSalto(curso.getCcodigo()+" "+curso.getNombre());
						retirados.add(curso.getCcodigo());
					}
				}
				
				if(i>0) {
					vista.quemarLinea();
					boolean verificar=vista.leerBoolean("Esta seguro de eliminar estos cursos: ");
					if(verificar) {
						ArrayList<Long>eliminados=new ArrayList<>();
						cursos.generarArchivoRetirados(retirados, estudiantes.getLestuduiantes());
						for(int codigo : retirados) {
							eliminados.addAll(cursos.getLcursos().get(codigo).getLid());
							cursos.eliminar(codigo);
						}
						for(long id : eliminados) {
							estudiantes.eliminar(id);
						}
						vista.imprimirConSalto("Cursos eliminados con exito.");
					}
					
				}
				else {
					vista.imprimirConSalto("No es necesario eliminar cursos todos tienen siete o mas matriculados.");
				}
				break;
			}
			
			case 4:{
				vista.quemarLinea();
				boolean verificar=vista.leerBoolean("Esta seguro que quiere cerrar las inscripciones: ");
				if(verificar) {
					for(CursoDTO curso:cursos.getLcursos().values()) {
						String filename=(curso.getCcodigo()<10?"0"+curso.getCcodigo():curso.getCcodigo())+curso.getNombre()+curso.getHorario().substring(0, curso.getHorario().indexOf(":"));
						vista.leerCorreo("Ingrese el correo al que se le enviara el archivo "+filename+".txt:");
					}
					cursos.guardarCursos(estudiantes.getLestuduiantes());
					vista.imprimirConSalto("\nCursos enviados con exito.\n");
				}
				break;
			}
			
			case 5:{
				vista.imprimirConSalto("Gracias por utilizar el programa.");
				break;
			}
			
			default:{
				vista.imprimirConSalto("Opcion invalida.");
				break;
			}
				
			}
		}while(opcion!=5);
		
	}
	
	

}
