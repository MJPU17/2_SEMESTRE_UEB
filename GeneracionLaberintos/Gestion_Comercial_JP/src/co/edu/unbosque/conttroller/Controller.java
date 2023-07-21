package co.edu.unbosque.conttroller;

import co.edu.unbosque.model.JefeZonaDTO;
import co.edu.unbosque.model.VendedorDTO;
import co.edu.unbosque.persistence.EmpleadoDAO;
import co.edu.unbosque.persistence.JefeZonaDAO;
import co.edu.unbosque.persistence.VendedorDAO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private EmpleadoDAO empleados;
	private VendedorDAO vendedores;
	private JefeZonaDAO jefes;
	
	public Controller() {
		vista=new VistaConsola();
		empleados=new EmpleadoDAO();
		vendedores=new VendedorDAO();
		jefes=new JefeZonaDAO();
		funcionar();
	}

	public void funcionar() {
		StringBuilder menu=new StringBuilder("GESTION COMERCIAL\n");
		menu.append("1) Contratar Vendedor.\n");
		menu.append("2) Contratar Jefe de Zona.\n");
		menu.append("3) Asignar Vendedor a zona.\n");
		menu.append("4) Consultar datos de jefe por zona.\n");
		menu.append("5) Despedir Vendedor.\n");
		menu.append("6) Despedir Jefe de Zona.\n");
		menu.append("7) Imprimir datos Vendedor segun cedula.\n");
		menu.append("8) Imprimir Todos los Vendedores.\n");
		menu.append("9) Imprimir Todos los Jefes de Zona.\n");
		menu.append("10) Salir.\n");
		
		int opcion=0;
		
		do {
			vista.mostrarInformacion(menu.toString());
			opcion=vista.leerEntero("Ingrese una opcion: ");
			switch (opcion) {
			case 1: {
				long cedula=0;
				do {
					cedula=vista.leerEnteroGrande("Ingrese cedula: ");
					vista.quemarLinea();
					if(empleados.getLempleados().containsKey(cedula)) {
						vista.mostrarInformacion("Esta cedula ya esta registrada.Intentelo de nuevo.");
					}
				}while(empleados.getLempleados().containsKey(cedula));
				String nombre=vista.leerLinea("Ingrese nombre: ");
				String cargo=vista.leerLinea("Ingrese cargo: ");
				long salario=vista.leerEnteroGrande("Ingrese salario: ");
				double comision=vista.leerDecimal("Ingrese comision: ");
				long ventas_mes=vista.leerEnteroGrande("Ingrese ventas al mes: ");
				empleados.crear(cedula, new VendedorDTO(cedula, nombre, cargo, salario, comision, ventas_mes));
				vendedores.crear(cedula, new VendedorDTO(cedula, nombre, cargo, salario, comision, ventas_mes));
				break;
			}
			case 2:{
				long cedula=0;
				do {
					cedula=vista.leerEnteroGrande("Ingrese cedula: ");
					vista.quemarLinea();
					if(empleados.getLempleados().containsKey(cedula)) {
						vista.mostrarInformacion("Esta cedula ya esta registrada.Intentelo de nuevo.");
					}
				}while(empleados.getLempleados().containsKey(cedula));
				String nombre=vista.leerLinea("Ingrese nombre: ");
				String cargo=vista.leerLinea("Ingrese cargo: ");
				long salario=vista.leerEnteroGrande("Ingrese salario: ");
				vista.quemarLinea();
				String zona=vista.leerLinea("Ingrese zona: ");
				empleados.crear(cedula, new JefeZonaDTO(cedula, nombre, cargo, salario, zona));
				jefes.crear(zona, new JefeZonaDTO(cedula, nombre, cargo, salario, zona));
				break;
			}
			case 3:{
				if(jefes.getLjefezona().size()>0) {
					long cedula=vista.leerEnteroGrande("Ingrse cedula del vendedor: ");
					vista.quemarLinea();
					if(vendedores.getLvendedores().containsKey(cedula)) {
						vista.mostrarInformacionSinSalto("Zonas dispnibles: ");
						int i=1;
						for(String llave: jefes.getLjefezona().keySet()) {
							vista.mostrarInformacionSinSalto(llave);
							vista.mostrarInformacionSinSalto(i!=jefes.getLjefezona().size()?",":".\n");
						}
						String zona=vista.leerLinea("Ingrese la zona a la que va asignar el vendedor.");
						if(jefes.getLjefezona().containsKey(zona)) {
							jefes.getLjefezona().get(zona).agregarVendedor(cedula);
						}
						else {
							vista.mostrarInformacion("La zona ingresada no existe.\n");
						}
					}
					else {
						vista.mostrarInformacion("La cedula ingresada no pertenece a ningun vendedor.\n");
					}
				}
				else {
					vista.mostrarInformacion("Porfavor ingrese primero un jefe de zona.\n");
				}
				break;
			}
			case 4:{
				vista.quemarLinea();
				String zona=vista.leerLinea("Ingrese la zona asignada al vendedor.");
				if(jefes.getLjefezona().containsKey(zona)) {
					vista.mostrarInformacion(jefes.getLjefezona().get(zona).toString());
				}
				else {
					vista.mostrarInformacion("La zona ingresada no existe.\n");
				}
				
				break;
			}
			case 5:{
				long cedula=vista.leerEnteroGrande("Ingrese la cedula del vendedor.");
				vista.quemarLinea();
				if(vendedores.getLvendedores().containsKey(cedula)) {
					int index=0;
					for(String zona: jefes.getLjefezona().keySet()) {
						index=jefes.getLjefezona().get(zona).indexVendedor(cedula);
						if(index!=-1) {
							jefes.getLjefezona().get(zona).eliminarVendedor(index);
							break;
						}
					}
					vendedores.eliminar(cedula);
					vista.mostrarInformacion("El vendedor ha sido eliminado con exito.");
				}
				else {
					vista.mostrarInformacion("La cedula ingresada no pertenece a ningun vendedor.");
				}
				break;
			}
			case 6:{
				long cedula=vista.leerEnteroGrande("Ingrese la cedula del jefe de zona.");
				vista.quemarLinea();
				if(empleados.getLempleados().containsKey(cedula)&&empleados.getLempleados().get(cedula) instanceof JefeZonaDTO) {
					JefeZonaDTO aux=(JefeZonaDTO)empleados.getLempleados().get(cedula);
					jefes.eliminar(aux.getZona());
					empleados.eliminar(cedula);
					vista.mostrarInformacion("El jefe de zona ha sido eliminado con exito.\n");
				}
				else {
					vista.mostrarInformacion("La cedula ingresada no pertenece a ningun jefe de zona.\n");
				}
				break;
			}
			case 7:{
				long cedula=vista.leerEnteroGrande("Ingrese cedula: ");
				vista.quemarLinea();
				if(vendedores.getLvendedores().containsKey(cedula)) {
					vista.mostrarInformacion(vendedores.getLvendedores().get(cedula).toString());
				}
				else {
					vista.mostrarInformacion("La cedula ingresada no corresponde a ningun vendedor.\n");
				}
				break;
			}
			case 8:{
				vista.mostrarInformacion(vendedores.getLvendedores().size()>0?vendedores.mostrar():"No se ha ingresado ningun vendedor.\n");
				break;
			}
			case 9:{
				vista.mostrarInformacion(jefes.getLjefezona().size()>0?jefes.mostrar():"No se ha ingresado ningun jefe.\n");
				break;
			}
			case 10:{
				vista.mostrarInformacion("Gracias por utilizar el programa.");
				break;
			}
			default:{
				vista.mostrarInformacion("Opcion invalida.\n");
			}
				
			}
			
		}while (opcion!=10);
		
	}

}
