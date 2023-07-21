package co.edu.unbosque.controller;

import java.util.Properties;

import co.edu.unbosque.model.persitence.FileHandler;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private Properties propiedades;
	private VentanaPrincipal vp;
	 
	
	public Controller() {
		vista=new VistaConsola();
		propiedades=new Properties();
		vp=new VentanaPrincipal();
		vp.setVisible(true);
	}
	
	public void run() {
		int n=vista.leerEntero("Bienvenido al traductor\n\n1)Español\n2)Aleman\n3)Frances\n4)Ingles\n5)Ruso",true);
		switch (n) {
		case 1: {
			propiedades=FileHandler.cargarPropiedades("espaniol.properties");
			break;
		}
		case 2:{
			propiedades=FileHandler.cargarPropiedades("aleman.properties");
			break;
		}
		case 3:{
			propiedades=FileHandler.cargarPropiedades("Frances.properties");
			break;
		}
		case 4:{
			propiedades=FileHandler.cargarPropiedades("ingles.properties");
			break;
		}
		case 5:{
			propiedades=FileHandler.cargarPropiedades("ruso.properties");
			break;
		}
		default:
			System.out.println("Lenguaje no valido");
			System.exit(0);
		}
		vista.imprimirConSalto(propiedades.getProperty("traductor.menu.textobienvenida"));
		vista.imprimirConSalto(propiedades.getProperty("traductor.menu.preguntaaccion"));
	}

}
