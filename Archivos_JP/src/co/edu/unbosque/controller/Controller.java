package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	
	public Controller() {
		vista=new VistaConsola();
		funcionar();
	}
	
	public void funcionar() {
		int opcion=0;
		while(opcion!=3) {
			vista.mostrarInformacion("MANEJO ARCHIVOS\n1)Escribir en archivo\n2)Mostrar archivo.");
			opcion=vista.leerEntero("\nIngrese opcion.");
			if(opcion==1) {
				vista.quemarLinea();
				ArrayList<String>lines=new ArrayList<>();
				String [] charge=FileHandler.leerArchivoTexto("informacion.txt").split("\n");
				lines.addAll(Arrays.asList(charge));
				String line=vista.leerLinea("Ingrese linea: ");
				while(!line.equals("Cerrar")) {
					lines.add(line);
					line=vista.leerLinea("Ingrese linea: ");
				}
				FileHandler.escribirArchivoTexto("informacion.txt", lines);
			}
			else if(opcion==2) {
				String [] lines=FileHandler.leerArchivoTexto("informacion.txt").split("\n");
				
				for(String line: lines) {
					vista.mostrarInformacion(Arrays.asList(line.split("\\s+")).toString());
				}
			}
		}
	}

}
