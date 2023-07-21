package co.edu.unbosque.controller;

import java.util.InputMismatchException;

import co.edu.unbosque.model.AnimalDAO;
import co.edu.unbosque.model.GatoDAO;
import co.edu.unbosque.model.GatoDTO;
import co.edu.unbosque.model.LagartijaDAO;
import co.edu.unbosque.model.LagartijaDTO;
import co.edu.unbosque.model.PerroDAO;
import co.edu.unbosque.model.PerroDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	VistaConsola vista;
	AnimalDAO alist;
	GatoDAO glist;
	PerroDAO plist;
	LagartijaDAO llist;
	
	
	public Controller() {
		vista=new VistaConsola();
		alist=new AnimalDAO();
		glist=new GatoDAO();
		plist=new PerroDAO();
		llist=new LagartijaDAO();
		funcionar();
	}

	public void funcionar() {
		
		int opcion=0;
		boolean valido=true;
		
		while (opcion!=6) {
			vista.mostrarInformacion("VETERINARIA\n1)Agregar.\n2)Actualizar.\n3)Eliminar.\n4)Mostrar un animal.\n5)Mostrar todos los animales.\n6)Salir.");
			do {
				try {
					opcion=vista.leerEntero("Ingrese opcion:");
					valido=true;
				} catch (InputMismatchException e) {
					vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
					valido=false;
				}
				vista.quemarLinea();
			}while(!valido);
			
			if(opcion==1) {
				vista.mostrarInformacion("1)Agregar gato.\n2)Agregar perro.\n3)Agregar lagartija.\n");
				do {
					try {
						opcion=vista.leerEntero("Ingrese opcion:");
						valido=true;
					} catch (InputMismatchException e) {
						vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
						valido=false;
					}
					vista.quemarLinea();
				}while(!valido);
				
				if(opcion==1||opcion==2||opcion==3) {
					String nombre=vista.leerLinea("Ingrese nombre :").trim();
					if(!alist.getAni_list().containsKey(nombre)) {
						String habitat=vista.leerLinea("Ingrese habitat: ");
						String reproduccion=vista.leerLinea("Ingrese tipo reproduccion:");
						int niv_peligro=0;
						do {
							try {
								niv_peligro=vista.leerEntero("Ingrese nivel de peligro:");
								valido=true;
							} catch (InputMismatchException e) {
								vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
								valido=false;
							}
							vista.quemarLinea();
						}while(!valido);
						boolean pelaje=vista.leerLinea("El animal tiene pelaje?").toLowerCase().contains("si");
						if(opcion==1) {
							String raza=vista.leerLinea("Ingrese la raza: ");
							int hor_sunio=0;
							do {
								try {
									hor_sunio=vista.leerEntero("Ingrese horas de suenio: ");
									valido=true;
								}catch (InputMismatchException e) {
									vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
									valido=false;
								}
								vista.quemarLinea();
							} while (!valido);
							GatoDTO gato=new GatoDTO(nombre, habitat, niv_peligro, reproduccion, pelaje, raza, hor_sunio);
							glist.crear(nombre, gato);
							alist.crear(nombre, gato);
						}
						else if(opcion==2) {
							String raza=vista.leerLinea("Ingrese la raza: ");
							String comida_preferida=vista.leerLinea("Ingrese comida favorita: ");
							PerroDTO perro=new PerroDTO(nombre, habitat, niv_peligro, reproduccion, pelaje, raza, comida_preferida);
							plist.crear(nombre, perro);
							alist.crear(nombre, perro);
						}
						else if(opcion==3) {
							String comida_preferida=vista.leerLinea("Ingrese comida favorita: ");
							LagartijaDTO lagartija =new LagartijaDTO(nombre, habitat, niv_peligro, reproduccion, pelaje, comida_preferida);
							llist.crear(nombre, lagartija);
							alist.crear(nombre, lagartija);
						}
					}
					else {
						vista.mostrarInformacion("El animal ya esta registrado ingrese otro.");
					}
				}
				else {
					vista.mostrarInformacion("Opcion no valida.");
					opcion=0;
				}
				
			}
			else if(opcion==2) {
				String nombre=vista.leerLinea("Ingrese el nombre del animal que quiere actualizar: ").trim();
				if(alist.getAni_list().containsKey(nombre)) {
					String nuevo_nombre=vista.leerLinea("Ingrese nombre :").trim();
					String habitat=vista.leerLinea("Ingrese habitat: ");
					String reproduccion=vista.leerLinea("Ingrese tipo reproduccion:");
					int niv_peligro=0;
					do {
						try {
							niv_peligro=vista.leerEntero("Ingrese nivel de peligro:");
							valido=true;
						} catch (InputMismatchException e) {
							vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
							valido=false;
						}
						vista.quemarLinea();
					}while(!valido);
					boolean pelaje=vista.leerLinea("El animal tiene pelaje?").toLowerCase().contains("si");
					if(alist.getAni_list().get(nombre) instanceof GatoDTO) {
						String raza=vista.leerLinea("Ingrese la raza: ");
						int hor_sunio=0;
						do {
							try {
								hor_sunio=vista.leerEntero("Ingrese horas de suenio: ");
								valido=true;
							}catch (InputMismatchException e) {
								vista.mostrarInformacion("Formato de entrada incorrecto ingrese nuevamente el dato.");
								valido=false;
							}
							vista.quemarLinea();
						} while (!valido);
						GatoDTO gato=new GatoDTO(nuevo_nombre, habitat, niv_peligro, reproduccion, pelaje, raza, hor_sunio);
						glist.actualizar(nombre, nuevo_nombre, gato);
						alist.actualizar(nombre, nuevo_nombre, gato);
					}
					else if(alist.getAni_list().get(nombre) instanceof PerroDTO) {
						String raza=vista.leerLinea("Ingrese la raza: ");
						String comida_preferida=vista.leerLinea("Ingrese comida favorita: ");
						PerroDTO perro=new PerroDTO(nuevo_nombre, habitat, niv_peligro, reproduccion, pelaje, raza, comida_preferida);
						plist.actualizar(nombre, nuevo_nombre, perro);
						alist.actualizar(nombre, nuevo_nombre, perro);
					}
					else if(alist.getAni_list().get(nombre) instanceof LagartijaDTO) {
						String comida_preferida=vista.leerLinea("Ingrese comida favorita: ");
						LagartijaDTO lagartija =new LagartijaDTO(nuevo_nombre, habitat, niv_peligro, reproduccion, pelaje, comida_preferida);
						llist.actualizar(nombre, nuevo_nombre, nombre);
						alist.actualizar(nombre, nuevo_nombre, lagartija);
					}
				}
				else {
					vista.mostrarInformacion("El animal que quiere actualizar no existe.");
				}
			}
			else if(opcion==3) {
				String nombre=vista.leerLinea("Ingrese el nombre del animal que quiere eliminar: ");
				if(alist.getAni_list().containsKey(nombre)) {
					if(alist.getAni_list().get(nombre) instanceof GatoDTO) {
						glist.eliminar(nombre);
					}
					else if(alist.getAni_list().get(nombre) instanceof PerroDTO) {
						plist.eliminar(nombre);
					}
					else if(alist.getAni_list().get(nombre) instanceof LagartijaDTO) {
						llist.eliminar(nombre);
					}
					alist.eliminar(nombre);
				}
				else {
					vista.mostrarInformacion("El animal que quiere eliminar no existe.");
				}
			}
			else if(opcion==4) {
				String nombre=vista.leerLinea("Ingrese nombre del animal:");
				vista.mostrarInformacion(alist.getAni_list().containsKey(nombre) ? "\n----------\n"+alist.getAni_list().get(nombre)+
						"\n----------\n":"El nombre de este animal no esta registrado.");
			}
			else if(opcion==5) {
				vista.mostrarInformacion(alist.getAni_list().size()>0 ? alist.mostrar() : "No se ha ingresado ningun animal.");
			}
			else if(opcion==6) {
				vista.mostrarInformacion("Gracias por utilizar el programa.");
			}
			else {
				vista.mostrarInformacion("La opcion ingresada no es valida.");
			}
		}
	}
	
}
