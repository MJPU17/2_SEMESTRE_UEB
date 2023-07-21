package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cilindro;
import co.edu.unbosque.model.Figura2D;
import co.edu.unbosque.model.Figura3D;
import co.edu.unbosque.model.FiguraGeometrica;
import co.edu.unbosque.view.VistaConsola;
import co.edu.unbosque.view.VistaVentana;

public class Controller  {
	
	
	private VistaConsola vista;
	private VistaVentana vista2;
	
	public Controller() {
		vista= new VistaConsola();
		vista2= new VistaVentana();
		iniciarAplicacion();
	}
	
	public void iniciarAplicacion() {
		Cilindro c = new Cilindro(2.33 , 4.85);
		c.calcularVolumen();
		vista.mostrarInformacion("C1 Vol = "+c.getVolumen());
		
		FiguraGeometrica x;
		x = new Cilindro(2.33, 4.85);
		((Cilindro) x).calcularVolumen();
		vista.mostrarInformacion("C2 Vol = "+((Figura3D) x).getVolumen());
	}

}
