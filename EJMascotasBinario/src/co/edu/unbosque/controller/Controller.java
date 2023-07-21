package co.edu.unbosque.controller;

import co.edu.unbosque.model.VeterinariaDTO;
import co.edu.unbosque.view.View;

public class Controller {
	
	private VeterinariaDTO veterinaria;
	private View vista;
	
	public Controller() {
		veterinaria = new VeterinariaDTO();
		vista = new View();
		funcionar();
	}
	
	public void funcionar() {
		
		//veterinaria.getMascotaDAO().agregarMascota("Max", "Perro", veterinaria.getMascotas(), veterinaria.getFile());
		//veterinaria.getMascotaDAO().agregarMascota("Danger", "Gato", veterinaria.getMascotas(), veterinaria.getFile());
		//veterinaria.getMascotaDAO().agregarMascota("Juliana", "Culebra", veterinaria.getMascotas(), veterinaria.getFile());
		vista.mostrarInformacion(veterinaria.getMascotaDAO().verMascotas(veterinaria.getMascotas()));
		if(veterinaria.getMascotaDAO().eliminarMascota("Danger", veterinaria.getMascotas(), veterinaria.getFile())) {
			vista.mostrarInformacion(veterinaria.getMascotaDAO().verMascotas(veterinaria.getMascotas()));
		}else {
			vista.mostrarInformacion("Las mascota no se encuentra en la BD");
		}
	}

}
