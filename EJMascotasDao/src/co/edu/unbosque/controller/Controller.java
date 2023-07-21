package co.edu.unbosque.controller;

import co.edu.unbosque.model.VeterinariaDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VeterinariaDTO veterinaria;
	private VistaConsola vista;
	
	public Controller() {
		veterinaria = new VeterinariaDTO();
		vista = new VistaConsola();
		funcionar();
	}
	
	public void funcionar() {
		
		String aux_n = vista.leerDato("Ingrese nombre mascota: ");
		String aux_t = vista.leerDato("Ingrese tipo mascota: ");
		
		
		veterinaria.getMascotaDAO().agregarMascota(aux_n, aux_t, veterinaria.getMascotas());
		
		veterinaria.getMascotaDAO().agregarMascota("Danger", "Gato", veterinaria.getMascotas());
		
		veterinaria.getMascotaDAO().agregarMascota("Juliana", "Culebra", veterinaria.getMascotas());
		
		vista.mostrarInformacion(veterinaria.getMascotaDAO().verMascotas(veterinaria.getMascotas()));
		
		if(veterinaria.getMascotaDAO().eliminarMascota("Danger", veterinaria.getMascotas())) {
			vista.mostrarInformacion(veterinaria.getMascotaDAO().verMascotas(veterinaria.getMascotas()));
		}else {
			vista.mostrarInformacion("Las mascota no se encuentra en la BD");
		}
		
		if(veterinaria.getMascotaDAO().modificarMascota("Juliana", "Tigre" , veterinaria.getMascotas())) {
			vista.mostrarInformacion(veterinaria.getMascotaDAO().verMascotas(veterinaria.getMascotas()));
		}else {
			vista.mostrarInformacion("Las mascota no se encuentra en la BD");
		}
		
	}

}
