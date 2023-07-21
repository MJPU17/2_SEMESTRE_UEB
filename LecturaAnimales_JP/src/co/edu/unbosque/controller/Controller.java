package co.edu.unbosque.controller;

import co.edu.unbosque.model.AnimalDAO;
import co.edu.unbosque.model.AveDAO;
import co.edu.unbosque.model.AveDTO;
import co.edu.unbosque.model.FelinoDAO;
import co.edu.unbosque.model.FelinoDTO;
import co.edu.unbosque.model.ReptilDAO;
import co.edu.unbosque.model.ReptilDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private AnimalDAO animales;
	private AveDAO aves;
	private FelinoDAO felinos;
	private ReptilDAO reptiles;
	
	public Controller() {
		vista=new VistaConsola();
		animales=new AnimalDAO();
		aves=new AveDAO();
		felinos=new FelinoDAO();
		reptiles=new ReptilDAO();
		funcionar();
	}

	private void funcionar() {
		
		MenuPrincipal : while (true) {
			vista.imprimirConSalto("SISTEMA ANIMALES\n\n1)Ave.\n2)Felino.\n3)Reptil.\n4)Mostrar todo.\n5)Salir.\n");
			int opcion=vista.leerEntero("Ingrese opcion: ", true);
			switch (opcion) {
			case 1:{
				MenuAves: while(true) {
					vista.imprimirConSalto("GESTION DE AVES\n\n1)Agregar.\n2)Actualizar.\n3)Eliminar.\n4)Buscar.\n5)Mostar lista.\n6)Salir.\n");
					opcion=vista.leerEntero("Ingrese opcion: ", true);
					switch (opcion) {
					case 1: {
						vista.quemarLinea();	
						String nombre="";
						do {
							nombre=vista.leerLinea("Ingrese nombre:", false);
							if(animales.getLanimeles().containsKey(nombre)) {
								vista.imprimirConSalto("Este nombre ya esta registrado por favor ingrese otro.");
								}
							}while(animales.getLanimeles().containsKey(nombre));
						String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
						String habitat=vista.leerLinea("Ingrese el habitat: ", false);
						int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
						vista.quemarLinea();
						boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
						String color_plumas=vista.leerLinea("Ingrese color de las plumas:", false);
						animales.crear(nombre, new AveDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
						aves.crear(nombre, new AveDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
						vista.imprimirConSalto("\nAve guardada con exito.\n");
						break;
					}
					
					case 2: {
						vista.quemarLinea();	
						String anombre=vista.leerLinea("Ingrese nombre del ave a actualizar: ", false);	
						if(aves.getLaves().containsKey(anombre)) {	
							String nnombre=vista.leerLinea("Ingrese nombre:", false);
							String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
							String habitat=vista.leerLinea("Ingrese el habitat: ", false);
							int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
							vista.quemarLinea();
							boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
							String color_plumas=vista.leerLinea("Ingrese color de las plumas:", false);
							animales.actualizar(anombre, nnombre, new AveDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
							aves.actualizar(anombre, nnombre, new AveDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, color_plumas));
							vista.imprimirConSalto("\nAve actualizada con exito.\n");
						}else {
							vista.imprimirConSalto("\nEl ave que ingreso no esta registrada.\n");
							}
						break;
					}
					
					case 3: {
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del ave a eliminar: ", false);
						if(aves.getLaves().containsKey(nombre)) {
							aves.eliminar(nombre);
							animales.eliminar(nombre);
							vista.imprimirConSalto("\nAve eliminada con exito.\n");
						}
						else {
							vista.imprimirConSalto("\nEl ave que ingreso no esta registrada.\n");
						}
						break;
					}
					
					case 4: {
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del ave a buscar: ", false);
						if(aves.getLaves().containsKey(nombre)) {
							vista.imprimirConSalto("\n"+aves.getLaves().get(nombre).toString());
						}
						else {
							vista.imprimirConSalto("\nEl ave que ingreso no esta registrada.\n");
						}
						break;
					}
					case 5: {
						vista.imprimirConSalto(aves.getLaves().size()>0?aves.mostrar():"\nNo se ha ingresado ningun ave.\n");
						break;
					}
					
					case 6:{
						break MenuAves;
					}
					
					default:{
						vista.imprimirConSalto("Opcion invalida.");
						break;
					}
						
					}
				}
				break;
			}

			case 2:{
				MenuFelino: while(true) {
					vista.imprimirConSalto("GESTION DE FELINOS\n\n1)Agregar.\n2)Actualizar.\n3)Eliminar.\n4)Buscar.\n5)Mostar lista.\n6)Salir.\n");
					opcion=vista.leerEntero("Ingrese opcion: ", true);
					switch (opcion) {
					case 1: {
						vista.quemarLinea();	
						String nombre="";
						do {
							nombre=vista.leerLinea("Ingrese nombre:", false);
							if(animales.getLanimeles().containsKey(nombre)) {
								vista.imprimirConSalto("Este nombre ya esta registrado por favor ingrese otro.");
								}
							}while(animales.getLanimeles().containsKey(nombre));
						String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
						String habitat=vista.leerLinea("Ingrese el habitat: ", false);
						int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
						vista.quemarLinea();
						boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
						String color_pelaje=vista.leerLinea("Ingrese color del pelaje:", false);
						boolean esagresivo=vista.leerLinea("Es agresivo?", true).toLowerCase().contains("si")?true:false;
						animales.crear(nombre, new FelinoDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
						felinos.crear(nombre, new FelinoDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
						vista.imprimirConSalto("\nFelino guardado con exito\n");
						break;
					}
					
					case 2:{
						vista.quemarLinea();	
						String anombre=vista.leerLinea("Ingrese nombre del felino a actualizar: ", false);	
						if(felinos.getLfelinos().containsKey(anombre)) {	
							String nnombre=vista.leerLinea("Ingrese nombre:", false);
							String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
							String habitat=vista.leerLinea("Ingrese el habitat: ", false);
							int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
							vista.quemarLinea();
							boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
							String color_pelaje=vista.leerLinea("Ingrese color del pelaje:", false);
							boolean esagresivo=vista.leerLinea("Es agresivo?", true).toLowerCase().contains("si")?true:false;
							animales.actualizar(anombre, nnombre, new FelinoDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
							felinos.actualizar(anombre, nnombre, new FelinoDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, color_pelaje, esagresivo));
							vista.imprimirConSalto("\nFelino actualizado con exito.\n");
						}else {
							vista.imprimirConSalto("\nEl felino que ingreso no esta registrada.\n");
							}
						break;
					}
					
					case 3:{
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del felino a eliminar: ", false);
						if(felinos.getLfelinos().containsKey(nombre)) {
							felinos.eliminar(nombre);
							animales.eliminar(nombre);
							vista.imprimirConSalto("\nFelino eliminado con exito.\n");
						}
						else {
							vista.imprimirConSalto("\nEl felino que ingreso no esta registrado.\n");
						}
						break;
					}
					
					case 4:{
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del felino a buscar: ", false);
						if(felinos.getLfelinos().containsKey(nombre)) {
							vista.imprimirConSalto("\n"+felinos.getLfelinos().get(nombre).toString());
						}
						else {
							vista.imprimirConSalto("\nEl felino que ingreso no esta registrado.\n");
						}
						break;
					}
					
					case 5:{
						vista.imprimirConSalto(felinos.getLfelinos().size()>0?felinos.mostrar():"\nNo se ha ingresado ningun felino.\n");
						break;
					}
					
					case 6:{
						break MenuFelino;
					}
					
					default:{
						vista.imprimirConSalto("Opcion invalida.");
						break;
					}
						
					}
				}
				break;
			}
			
			case 3:{
				MenuReptil:while(true) {
					vista.imprimirConSalto("GESTION DE REPTILES\n\n1)Agregar.\n2)Actualizar.\n3)Eliminar.\n4)Buscar.\n5)Mostar lista.\n6)Salir.\n");
					opcion=vista.leerEntero("Ingrese opcion: ", true);
					switch (opcion) {
					case 1: {
						vista.quemarLinea();	
						String nombre="";
						do {
							nombre=vista.leerLinea("Ingrese nombre:", false);
							if(animales.getLanimeles().containsKey(nombre)) {
								vista.imprimirConSalto("Este nombre ya esta registrado por favor ingrese otro.");
								}
							}while(animales.getLanimeles().containsKey(nombre));
						String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
						String habitat=vista.leerLinea("Ingrese el habitat: ", false);
						int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
						vista.quemarLinea();
						boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
						String comida_favorita=vista.leerLinea("Ingrese comida favorita:", false);
						animales.crear(nombre, new ReptilDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
						reptiles.crear(nombre, new ReptilDTO(nombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
						vista.imprimirConSalto("\nReptil guardado con exito\n");
						break;
					}
					
					case 2:{
						vista.quemarLinea();	
						String anombre=vista.leerLinea("Ingrese nombre del reptil a actualizar: ", false);	
						if(reptiles.getLreptiles().containsKey(anombre)) {	
							String nnombre=vista.leerLinea("Ingrese nombre:", false);
							String subespecie=vista.leerLinea("Ingrese la subespecie: ", false);
							String habitat=vista.leerLinea("Ingrese el habitat: ", false);
							int tiem_vida=vista.leerEntero("Ingrese anios de vida: ", false);
							vista.quemarLinea();
							boolean esherbivoro=vista.leerLinea("Es herbivoro?", true).toLowerCase().contains("si")?true:false;
							String comida_favorita=vista.leerLinea("Ingrese comida favorita:", false);
							animales.actualizar(anombre, nnombre, new ReptilDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
							reptiles.actualizar(anombre, nnombre, new ReptilDTO(nnombre, subespecie, habitat, tiem_vida, esherbivoro, comida_favorita));
							vista.imprimirConSalto("\nReptil actualizada con exito.\n");
						}else {
							vista.imprimirConSalto("\nEl Reptil que ingreso no esta registrada.\n");
							}
						break;
					}
					
					case 3:{
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del reptil a eliminar: ", false);
						if(reptiles.getLreptiles().containsKey(nombre)) {
							reptiles.eliminar(nombre);
							animales.eliminar(nombre);
							vista.imprimirConSalto("\nReptil eliminado con exito.\n");
						}
						else {
							vista.imprimirConSalto("\nEl reptil que ingreso no esta registrado.\n");
						}
						break;
					}
					
					case 4:{
						vista.quemarLinea();
						String nombre=vista.leerLinea("Ingrese el nombre del reptil a buscar: ", false);
						if(reptiles.getLreptiles().containsKey(nombre)) {
							vista.imprimirConSalto("\n"+reptiles.getLreptiles().get(nombre).toString());
						}
						else {
							vista.imprimirConSalto("\nEl reptil que ingreso no esta registrado.\n");
						}
						break;
					}
					
					case 5:{
						vista.imprimirConSalto(reptiles.getLreptiles().size()>0?reptiles.mostrar():"\nNo se ha ingresado ningun reptil.\n");
						break;
					}
					
					case 6:{
						break MenuReptil;
					}
					
					default:{
						vista.imprimirConSalto("Opcion invalida.");
						break;
					}
					
					}
				}
				break;
			}
			
			case 4:{
				vista.imprimirConSalto(animales.getLanimeles().size()>0?animales.mostrar():"\nNo se ha ingresado ningun animal.\n");
				break;
			}
			
			case 5:{
				vista.imprimirConSalto("\nGracias por utilizar el programa.");
				break MenuPrincipal;
			}
			
			default:{
				vista.imprimirConSalto("Opcion invalida.");
				break;
			}
				
			}
		}
	}
	
	

}
