package co.edu.unbosque.controller;

import co.edu.unbosque.model.AnimeDAO;
import co.edu.unbosque.model.IseakaiDAO;
import co.edu.unbosque.model.IsekaiDTO;
import co.edu.unbosque.model.RomanceDAO;
import co.edu.unbosque.model.RomanceDTO;
import co.edu.unbosque.model.ShonenDAO;
import co.edu.unbosque.model.ShonenDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private AnimeDAO animes;
	private ShonenDAO shonens;
	private IseakaiDAO isekais;
	private RomanceDAO romances;
	
	public Controller() {
		vista=new VistaConsola();
		animes=new AnimeDAO();
		shonens=new ShonenDAO();
		isekais=new IseakaiDAO();
		romances=new RomanceDAO();
		funcionar();
	}
	
	public void funcionar() {
		int opcion=0;
		do {
			vista.mostrarInformacion("ANIMES\n\n1)Agregar.\n2)Actualizar.\n3)Eliminar.\n4)Listar.\n5)Salir.\n");
			opcion=vista.leerOpcion("Ingrese opcion: ");
			switch (opcion) {
			case 1: {
				vista.mostrarInformacion("1)Agregar shonen.\n2)Agregar isekai\n3)Agreagar romance.\n");
				opcion=vista.leerOpcion("Ingrese opcion: ");
				vista.quemarLinea();
				String nombre=vista.leerNombreSerie("Ingrese nombre del anime: ");
				if(!animes.getLanimes().containsKey(nombre)) {
					String descripcion=vista.leerDescripcion("Ingrese descripcion: ");
					int temporadas=vista.leerEntero("Ingrese numero temporadas: ");
					vista.quemarLinea();
					if(opcion==1) {
						String protagonista=vista.leerNombrePersonaje("Ingrese nombre del protagonista: ");
						String peleas=vista.leerDescripcion("Ingrese descripcion de las peleas: ");
						animes.crear(nombre, new ShonenDTO(nombre, descripcion, temporadas, protagonista, peleas));
						shonens.crear(nombre, new ShonenDTO(nombre, descripcion, temporadas, protagonista, peleas));
					}
					else if(opcion==2) {
						String protagonista=vista.leerNombrePersonaje("Ingrese nombre del protagonista: ");
						String mundo=vista.leerNombreSerie("Ingrese nombre del mundo al cual fue transportado: ");
						animes.crear(nombre, new IsekaiDTO(nombre, descripcion, temporadas, protagonista, mundo));
						isekais.crear(nombre, new IsekaiDTO(nombre, descripcion, temporadas, protagonista, mundo));
					}
					else if(opcion==3) {
						String pareja=vista.leerNombrePersonaje("Ingrese la pareja principal del anime: ");
						int ndiabetes=vista.leerEntero("Ingrese los niveles de azucar que le produce la serie: ");
						animes.crear(nombre, new RomanceDTO(nombre, descripcion, temporadas, pareja, ndiabetes));
						romances.crear(nombre, new RomanceDTO(nombre, descripcion, temporadas, pareja, ndiabetes));
					}
					opcion=0;
					vista.mostrarInformacion("\nAnime guardado con exito.\n");
				}
				else {
					vista.mostrarInformacion("Este anime ya esta registrado.");
				}
				break;
			}
			case 2:{
				String nombre=vista.leerNombreSerie("Ingrese nombre del anime a actualizar: ");
				if(animes.getLanimes().containsKey(nombre)) {
					String descripcion=vista.leerDescripcion("Ingrese descripcion: ");
					int temporadas=vista.leerEntero("Ingrese numero temporadas: ");
					vista.quemarLinea();
					if(shonens.getLshonens().containsKey(nombre)) {
						String protagonista=vista.leerNombrePersonaje("Ingrese nombre del protagonista: ");
						String peleas=vista.leerDescripcion("Ingrese descripcion de las peleas: ");
						animes.actualizar(nombre, new ShonenDTO(nombre, descripcion, temporadas, protagonista, peleas));
						shonens.actualizar(nombre, new ShonenDTO(nombre, descripcion, temporadas, protagonista, peleas));
					}
					else if(isekais.getLisekais().containsKey(nombre)) {
						String protagonista=vista.leerNombrePersonaje("Ingrese nombre del protagonista: ");
						String mundo=vista.leerNombreSerie("Ingrese nombre del mundo al cual fue transportado: ");
						animes.actualizar(nombre, new IsekaiDTO(nombre, descripcion, temporadas, protagonista, mundo));
						isekais.actualizar(nombre, new IsekaiDTO(nombre, descripcion, temporadas, protagonista, mundo));
					}
					else if(romances.getLromances().containsKey(nombre)) {
						String pareja=vista.leerNombrePersonaje("Ingrese la pareja principal del anime: ");
						int ndiabetes=vista.leerEntero("Ingrese los niveles de azucar que le produce la serie: ");
						animes.actualizar(nombre, new RomanceDTO(nombre, descripcion, temporadas, pareja, ndiabetes));
						romances.actualizar(nombre, new RomanceDTO(nombre, descripcion, temporadas, pareja, ndiabetes));
					}
					vista.mostrarInformacion("\nAnime actualizado con exito.\n");
				}
				else {
					vista.mostrarInformacion("\nEl anime ingresado no exite.\n");
				}
			}
			case 3:{
				String nombre=vista.leerNombreSerie("Ingrese nombre del anime a eliminar: ");
				if(animes.getLanimes().containsKey(nombre)) {
					animes.eliminar(nombre);
					if(shonens.getLshonens().containsKey(nombre)) {
						shonens.eliminar(nombre);
					}
					else if(isekais.getLisekais().containsKey(nombre)) {
						isekais.eliminar(nombre);
					}
					else if(romances.getLromances().containsKey(nombre)) {
						romances.eliminar(nombre);
					}
					vista.mostrarInformacion("\nAnime eliminado con exito.\n");
				}
				else {
					vista.mostrarInformacion("\nEl anime ingresado no exite.\n");
				}
			}
			case 4:{
				vista.mostrarInformacion("1)Listar todo.\n2)Listar shonen.\n3)Listar isekai.\n4)Listar romance.\n");
				opcion=vista.leerOpcion("Ingrese opcion: ");
				if(opcion==1) {
					vista.mostrarInformacion(animes.getLanimes().size()>0 ? animes.mostrar() : "No se ha ingresado ningun anime.\n");
				}
				else if(opcion==2) {
					vista.mostrarInformacion(shonens.getLshonens().size()>0 ? shonens.mostrar() : "No se ha ingresado ningun shonen.\n");
				}
				else if(opcion==3) {
					vista.mostrarInformacion(isekais.getLisekais().size()>0 ? isekais.mostrar() : "No se ha ingresado ningun iskai.\n");
				}
				else if(opcion==4) {
					vista.mostrarInformacion(romances.getLromances().size()>0 ? romances.mostrar() : "No se ha ingresado ningun romance.\n");
				}
				opcion=0;
			}
			case 5:{
				vista.mostrarInformacion("Gracias por utilizar el programa.");
			}
			default:
				vista.mostrarInformacion("Opcion invalida.");
			}
		}while(opcion!=5);
	}
	
}
