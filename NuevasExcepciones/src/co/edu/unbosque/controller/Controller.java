package co.edu.unbosque.controller;

import co.edu.unbosque.model.PaisDAO;
import co.edu.unbosque.model.PaisDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private PaisDAO paises;
	private VistaConsola vista;
	
	public Controller() {
		vista=new VistaConsola();
		paises=new PaisDAO();
		funcionar();
	}
	
	public void funcionar() {
		int opcion=0;
		StringBuilder menu=new StringBuilder();
		menu.append("REGISTRO DE PAISES\n");
		menu.append("1)Agregar Pais.\n");
		menu.append("2)Actualizar Pais.\n");
		menu.append("3)Eliminar Pais.\n");
		menu.append("4)Mostrar Pais.\n");
		menu.append("5)Mostrar lista paises.\n");
		menu.append("6)Salir.\n");
		
		do {
			vista.mostrarInformacion(menu.toString());
			opcion=vista.leerEntero("Ingrese una opcion: ");
			vista.quemarLinea();
			
			switch (opcion) {
			
			case 1: {
				
				String nombre="";
				do {
					nombre=vista.leerLinea("Ingrese nombre: ");
					if(paises.containsNombre(nombre)) {
						vista.mostrarInformacion("Este nombre ya esta registrado, ingrese otro.");
					}
				}while(paises.containsNombre(nombre));
				String moneda=vista.leerLinea("Ingrese la moneda del pais: ");
				int nciudades=vista.leerEntero("Ingrese el numero de ciudades del pais: ");
				long npoblacion=vista.leerEnteroGrande("Ingrese numero de habitantes del pais: ");
				int prefijo=vista.leerEntero("Ingrese prefijo del pais: ");
				
				paises.crear(nombre, new PaisDTO(nombre, moneda, nciudades, npoblacion, prefijo));
				vista.mostrarInformacion("Pais registrado con exito.\n");
				break;
			}
			
			case 2:{
				
				String anombre=vista.leerLinea("Ingrese el nombre del pais a actualizar: ");
				if(paises.containsNombre(anombre)) {
					String nnombre="";
					do {
						nnombre=vista.leerLinea("Ingrese nuevo nombre: ");
						if(anombre.equals(nnombre)) {
							break;
						}
						else if(paises.containsNombre(nnombre)) {
							vista.mostrarInformacion("Este nombre ya esta registrado, ingrese otro.");
						}
					}while(paises.containsNombre(nnombre));
					String moneda=vista.leerLinea("Ingrese la moneda del pais: ");
					int nciudades=vista.leerEntero("Ingrese el numero de ciudades del pais: ");
					long npoblacion=vista.leerEnteroGrande("Ingrese numero de habitantes del pais: ");
					int prefijo=Integer.parseInt(paises.getPais(anombre).getPREFIJO().replace("+", ""));
					
					paises.actualizar(anombre, nnombre, new PaisDTO(nnombre, moneda, nciudades, npoblacion, prefijo));
					vista.mostrarInformacion("Pais actualizado con exito.\n");
				}
				else {
					vista.mostrarInformacion("Este pais no esta registrado.\n");
				}
				break;
			}
			
			case 3:{
				
				String nombre=vista.leerLinea("Ingrese nombre del pais a eliminar: ");
				if(paises.containsNombre(nombre)){
					paises.eliminar(nombre);
					vista.mostrarInformacion("El pais fue eliminado con exito.\n");
				}
				else {
					vista.mostrarInformacion("Este pais no esta registrado.\n");
				}
				break;
			}
			
			case 4:{
				String nombre=vista.leerLinea("Ingrese nombre del pais: ");
				if(paises.containsNombre(nombre)){
					vista.mostrarInformacion(paises.getPais(nombre).toString()+"\n");
				}
				else {
					vista.mostrarInformacion("Este pais no esta registrado.\n");
				}
				break;
			}
			
			case 5:{
				vista.mostrarInformacion(paises.size()>0 ? paises.mostrar():"No se ha registrado ningun pais.\n");
				break;
			}
			
			case 6:{
				vista.mostrarInformacion("Gracias por utilizar el programa.");
				break;
			}
			
			default:
				vista.mostrarInformacion("Opcion no valida.\n");
				break;
			}
			
		}while(opcion!=6);
	}

}
