package co.edu.unbosque.controller;

import java.util.InputMismatchException;

import co.edu.unbosque.model.PlatoDTO;
import co.edu.unbosque.model.RestauranteDAO;
import co.edu.unbosque.model.RestauranteDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private RestauranteDAO gestion;
	
	public Controller() {
		vista=new VistaConsola();
		gestion=new RestauranteDAO();
		funcionar();
	}

	public void funcionar() {
		
		int opcion=0;
		boolean valido=true;
		
		while(opcion!=8) {
			vista.motrarInformacion("GESTION RESTAURANTES\n1)Crear Restaurante.\n2)Crear un plato en una Carta del Restaurante.\n3)Modificar ingredientes de un plato.\n"
					+ "4)Modificar el precio de un plato.\n5)Eliminar un plato.\n6)Mostrar plato.\n7)Mostrar carta de Restaurante.\n8)Salir.");
			
			do {
				try {
					opcion=vista.leerEntero("Ingrese opcion: ");
					valido=true;
				} catch (InputMismatchException e) {
					vista.motrarInformacion("Formato de entrada no valido.");
					valido=false;
				}
				vista.quemarLinea();
			}while(!valido);
			
			if(opcion==1) {
				String nombre="";
				do {
					nombre=vista.leerLinea("Ingrese nombre: ");
					if(gestion.containsRestaurante(nombre)) {
						vista.motrarInformacion("El nombre de este restaurante ya existe por favor ingrese otro.");
					}
				}while(gestion.containsRestaurante(nombre));
				
				String propetario=vista.leerLinea("Ingrese propetario: ");
				String dereccion=vista.leerLinea("Ingrese direccion: ");
				long telefono=0;
				do {
					try {
						telefono=vista.leerEnteroGrande("Ingrese telefono: ");
						valido=true;
					}catch (InputMismatchException e) {
						vista.motrarInformacion("Formato de entrada no valido.");
						valido=false;
					}
					vista.quemarLinea();
				}while(!valido);
				
				
				
				
				RestauranteDTO restaurante=new RestauranteDTO(nombre, propetario, dereccion, telefono);
				gestion.crear(nombre, restaurante);
				
			}
			else if(opcion==2) {
				String rnombre=vista.leerLinea("Ingrese nombre de restaurante: ");
				if(gestion.containsRestaurante(rnombre)) {
					vista.motrarInformacion("1)Ingresar entrada.\n2)Ingresar plato principal.\n3)Ingresar bebida\n4)Ingresar postre.");
					do {
						try {
							opcion=vista.leerEntero("Ingrese opcion: ");
							valido=true;
						} catch (InputMismatchException e) {
							vista.motrarInformacion("Formato de entrada no valido.");
							valido=false;
						}
						vista.quemarLinea();
					}while(!valido);
					if(opcion==1&&gestion.getRestaurante(rnombre).getMenu().getEntradas().size()==3) {
						vista.motrarInformacion("Las entradas de este restaurante ya estan al maximo.");
					}
					else if(opcion==2&&gestion.getRestaurante(rnombre).getMenu().getPprincipales().size()==3) {
						vista.motrarInformacion("Los platos principales de este restaurante ya estan al maximo.");
					}
					else if(opcion==3&&gestion.getRestaurante(rnombre).getMenu().getBebidas().size()==3) {
						vista.motrarInformacion("Las bebidas de este restaurante ya estan al maximo.");
					}
					else if(opcion==4&&gestion.getRestaurante(rnombre).getMenu().getPostres().size()==3) {
						vista.motrarInformacion("Los postres de este restaurante ya estan al maximo.");
					}
					else if(opcion==1||opcion==2||opcion==3||opcion==4) {
						String pnombre="";
						do {
							pnombre=vista.leerLinea("Ingrese nombre: ");
							if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) 
							{
								vista.motrarInformacion("El nombre de este plato ya existe por favor ingrese otro.");
							}
						}while(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
								gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre));
						
						String descripcion=vista.leerLinea("Ingrese descripcion del plato: ");
						String[] ingredientes=vista.leerLinea("Ingrese ingredientes: ").replace(" y ", ",").replace(".", "").split(",");
						for(int i=0;i<ingredientes.length;i++) {
							ingredientes[i]=ingredientes[i].trim();
						}
						
						int precio=0;
						do {
							try {
								precio=vista.leerEntero("Ingrese precio: ");
								valido=true;
							}catch (InputMismatchException e) {
								vista.motrarInformacion("Formato de entrada no valido.");
								valido=false;
							}
							vista.quemarLinea();
						}while(!valido);

						PlatoDTO plato=new PlatoDTO(pnombre, descripcion,ingredientes, precio);
						if(opcion==1) {
							gestion.getRestaurante(rnombre).getMenu().getEntradas().crear(pnombre, plato);
						}
						else if(opcion==2) {
							gestion.getRestaurante(rnombre).getMenu().getPprincipales().crear(pnombre, plato);
						}
						else if(opcion==3) {
							gestion.getRestaurante(rnombre).getMenu().getBebidas().crear(pnombre, plato);
						}
						else if(opcion==4) {
							gestion.getRestaurante(rnombre).getMenu().getPostres().crear(pnombre, plato);
						}
					}
					else {
						vista.motrarInformacion("Opcion no valida.");
						opcion=0;
					}
					
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
				
			}
			else if(opcion==3) {
				String rnombre=vista.leerLinea("Ingrese nombre del restaurante");
				if(gestion.containsRestaurante(rnombre)) {
					String pnombre=vista.leerLinea("Ingrese nombre del plato: ");
					if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) 
					{
						String[] ingredientes=vista.leerLinea("Ingrese ingredientes: ").replace(" y ", ",").replace(".", "").split(",");
						for(int i=0;i<ingredientes.length;i++) {
								ingredientes[i]=ingredientes[i].trim();
						}
						if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getEntradas().actualizar(pnombre, ingredientes);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPprincipales().actualizar(pnombre, ingredientes);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getBebidas().actualizar(pnombre, ingredientes);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPostres().actualizar(pnombre, ingredientes);
						}
					}
					else {
						vista.motrarInformacion("Este plato no existe.");
					}
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
			}
			else if(opcion==4) {
				String rnombre=vista.leerLinea("Ingrese nombre del restaurante");
				if(gestion.containsRestaurante(rnombre)) {
					String pnombre=vista.leerLinea("Ingrese nombre del plato: ");
					if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) 
					{
						int precio=0;
						do {
							try {
								precio=vista.leerEntero("Ingrese precio: ");
								valido=true;
							}catch (InputMismatchException e) {
								vista.motrarInformacion("Formato de entrada no valido.");
								valido=false;
							}
							vista.quemarLinea();
						}while(!valido);
						if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getEntradas().actualizar(pnombre, precio);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPprincipales().actualizar(pnombre, precio);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getBebidas().actualizar(pnombre, precio);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPostres().actualizar(pnombre, precio);
						}
						
					}
					else {
						vista.motrarInformacion("Este plato no existe.");
					}
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
			}
			else if(opcion==5) {
				String rnombre=vista.leerLinea("Ingrese nombre del restaurante");
				if(gestion.containsRestaurante(rnombre)) {
					String pnombre=vista.leerLinea("Ingrese nombre del plato a eliminar: ");
					if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) 
					{
						if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getEntradas().eliminar(pnombre);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPprincipales().eliminar(pnombre);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getBebidas().eliminar(pnombre);
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) {
							gestion.getRestaurante(rnombre).getMenu().getPostres().eliminar(pnombre);
						}
						vista.motrarInformacion("El pato ha sido eliminado con extito.");
					}
					else {
						vista.motrarInformacion("Este plato no existe.");
					}
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
			}
			else if(opcion==6) {
				String rnombre=vista.leerLinea("Ingrese nombre del restaurante");
				if(gestion.containsRestaurante(rnombre)) {
					String pnombre=vista.leerLinea("Ingrese nombre del plato: ");
					if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)||
							gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) 
					{
						if(gestion.getRestaurante(rnombre).getMenu().containsEntrada(pnombre)) {
							vista.motrarInformacion(gestion.getRestaurante(rnombre).getMenu().getEntrada(pnombre).toString());
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPlatoPrincipal(pnombre)) {
							vista.motrarInformacion(gestion.getRestaurante(rnombre).getMenu().getPlatoPrincipal(pnombre).toString());
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsBebida(pnombre)) {
							vista.motrarInformacion(gestion.getRestaurante(rnombre).getMenu().getBebida(pnombre).toString());
						}
						else if(gestion.getRestaurante(rnombre).getMenu().containsPostre(pnombre)) {
							vista.motrarInformacion(gestion.getRestaurante(rnombre).getMenu().getPostre(pnombre).toString());
						}
					}
					else {
						vista.motrarInformacion("Este plato no existe.");
					}
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
			}
			else if(opcion==7) {
				String nombre=vista.leerLinea("Ingrese nombre del restaurante");
				if(gestion.containsRestaurante(nombre)) {
					vista.motrarInformacion(gestion.getRestaurante(nombre).mostrarCarta());
				}
				else {
					vista.motrarInformacion("Este restaurante no esta registrado.");
				}
			}
			else if(opcion==8) {
			vista.motrarInformacion("Gracias por utilizar el programa.");
			}
			else {
			vista.motrarInformacion("Opcion no valida.");
			}
		
		}
	}
	
}
