package co.edu.unbosque.controller;

import co.edu.unbosque.model.FiestaDAO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private FiestaDAO fiestas;
	
	public Controller() {
		vista=new VistaConsola();
		fiestas=new FiestaDAO();
		funcionar();
	}
	
	public void funcionar() {
		int opcion=0;
		do {
			vista.mostrarInformacion("PARCIAL 2\n\n1)Listar fiestas.\n2)Total invitados todas las fiestas.\n3)Total horas todas las fiestas.\n4)Total horas por rango.\n5)Mayor valor pagado.\n6)Menor valor pagado.\n7)Salir.\n");
			opcion=vista.leerEntero("Ingrese opcion: ");
			switch (opcion) {
			case 1: {
				vista.mostrarInformacion(fiestas.mostrar());
				break;
			}
			case 2:{
				vista.mostrarInformacion("Total invitados: "+fiestas.totalInvitados()+"\n");
				break;
			}
			case 3:{
				vista.mostrarInformacion("Total horas: "+fiestas.totalHoras()+"\n");
				break;
			}
			case 4:{
				int [] horas=fiestas.totalFiestas();
				vista.mostrarInformacion("Total fiestas 1 a 3 horas: "+horas[0]);
				vista.mostrarInformacion("Total fiestas 4 a 6 horas: "+horas[1]);
				vista.mostrarInformacion("Total fiestas mas 6 horas: "+horas[2]+"\n");
				break;
			}
			case 5:{
				vista.mostrarInformacion("Mayor valor pagado: "+fiestas.mayorValorPagado()+"\n");
				break;
			}
			case 6:{
				vista.mostrarInformacion("Menor valor pagado: "+fiestas.menorValorPagado()+"\n");
			}
			case 7:{
				vista.mostrarInformacion("Gracias por utilizar el programa.");
				break;
			}
			default:
				vista.mostrarInformacion("Opcion invalida.\n");
			}
		}while(opcion!=7);
	}
}
