package co.edu.unbosque.controller;

import java.util.InputMismatchException;
import java.util.TreeMap;

import co.edu.unbosque.model.AprendizSena;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Practicante;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private TreeMap<Long, AprendizSena> laprendiz;
	private TreeMap<Long, Practicante> lpracticante;
	private TreeMap<Long, Empleado> lempleado;
	private VistaConsola vista;
	private boolean agregar;
	
	public Controller() {
		laprendiz=new TreeMap<>();
		lpracticante=new TreeMap<>();
		lempleado=new TreeMap<>();
		vista=new VistaConsola();
		funcionar();
		agregar=false;
	}
	
	public void funcionar() {
		int n=0;
		try {
			String menu="Menu.\n"+
				    "1)Adicionar aprendiz sena.\n"+
				    "2)Adicionar practicante.\n"+
				    "3)Calcular sueldo.\n"+
				    "4)Indicar nomina sena.\n"+
				    "5)Salir.\n";
		vista.mostrarInformacion(menu);
		while(n!=5) {
			n=vista.leerEntero("Ingrese una opcion.");
			vista.saltoLinea();
			if(n==1) {
				long id=vista.leerEnteroGrande("Ingrese id:");
				vista.saltoLinea();
				if(!lempleado.containsKey(id)) {
					String nombre=vista.leerLinea("Ingrese nombre:");
					long celular=vista.leerEnteroGrande("Ingrese celular:");
					vista.saltoLinea();
					int edad=vista.leerEntero("Ingrese edad:");
					AprendizSena aux=new AprendizSena(id, nombre, celular, edad);
					laprendiz.put(id,aux);
					lempleado.put(id, aux);
				}
				else {
					vista.mostrarInformacion("El id ya exista ingrese otro");
				}
			}
			else if(n==2) {
				long id=vista.leerEnteroGrande("Ingrese id:");
				vista.saltoLinea();
				if(!lempleado.containsKey(id)) {
					String nombre=vista.leerLinea("Ingrese nombre:");
					long celular=vista.leerEnteroGrande("Ingrese celular:");
					vista.saltoLinea();
					int edad=vista.leerEntero("Ingrese edad:");
					vista.saltoLinea();
					Practicante aux=new Practicante(id, nombre, celular, edad);
					lpracticante.put(id,aux);
					lempleado.put(id, aux);
				}
				else {
					vista.mostrarInformacion("El id ya exista ingrese otro");
				}
			}
			else if(n==3) {
				if(lempleado.size()>0) {
					for(Long id: lempleado.keySet()) {
						int dias=vista.leerEntero("Ingrese dias de trabajo de "+lempleado.get(id).getNombre()+".");
						vista.saltoLinea();
						long sueldo=lempleado.get(id).calcularSueldo(dias);
						lempleado.get(id).setSueldo(sueldo);
						vista.mostrarInformacion("El sueldo de "+lempleado.get(id).getNombre()+" es:"+sueldo);
					}
					agregar=true;
				}
				else {
					vista.mostrarInformacion("No se ha ingresado ningun empleado.");
				}
			}
			else if(n==4) {
				if(lempleado.size()>0&&agregar) {
					long nomina=0;
					for(Long id:lempleado.keySet()) {
						nomina+=lempleado.get(id).getSueldo();
					}
					vista.mostrarInformacion("La nomina del sena es:"+nomina);
				}
				else if(lempleado.size()==0){
					vista.mostrarInformacion("No se ha ingresado un empleado.");
				}else {
					vista.mostrarInformacion("No se ha agregado el sueldo.");
				}
			}
			else if(n==5) {
				vista.mostrarInformacion("Gracias por usar el programa.");
			}
			else {
				vista.mostrarInformacion("La opcion no existe.");
			}
			
		}
		}catch (InputMismatchException e) {
			vista.mostrarInformacion("El formato de estrada no es valido.");

			
		}
		catch (StackOverflowError e) {
			vista.mostrarInformacion("El formato de estrada no es valido.");
		}
		
	}
	
	

}
