package co.edu.unbosque.view;

import java.util.Properties;

import javax.swing.JFrame;

import co.edu.unbosque.model.persitence.FileHandler;

public class VentanaPrincipal extends JFrame{
	
	private Properties prop;
	
	public VentanaPrincipal() {
		prop=FileHandler.cargarPropiedades("configventanaprincipal.properties");
		setTitle(prop.getProperty("traductor.ventanaprincipal.titulo"));
		setBounds(100, 100, Integer.parseInt(prop.getProperty("traductor.ventanaprincipal..configuracion.anchura")), 
				Integer.parseInt(prop.getProperty("traductor.ventanaprincipal..configuracion.altura")));
		setLayout(null);
	
	}

}
